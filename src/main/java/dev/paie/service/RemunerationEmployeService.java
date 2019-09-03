/**
 * 
 */
package dev.paie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import dev.paie.dto.RemunerationEmployeDto;
import dev.paie.dto.ajoutEmployeDto;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exception.MatriculeInvalideException;
import dev.paie.repository.IEntrepriseRepository;
import dev.paie.repository.IGradeRepository;
import dev.paie.repository.IProfilRemunerationRepository;
import dev.paie.repository.IRemunerationEmployeRepository;

/**
 * @author Guillaume
 *
 */
@Service
public class RemunerationEmployeService {

	@Autowired
	private IRemunerationEmployeRepository repository;

	@Autowired
	private IEntrepriseRepository entrepriseRepository;

	@Autowired
	private IGradeRepository gradeRepository;

	@Autowired
	private IProfilRemunerationRepository profilRepository;

	/**
	 * @return la liste de tous le employes en base sans leur ID
	 */
	public List<RemunerationEmployeDto> recupererTousRemunerationEmploye() {
		return repository.findAll().stream().map(r -> new RemunerationEmployeDto(r.getMatricule(), r.getEntreprise(),
				r.getProfilRemuneration(), r.getGrade(), r.getDateCreation())).collect(Collectors.toList());
	}

	/**
	 * Prend en parametre un matricule. Interroge l'api collègue. Renvoie true si la
	 * requete renvoie un code d'erreur 200 (qui correspond a un match de
	 * matricule), sinon false
	 */
	public Boolean validerMatricule(String matricule) {
		RestTemplate rt = new RestTemplate();
		String url = "https://guillaume-top-collegues.herokuapp.com/collegue/".concat(matricule);
		try {
			return rt.exchange(url, HttpMethod.GET, null, Object.class).getStatusCode().equals(HttpStatus.OK);
		} catch (RestClientException e) {
			return false;
		}

	}

	/**
	 * @param employe = prend en parametre un objet de type AjoutEmployeDto crée
	 *                pour la vue de l'ajout d'un employé
	 * @return retourne l'objet persisté en base sans id et avec une date de
	 *         création
	 * @throws MatriculeInvalideException déclenche une exception si aucun matricule
	 *                                    correspondant n'a été trouvé à la
	 *                                    validation
	 */
	public RemunerationEmployeDto ajouterEmploye(ajoutEmployeDto employe) throws MatriculeInvalideException {
		if (validerMatricule(employe.getMatricule())) {
			RemunerationEmploye entite = new RemunerationEmploye(employe.getMatricule(),
					entrepriseRepository.findByCode(employe.getCodeEntreprise()),
					profilRepository.findByCode(employe.getCodeProfil()),
					gradeRepository.findByCode(employe.getCodeGrade()));
			repository.save(entite);
			return new RemunerationEmployeDto(entite.getMatricule(), entite.getEntreprise(),
					entite.getProfilRemuneration(), entite.getGrade(), entite.getDateCreation());
		} else {
			throw new MatriculeInvalideException("Insertion impossible, aucun matricule correspondant n'a été trouvé.");
		}

	}

}
