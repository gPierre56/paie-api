/**
 * 
 */
package dev.paie.dto;

import java.time.ZonedDateTime;

import dev.paie.entites.Grade;

/**
 * @author Guillaume
 *
 */
public class RemunerationEmployeDateMatriculeGradeDto {

	private String matricule;
	private Grade grade;
	private ZonedDateTime dateCreation;

	public RemunerationEmployeDateMatriculeGradeDto(String matricule, Grade grade, ZonedDateTime dateCreation) {
		super();
		this.matricule = matricule;
		this.grade = grade;
		this.dateCreation = dateCreation;
	}

	public RemunerationEmployeDateMatriculeGradeDto() {
		super();
	}

	@Override
	public String toString() {
		return "RemunerationEmployeDateMatriculeGradeDto [matricule=" + matricule + ", grade=" + grade
				+ ", dateCreation=" + dateCreation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
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
		RemunerationEmployeDateMatriculeGradeDto other = (RemunerationEmployeDateMatriculeGradeDto) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
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
