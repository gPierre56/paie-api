/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.Entreprise;

/**
 * @author Guillaume
 *
 */
public interface IEntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
