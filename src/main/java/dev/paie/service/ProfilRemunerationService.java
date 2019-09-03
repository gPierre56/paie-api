/**
 * 
 */
package dev.paie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.dto.ProfilRemunerationDto;
import dev.paie.repository.IProfilRemunerationRepository;

/**
 * @author Guillaume
 *
 */
@Service
public class ProfilRemunerationService {

	@Autowired
	private IProfilRemunerationRepository repository;

	/**
	 * @return la liste de tous les profils de rémunération
	 */
	public List<ProfilRemunerationDto> recupererIdEtCode() {
		return repository.findAll().stream().map(p -> new ProfilRemunerationDto(p.getCode(), p.getCotisations()))
				.collect(Collectors.toList());
	}

}
