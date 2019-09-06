package dev.paie.entites;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "remuneration_employe")
public class RemunerationEmploye {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String matricule;
	@ManyToOne
	@JoinColumn
	private Entreprise entreprise;
	@ManyToOne
	@JoinColumn
	private ProfilRemuneration profilRemuneration;
	@ManyToOne
	@JoinColumn
	private Grade grade;
	private ZonedDateTime dateCreation;
	@OneToOne
	private InfosConnexion infosConnexion;

	public RemunerationEmploye(Integer id, String matricule, Entreprise entreprise,
			ProfilRemuneration profilRemuneration, Grade grade, ZonedDateTime dateCreation) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
		this.dateCreation = dateCreation;
	}

	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade, ZonedDateTime dateCreation, InfosConnexion infosConnexion) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
		this.dateCreation = dateCreation;
		this.infosConnexion = infosConnexion;
	}

	public RemunerationEmploye() {
		super();
	}

	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((entreprise == null) ? 0 : entreprise.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((infosConnexion == null) ? 0 : infosConnexion.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((profilRemuneration == null) ? 0 : profilRemuneration.hashCode());
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
		RemunerationEmploye other = (RemunerationEmploye) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (entreprise == null) {
			if (other.entreprise != null)
				return false;
		} else if (!entreprise.equals(other.entreprise))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (infosConnexion == null) {
			if (other.infosConnexion != null)
				return false;
		} else if (!infosConnexion.equals(other.infosConnexion))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (profilRemuneration == null) {
			if (other.profilRemuneration != null)
				return false;
		} else if (!profilRemuneration.equals(other.profilRemuneration))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RemunerationEmploye [id=" + id + ", matricule=" + matricule + ", entreprise=" + entreprise
				+ ", profilRemuneration=" + profilRemuneration + ", grade=" + grade + ", dateCreation=" + dateCreation
				+ ", infosConnexion=" + infosConnexion + "]";
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
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the entreprise
	 */
	public Entreprise getEntreprise() {
		return entreprise;
	}

	/**
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * @return the profilRemuneration
	 */
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	/**
	 * @param profilRemuneration the profilRemuneration to set
	 */
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * @return the dateCreation
	 */
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the infosConnexion
	 */
	public InfosConnexion getInfosConnexion() {
		return infosConnexion;
	}

	/**
	 * @param infosConnexion the infosConnexion to set
	 */
	public void setInfosConnexion(InfosConnexion infosConnexion) {
		this.infosConnexion = infosConnexion;
	}

	/**
	 * Fixe la date de creation d'un employe
	 */
	@PrePersist
	public void fixerDateCreation() {
		this.dateCreation = ZonedDateTime.now();
	}

}
