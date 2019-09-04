/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.Periode;

/**
 * @author Guillaume
 *
 */
public interface IPeriodeRepository extends JpaRepository<Periode, Integer> {

}
