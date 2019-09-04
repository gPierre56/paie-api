/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entites.Periode;
import dev.paie.repository.IPeriodeRepository;

/**
 * @author Guillaume
 *
 */
@Service
public class PeriodeService {

	@Autowired
	private IPeriodeRepository repository;

	/**
	 * @return renvoie la liste de toutes les péiodes enregistrées en base
	 */
	public List<Periode> recupererToutesLesPeriodes() {
		return repository.findAll();
	}

}
