/**
 * 
 */
package dev.paie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.RemunerationEmployeDateMatriculeGradeDto;
import dev.paie.dto.RemunerationEmployeDto;
import dev.paie.dto.ajoutEmployeDto;
import dev.paie.exception.MatriculeInvalideException;
import dev.paie.service.RemunerationEmployeService;

/**
 * @author Guillaume
 *
 */
@RestController
public class RemunerationEmployeController {

	@Autowired
	private RemunerationEmployeService service;

	/**
	 * @return la liste de tous les matricule, grades et date de créations de tous
	 *         les employés
	 */
	@GetMapping(value = "/employes")
	public List<RemunerationEmployeDateMatriculeGradeDto> getListeEmployes() {
		return service.recupererTousRemunerationEmploye().stream().map(
				r -> new RemunerationEmployeDateMatriculeGradeDto(r.getMatricule(), r.getGrade(), r.getDateCreation()))
				.collect(Collectors.toList());

	}

	/**
	 * @param employe : prend en parametre un objet de type ajoutEmployeDto récupéré
	 *                depuis un Json pour
	 * @return
	 */
	@PostMapping(value = "/employes")
	public ResponseEntity<RemunerationEmployeDto> postNouvelEmploye(@RequestBody ajoutEmployeDto employe) {
		try {
			return new ResponseEntity<>(service.ajouterEmploye(employe), HttpStatus.CREATED);
		} catch (MatriculeInvalideException e) {
			return ResponseEntity.notFound().header("Erreur", e.getErreur()).build();
		}
	}

}
