/**
 * 
 */
package dev.paie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.GradeDto;
import dev.paie.service.GradeService;

/**
 * @author Guillaume Classe qui gère les RESSOURCES concernant l'entité grade
 *
 */
@RestController
public class GradeController {

	/**
	 * Injection de la classe de service pour les grades
	 */
	@Autowired
	private GradeService service;

	/**
	 * @return renvoie la liste de tous les grades existants en base de données
	 */
	@GetMapping(value = "/grades")
	public List<GradeDto> getAllGrades() {
		return service.recupererTousLesGrades();
	}

}
