/**
 * 
 */
package dev.paie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.RemunerationEmploye;

/**
 * @author Guillaume
 *
 */
public interface IRemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Integer> {

	public RemunerationEmploye findByMatricule(String matricule);

	public Optional<RemunerationEmploye> findByInfosConnexionNomUtilisateur(String nomUtilisateur);

}
