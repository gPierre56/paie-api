/**
 * 
 */
package dev.paie.dto;

import java.math.BigDecimal;

/**
 * @author Guillaume
 *
 */
public class CotisationsNonImposablesDto {

	private String libelle;
	private BigDecimal base;
	private BigDecimal tauxSalarial;
	private BigDecimal montantSalarial;
	private BigDecimal tauxPatronnal;
	private BigDecimal cotisationsPatronnales;

	public CotisationsNonImposablesDto(String libelle, BigDecimal base, BigDecimal tauxSalarial,
			BigDecimal montantSalarial, BigDecimal tauxPatronnal, BigDecimal cotisationsPatronnales) {
		super();
		this.libelle = libelle;
		this.base = base;
		this.tauxSalarial = tauxSalarial;
		this.montantSalarial = montantSalarial;
		this.tauxPatronnal = tauxPatronnal;
		this.cotisationsPatronnales = cotisationsPatronnales;
	}

	public CotisationsNonImposablesDto() {
		super();
	}

	@Override
	public String toString() {
		return "CotisationsNonImposablesDto [libelle=" + libelle + ", base=" + base + ", tauxSalarial=" + tauxSalarial
				+ ", montantSalarial=" + montantSalarial + ", tauxPatronnal=" + tauxPatronnal
				+ ", cotisationsPatronnales=" + cotisationsPatronnales + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((cotisationsPatronnales == null) ? 0 : cotisationsPatronnales.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((montantSalarial == null) ? 0 : montantSalarial.hashCode());
		result = prime * result + ((tauxPatronnal == null) ? 0 : tauxPatronnal.hashCode());
		result = prime * result + ((tauxSalarial == null) ? 0 : tauxSalarial.hashCode());
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
		CotisationsNonImposablesDto other = (CotisationsNonImposablesDto) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (cotisationsPatronnales == null) {
			if (other.cotisationsPatronnales != null)
				return false;
		} else if (!cotisationsPatronnales.equals(other.cotisationsPatronnales))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (montantSalarial == null) {
			if (other.montantSalarial != null)
				return false;
		} else if (!montantSalarial.equals(other.montantSalarial))
			return false;
		if (tauxPatronnal == null) {
			if (other.tauxPatronnal != null)
				return false;
		} else if (!tauxPatronnal.equals(other.tauxPatronnal))
			return false;
		if (tauxSalarial == null) {
			if (other.tauxSalarial != null)
				return false;
		} else if (!tauxSalarial.equals(other.tauxSalarial))
			return false;
		return true;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the base
	 */
	public BigDecimal getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(BigDecimal base) {
		this.base = base;
	}

	/**
	 * @return the tauxSalarial
	 */
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	/**
	 * @param tauxSalarial the tauxSalarial to set
	 */
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	/**
	 * @return the montantSalarial
	 */
	public BigDecimal getMontantSalarial() {
		return montantSalarial;
	}

	/**
	 * @param montantSalarial the montantSalarial to set
	 */
	public void setMontantSalarial(BigDecimal montantSalarial) {
		this.montantSalarial = montantSalarial;
	}

	/**
	 * @return the tauxPatronnal
	 */
	public BigDecimal getTauxPatronnal() {
		return tauxPatronnal;
	}

	/**
	 * @param tauxPatronnal the tauxPatronnal to set
	 */
	public void setTauxPatronnal(BigDecimal tauxPatronnal) {
		this.tauxPatronnal = tauxPatronnal;
	}

	/**
	 * @return the cotisationsPatronnales
	 */
	public BigDecimal getCotisationsPatronnales() {
		return cotisationsPatronnales;
	}

	/**
	 * @param cotisationsPatronnales the cotisationsPatronnales to set
	 */
	public void setCotisationsPatronnales(BigDecimal cotisationsPatronnales) {
		this.cotisationsPatronnales = cotisationsPatronnales;
	}

}
