/**
 * 
 */
package dev.paie.dto;

import java.time.ZonedDateTime;

import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import dev.paie.entites.ProfilRemuneration;

/**
 * @author Guillaume
 *
 */
public class RemunerationEmployeDto {

	private String matricule;
	private Entreprise entreprise;
	private ProfilRemuneration profilRemuneration;
	private Grade grade;
	private ZonedDateTime dateCreation;

	public RemunerationEmployeDto(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade, ZonedDateTime dateCreation) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
		this.dateCreation = dateCreation;
	}

	public RemunerationEmployeDto() {
		super();
	}

	@Override
	public String toString() {
		return "RemunerationEmployeDto [matricule=" + matricule + ", entreprise=" + entreprise + ", profilRemuneration="
				+ profilRemuneration + ", grade=" + grade + ", dateCreation=" + dateCreation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((entreprise == null) ? 0 : entreprise.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
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
		RemunerationEmployeDto other = (RemunerationEmployeDto) obj;
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

}
