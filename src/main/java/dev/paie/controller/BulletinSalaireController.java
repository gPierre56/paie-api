/**
 * 
 */
package dev.paie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.AjoutBulletinSalaireDto;
import dev.paie.dto.BulletinSalaireDto;
import dev.paie.dto.DtoBulletinUnique;
import dev.paie.exception.MatriculeInvalideException;
import dev.paie.service.BulletinSalaireService;

/**
 * @author Guillaume
 *
 */
@RestController
public class BulletinSalaireController {

	@Autowired
	private BulletinSalaireService service;

	/**
	 * @return renvoie la liste calculée de tous les bulletins de salaire présents
	 *         en base
	 */
	@GetMapping(value = "/bulletins")
	public ResponseEntity<List<BulletinSalaireDto>> getAllBulletinsSalaire() {
		return new ResponseEntity<>(service.recupererTousLesBulletins(), HttpStatus.OK);

	}

	@PostMapping(value = "/bulletins")
	public ResponseEntity<BulletinSalaireDto> postNewBulletinSalaire(@RequestBody AjoutBulletinSalaireDto bulletin) {
		try {
			service.ajouterNouveauBulletin(bulletin);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (MatriculeInvalideException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/bulletins/{code}")
	public ResponseEntity<DtoBulletinUnique> getOneBulletinSalaire(@PathVariable String code) {
		return new ResponseEntity<>(service.trouverUnBulletin(code), HttpStatus.OK);
	}

}
