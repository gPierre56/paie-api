/**
 * 
 */
package dev.paie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.ProfilRemunerationDto;
import dev.paie.service.ProfilRemunerationService;

/**
 * @author Guillaume
 *
 */
@RestController
public class ProfilRemunerationController {

	@Autowired
	private ProfilRemunerationService service;

	/**
	 * @return renvoie un JSON avec toute la liste des profils de rémunération
	 *         contenus en base de données
	 */
	@GetMapping(value = "/profil_remunerations")
	public List<ProfilRemunerationDto> getAllProfilRemuneration() {
		return service.recupererIdEtCode();
	}

}
