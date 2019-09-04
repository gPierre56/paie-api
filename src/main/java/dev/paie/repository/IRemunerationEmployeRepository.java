/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.RemunerationEmploye;

/**
 * @author Guillaume
 *
 */
public interface IRemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Integer> {

	public RemunerationEmploye findByMatricule(String matricule);

}
