package dev.paie.entites;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
				+ "]";
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	 * Fixe la date de creation d'un employe
	 */
	@PrePersist
	public void fixerDateCreation() {
		this.dateCreation = ZonedDateTime.now();
	}

}
