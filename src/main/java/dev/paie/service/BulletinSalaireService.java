/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.paie.dto.AjoutBulletinSalaireDto;
import dev.paie.dto.BulletinSalaireDto;
import dev.paie.dto.CollegueDto;
import dev.paie.dto.CollegueDtoBulletinSalaire;
import dev.paie.dto.CotisationsImposablesDto;
import dev.paie.dto.CotisationsNonImposablesDto;
import dev.paie.dto.DtoBulletinUnique;
import dev.paie.dto.EntrepriseDtoBulletinSalaire;
import dev.paie.dto.SalaireBrutDto;
import dev.paie.dto.TableauCotisationsImposablesDto;
import dev.paie.dto.TableauCotisationsNonImposablesDto;
import dev.paie.dto.TraitementSalaireDto;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Cotisation;
import dev.paie.entites.Periode;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exception.MatriculeInvalideException;
import dev.paie.repository.IBulletinSalaireRepository;
import dev.paie.repository.IPeriodeRepository;
import dev.paie.repository.IRemunerationEmployeRepository;
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

	public DtoBulletinUnique trouverUnBulletin(String code) {
		RestTemplate rt = new RestTemplate();
		BulletinSalaire bulletinBrut = repository.findByCode(code);
		DtoBulletinUnique resultat = new DtoBulletinUnique();
		resultat.setEntreprise(
				new EntrepriseDtoBulletinSalaire(bulletinBrut.getRemunerationEmploye().getEntreprise().getCode(),
						bulletinBrut.getRemunerationEmploye().getEntreprise().getDenomination(),
						bulletinBrut.getRemunerationEmploye().getEntreprise().getSiret()));
		CollegueDto employe = rt.getForObject("https://guillaume-top-collegues.herokuapp.com/collegue/"
				.concat(bulletinBrut.getRemunerationEmploye().getMatricule()), CollegueDto.class);

		resultat.setEmploye(new CollegueDtoBulletinSalaire(employe.getMatricule(), employe.getNom(),
				employe.getPrenom(), employe.getDateDeNaissance()));

		resultat.setPeriode(bulletinBrut.getPeriode());
		resultat.setSalaireBrut(new SalaireBrutDto(bulletinBrut.getRemunerationEmploye().getGrade().getNbHeuresBase(),
				bulletinBrut.getRemunerationEmploye().getGrade().getTauxBase()));
		if (bulletinBrut.getPrimeExceptionnelle() != null
				&& !bulletinBrut.getPrimeExceptionnelle().equals(BigDecimal.ZERO)) {
			resultat.getSalaireBrut().setSalaireBrut(
					resultat.getSalaireBrut().getSalaireBrut().add(bulletinBrut.getPrimeExceptionnelle()));
		}
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
				retenue, resultat.getSalaireBrut().getSalaireBrut().subtract(retenue)));

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
			retenue2 = retenue2Optional.get();
		}

		resultat.setTableauCotisationsImposablesDto(new TableauCotisationsImposablesDto(cotisationsImposablesDto,
				resultat.getTableauCotisationsNonImposables().getNetImposable().subtract(retenue2)));

		return resultat;

	}

}
