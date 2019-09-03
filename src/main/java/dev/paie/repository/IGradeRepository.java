/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.Grade;

/**
 * @author Guillaume
 *
 */
public interface IGradeRepository extends JpaRepository<Grade, Integer> {

	public Grade findByCode(String code);

}
