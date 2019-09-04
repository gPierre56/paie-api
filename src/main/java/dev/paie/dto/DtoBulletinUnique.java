/**
 * 
 */
package dev.paie.dto;

import dev.paie.entites.Periode;

/**
 * @author Guillaume
 *
 */
public class DtoBulletinUnique {

	private EntrepriseDtoBulletinSalaire entreprise;
	private CollegueDtoBulletinSalaire employe;
	private Periode periode;
	private SalaireBrutDto salaireBrut;

	private TableauCotisationsNonImposablesDto tableauCotisationsNonImposables;
	private TableauCotisationsImposablesDto tableauCotisationsImposablesDto;

	public DtoBulletinUnique() {
		super();
	}

	public DtoBulletinUnique(EntrepriseDtoBulletinSalaire entreprise, CollegueDtoBulletinSalaire employe,
			Periode periode, SalaireBrutDto salaireBrut,
			TableauCotisationsNonImposablesDto tableauCotisationsNonImposables,
			TableauCotisationsImposablesDto tableauCotisationsImposablesDto) {
		super();
		this.entreprise = entreprise;
		this.employe = employe;
		this.periode = periode;
		this.salaireBrut = salaireBrut;
		this.tableauCotisationsNonImposables = tableauCotisationsNonImposables;
		this.tableauCotisationsImposablesDto = tableauCotisationsImposablesDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employe == null) ? 0 : employe.hashCode());
		result = prime * result + ((entreprise == null) ? 0 : entreprise.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime * result + ((salaireBrut == null) ? 0 : salaireBrut.hashCode());
		result = prime * result
				+ ((tableauCotisationsImposablesDto == null) ? 0 : tableauCotisationsImposablesDto.hashCode());
		result = prime * result
				+ ((tableauCotisationsNonImposables == null) ? 0 : tableauCotisationsNonImposables.hashCode());
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
		DtoBulletinUnique other = (DtoBulletinUnique) obj;
		if (employe == null) {
			if (other.employe != null)
				return false;
		} else if (!employe.equals(other.employe))
			return false;
		if (entreprise == null) {
			if (other.entreprise != null)
				return false;
		} else if (!entreprise.equals(other.entreprise))
			return false;
		if (periode == null) {
			if (other.periode != null)
				return false;
		} else if (!periode.equals(other.periode))
			return false;
		if (salaireBrut == null) {
			if (other.salaireBrut != null)
				return false;
		} else if (!salaireBrut.equals(other.salaireBrut))
			return false;
		if (tableauCotisationsImposablesDto == null) {
			if (other.tableauCotisationsImposablesDto != null)
				return false;
		} else if (!tableauCotisationsImposablesDto.equals(other.tableauCotisationsImposablesDto))
			return false;
		if (tableauCotisationsNonImposables == null) {
			if (other.tableauCotisationsNonImposables != null)
				return false;
		} else if (!tableauCotisationsNonImposables.equals(other.tableauCotisationsNonImposables))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtoBulletinUnique [entreprise=" + entreprise + ", employe=" + employe + ", periode=" + periode
				+ ", salaireBrut=" + salaireBrut + ", tableauCotisationsNonImposables="
				+ tableauCotisationsNonImposables + ", tableauCotisationsImposablesDto="
				+ tableauCotisationsImposablesDto + "]";
	}

	/**
	 * @return the entreprise
	 */
	public EntrepriseDtoBulletinSalaire getEntreprise() {
		return entreprise;
	}

	/**
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(EntrepriseDtoBulletinSalaire entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * @return the employe
	 */
	public CollegueDtoBulletinSalaire getEmploye() {
		return employe;
	}

	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(CollegueDtoBulletinSalaire employe) {
		this.employe = employe;
	}

	/**
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}

	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	/**
	 * @return the salaireBrut
	 */
	public SalaireBrutDto getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(SalaireBrutDto salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	/**
	 * @return the tableauCotisationsNonImposables
	 */
	public TableauCotisationsNonImposablesDto getTableauCotisationsNonImposables() {
		return tableauCotisationsNonImposables;
	}

	/**
	 * @param tableauCotisationsNonImposables the tableauCotisationsNonImposables to
	 *                                        set
	 */
	public void setTableauCotisationsNonImposables(TableauCotisationsNonImposablesDto tableauCotisationsNonImposables) {
		this.tableauCotisationsNonImposables = tableauCotisationsNonImposables;
	}

	/**
	 * @return the tableauCotisationsImposablesDto
	 */
	public TableauCotisationsImposablesDto getTableauCotisationsImposablesDto() {
		return tableauCotisationsImposablesDto;
	}

	/**
	 * @param tableauCotisationsImposablesDto the tableauCotisationsImposablesDto to
	 *                                        set
	 */
	public void setTableauCotisationsImposablesDto(TableauCotisationsImposablesDto tableauCotisationsImposablesDto) {
		this.tableauCotisationsImposablesDto = tableauCotisationsImposablesDto;
	}

}
