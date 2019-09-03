/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.BulletinSalaire;

/**
 * @author Guillaume
 *
 */
public interface IBulletinSalaireRepository extends JpaRepository<BulletinSalaire, String> {

}
