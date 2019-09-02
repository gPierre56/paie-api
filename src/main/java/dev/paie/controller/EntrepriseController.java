/**
 * 
 */
package dev.paie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.EntrepriseDto;
import dev.paie.service.EntrepriseService;

/**
 * @author Guillaume Classe qui régit l'affichage des vues concernant les
 *         entreprises
 */
@RestController
@RequestMapping(value = "/entreprises")
public class EntrepriseController {

	/**
	 * Injection de la classe de service
	 */
	@Autowired
	private EntrepriseService service;

	/**
	 * @return renvoie les codes et dénominations de toutes les entreprises en bdd
	 */
	@GetMapping
	public ResponseEntity<List<EntrepriseDto>> getAllEntreprises() {

		return new ResponseEntity<>(service.recupCodeEtDenomination(), HttpStatus.OK);

	}

}
