/**
 * 
 */
package dev.paie.entites;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Guillaume
 *
 */
@Entity
@Table(name = "INFOS_CONNEXION")
public class InfosConnexion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomUtilisateur;
	private String motDePasse;
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Role> roles;

	public InfosConnexion(Integer id, String nomUtilisateur, String motDePasse, List<Role> roles) {
		super();
		this.id = id;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.roles = roles;
	}

	public InfosConnexion(String nomUtilisateur, String motDePasse, List<Role> roles) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.roles = roles;
	}

	public InfosConnexion() {
		super();
	}

	@Override
	public String toString() {
		return "InfosConnexion [id=" + id + ", nomUtilisateur=" + nomUtilisateur + ", motDePasse=" + motDePasse
				+ ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((nomUtilisateur == null) ? 0 : nomUtilisateur.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfosConnexion other = (InfosConnexion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nomUtilisateur == null) {
			if (other.nomUtilisateur != null)
				return false;
		} else if (!nomUtilisateur.equals(other.nomUtilisateur))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
