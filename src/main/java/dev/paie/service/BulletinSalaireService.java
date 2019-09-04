/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.dto.AjoutBulletinSalaireDto;
import dev.paie.dto.BulletinSalaireDto;
import dev.paie.dto.CotisationsImposablesDto;
import dev.paie.dto.CotisationsNonImposablesDto;
import dev.paie.dto.DtoBulletinUnique;
import dev.paie.dto.TableauCotisationsImposablesDto;
import dev.paie.dto.TableauCotisationsNonImposablesDto;
import dev.paie.dto.TraitementSalaireDto;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Cotisation;
import dev.paie.entites.Periode;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exception.BulletinNonTrouveException;
import dev.paie.exception.MatriculeInvalideException;
import dev.paie.repository.IBulletinSalaireRepository;
import dev.paie.repository.IPeriodeRepository;
import dev.paie.repository.IRemunerationEmployeRepository;
import dev.paie.utils.AffectationDtoBulletin;
import dev.paie.utils.CalculSalaire;

/**
 * @author Guillaume
 *
 */
@Service
public class BulletinSalaireService {

	@Autowired
	private IBulletinSalaireRepository repository;

	@Autowired
	private IPeriodeRepository periodeRepository;

	@Autowired
	private IRemunerationEmployeRepository employeRepository;

	@Autowired
	private CalculSalaire calcul;

	@Autowired
	private AffectationDtoBulletin affectation;

	/**
	 * @return Récupère la liste de toutes les informations stockées en base
	 *         nécessaire à l'édition d'un bulletin de salaire. Après traitements et
	 *         calculs, renvoie un objet de type DTO avec les informations
	 *         demandées.
	 */
	public List<BulletinSalaireDto> recupererTousLesBulletins() {

		// on récupère les informations dont on a besoin pour le traitement dans une
		// liste
		List<TraitementSalaireDto> recuperation = repository.findAll().stream()
				.map(b -> new TraitementSalaireDto(b.getDateCreation(), b.getPeriode(),
						b.getRemunerationEmploye().getMatricule(),
						b.getRemunerationEmploye().getGrade().getNbHeuresBase(),
						b.getRemunerationEmploye().getGrade().getTauxBase(),
						b.getRemunerationEmploye().getProfilRemuneration().getCotisations(),
						b.getPrimeExceptionnelle()))
				.collect(Collectors.toList());

		// on scinde les cotisations en deux listes séparés, imposables et non
		// imposables
		for (int i = 0; i < recuperation.size(); i++) {
			calcul.separerCotisations(recuperation.get(i));
		}

		// on calcule le salaire brut
		for (int i = 0; i < recuperation.size(); i++) {
			calcul.calculerSalaireBrut(recuperation.get(i));

		}

		// on calcule le salaire net imposable
		for (int i = 0; i < recuperation.size(); i++) {
			calcul.calculSalaireNet(recuperation.get(i));
		}

		// on calcule le net à payer
		for (int i = 0; i < recuperation.size(); i++) {

			calcul.calculNetAPayer(recuperation.get(i));

		}

		// on transforme la liste d'objets utilisés pour le traitement en une nouvelle
		// liste d'objets destinés à l'affichage
		return recuperation.stream().map(r -> new BulletinSalaireDto(r.getDateCreation(), r.getPeriode(),
				r.getMatricule(), r.getSalaireBrut(), r.getNetImposable(), r.getNetAPayer()))
				.collect(Collectors.toList());

	}

	/**
	 * @param prend en parametre un objet de type AjoutBulletinSalaireDto
	 * @throws MatriculeInvalideException lance une exception si aucun matricule n'a
	 *                                    été trouvé
	 */
	public void ajouterNouveauBulletin(AjoutBulletinSalaireDto input) throws MatriculeInvalideException {
		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setCode(UUID.randomUUID().toString());

		bulletin.setPrimeExceptionnelle(BigDecimal.valueOf(input.getPrimeExceptionelle()));

		Optional<Periode> periode = periodeRepository.findById(input.getPeriode());
		if (periode.isPresent()) {
			bulletin.setPeriode(periode.get());
		}
		RemunerationEmploye employe = employeRepository.findByMatricule(input.getMatricule());
		if (employe != null) {
			bulletin.setRemunerationEmploye(employe);
		} else {
			throw new MatriculeInvalideException("Matricule introuvable");
		}
		repository.save(bulletin);

	}

