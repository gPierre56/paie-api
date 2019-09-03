/**
 * 
 */
package dev.paie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.dto.GradeDto;
import dev.paie.repository.IGradeRepository;

/**
 * @author Guillaume
 *
 */
@Service
public class GradeService {

	@Autowired
	private IGradeRepository repository;

	/**
	 * @return la liste des grades sans l'id de la base
	 */
	public List<GradeDto> recupererTousLesGrades() {
		return repository.findAll().stream().map(g -> new GradeDto(g.getCode(), g.getNbHeuresBase(), g.getTauxBase()))
				.collect(Collectors.toList());
	}

}
