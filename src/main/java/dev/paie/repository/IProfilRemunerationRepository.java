/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.ProfilRemuneration;

/**
 * @author Guillaume
 *
 */
public interface IProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, Integer> {

	public ProfilRemuneration findByCode(String code);

}