	/**
	 * @param code Cette méthode prend en paramètre un code correspondant au
	 *             bulletin de salaire demandé et sur lequel vont être effectués les
	 *             calculs
	 * @return La méthode retourne un objet de type DtoBulletinUnique qui correspond
	 *         aux données dont aura besoin l'interface pour afficher tous les
	 *         détails et données calculés d'un bulletin de salaire
	 * @throws BulletinNonTrouveException La méthode renvoie une exception si un
	 *                                    code inconnu a été renseigné dans l'url
	 */
	public DtoBulletinUnique trouverUnBulletin(String code) throws BulletinNonTrouveException {
		BulletinSalaire bulletinBrut = repository.findByCode(code);
		if (bulletinBrut == null) {
			throw new BulletinNonTrouveException("Aucun bulletin de salaire correspondant à ce code n'a été trouvé.");
		}
		DtoBulletinUnique resultat = new DtoBulletinUnique();
		affectation.affecterEntreprise(resultat, bulletinBrut);
		affectation.affecterEmploye(resultat, bulletinBrut);
		affectation.affecterPeriode(resultat, bulletinBrut);

		affectation.affecterSalaireBrut(resultat, bulletinBrut);
		List<Cotisation> cotisationsNonImposables = bulletinBrut.getRemunerationEmploye().getProfilRemuneration()
				.getCotisations().stream().filter(c -> !c.getImposable()).collect(Collectors.toList());

		List<CotisationsNonImposablesDto> cotisationsNonImposablesDto = cotisationsNonImposables.stream().peek(c -> {
			if (c.getTauxSalarial() == null) {
				c.setTauxSalarial(BigDecimal.ZERO);
			}
			if (c.getTauxPatronal() == null) {
				c.setTauxPatronal(BigDecimal.ZERO);
			}
		}).map(c -> new CotisationsNonImposablesDto(c.getLibelle(), resultat.getSalaireBrut().getSalaireBrut(),
				c.getTauxSalarial(), resultat.getSalaireBrut().getSalaireBrut().multiply(c.getTauxSalarial()),
				c.getTauxPatronal(), c.getTauxPatronal().multiply(resultat.getSalaireBrut().getSalaireBrut())))
				.collect(Collectors.toList());
		BigDecimal retenue = BigDecimal.ZERO;
		Optional<BigDecimal> retenueOptional = cotisationsNonImposablesDto.stream().map(c -> c.getMontantSalarial())
				.reduce((c1, c2) -> (c1.add(c2)));
		if (retenueOptional.isPresent()) {
			retenue = retenueOptional.get();
		}

		resultat.setTableauCotisationsNonImposables(new TableauCotisationsNonImposablesDto(cotisationsNonImposablesDto,
				retenue,
				resultat.getSalaireBrut().getSalaireBrut().subtract(retenue).setScale(2, RoundingMode.HALF_UP)));

		List<Cotisation> cotisationsImposables = bulletinBrut.getRemunerationEmploye().getProfilRemuneration()
				.getCotisations().stream().filter(c -> c.getImposable()).collect(Collectors.toList());

		List<CotisationsImposablesDto> cotisationsImposablesDto = cotisationsImposables.stream()
				.map(c -> new CotisationsImposablesDto(c.getLibelle(), resultat.getSalaireBrut().getSalaireBrut(),
						c.getTauxSalarial(), resultat.getSalaireBrut().getSalaireBrut().multiply(c.getTauxSalarial()),
						null, null))
				.collect(Collectors.toList());

		BigDecimal retenue2 = BigDecimal.ZERO;
		Optional<BigDecimal> retenue2Optional = cotisationsImposablesDto.stream().map(c -> c.getMontantSalarial())
				.reduce((c1, c2) -> (c1.add(c2)));
		if (retenue2Optional.isPresent()) {
			retenue2 = retenue2Optional.get().setScale(2, RoundingMode.HALF_UP);
		}

		resultat.setTableauCotisationsImposablesDto(new TableauCotisationsImposablesDto(cotisationsImposablesDto,
				resultat.getTableauCotisationsNonImposables().getNetImposable().subtract(retenue2).setScale(2,
						RoundingMode.HALF_UP)));

		return resultat;

	}

}
