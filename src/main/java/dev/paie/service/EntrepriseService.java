/**
 * 
 */
package dev.paie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.dto.EntrepriseDto;
import dev.paie.repository.IEntrepriseRepository;

/**
 * @author Guillaume
 *
 */
@Service
public class EntrepriseService {

	/**
	 * Injecte une instance du repository des entreprises qui interagit avec la bdd
	 */
	@Autowired
	private IEntrepriseRepository repository;

	/**
	 * @return la liste de toutes les entreprises existantes en base
	 */
	public List<EntrepriseDto> recupCodeEtDenomination() {
		return repository.findAll().stream().map(e -> new EntrepriseDto(e.getCode(), e.getDenomination()))
				.collect(Collectors.toList());
	}

}
