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

import dev.paie.dto.AjoutBulletinSalaireDto;
import dev.paie.dto.BulletinSalaireDto;
import dev.paie.dto.TraitementSalaireDto;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exception.MatriculeInvalideException;
import dev.paie.repository.IBulletinSalaireRepository;
import dev.paie.repository.IPeriodeRepository;
import dev.paie.repository.IRemunerationEmployeRepository;

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
			for (int j = 0; j < recuperation.get(i).getCotisationsBrutes().size(); j++) {
				if (recuperation.get(i).getCotisationsBrutes().get(j).getImposable()) {
					recuperation.get(i).getCotisationsImposables()
							.add(recuperation.get(i).getCotisationsBrutes().get(j));
				} else {
					recuperation.get(i).getCotisationsNonImposables()
							.add(recuperation.get(i).getCotisationsBrutes().get(j));
				}
			}
		}

		// on calcule le salaire brut
		for (int i = 0; i < recuperation.size(); i++) {
			if (recuperation.get(i).getPrimeExceptionelle() != null) {
				recuperation.get(i).setSalaireBrut((recuperation.get(i).getNbHeuresBase()
						.multiply(recuperation.get(i).getTauxBase()).add(recuperation.get(i).getPrimeExceptionelle())));
			} else {
				recuperation.get(i).setSalaireBrut(
						(recuperation.get(i).getNbHeuresBase().multiply(recuperation.get(i).getTauxBase())));
			}

		}

		// on calcule le salaire net imposable
		for (int i = 0; i < recuperation.size(); i++) {
			BigDecimal charges = BigDecimal.ZERO;
			for (int j = 0; j < recuperation.get(i).getCotisationsNonImposables().size(); j++) {

				if (recuperation.get(i).getCotisationsNonImposables().get(j).getTauxSalarial() != null) {
					charges = charges.add(recuperation.get(i).getCotisationsNonImposables().get(j).getTauxSalarial()
							.multiply(recuperation.get(i).getSalaireBrut()));

				}
				recuperation.get(i).setNetImposable(recuperation.get(i).getSalaireBrut().subtract(charges));
			}
		}

		// on calcule le net à payer
		for (int i = 0; i < recuperation.size(); i++) {

			BigDecimal charges = BigDecimal.ZERO;
			for (int j = 0; j < recuperation.get(i).getCotisationsImposables().size(); j++) {
				charges = charges.add(recuperation.get(i).getSalaireBrut()
						.multiply(recuperation.get(i).getCotisationsImposables().get(j).getTauxSalarial()));
			}

			recuperation.get(i).setNetAPayer(recuperation.get(i).getNetImposable().subtract(charges));

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

}
