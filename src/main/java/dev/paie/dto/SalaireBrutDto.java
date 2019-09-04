/**
 * 
 */
package dev.paie.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Guillaume
 *
 */
public class SalaireBrutDto {

	private BigDecimal nbHeures;
	private BigDecimal taux;
	private BigDecimal salaireBrut;

	public SalaireBrutDto(BigDecimal nbHeures, BigDecimal taux) {
		super();
		this.nbHeures = nbHeures;
		this.taux = taux;
		this.salaireBrut = this.nbHeures.multiply(this.taux).setScale(2, RoundingMode.HALF_UP);
	}

	public SalaireBrutDto() {
		super();
	}

	@Override
	public String toString() {
		return "SalaireBrutDto [nbHeures=" + nbHeures + ", taux=" + taux + ", salaireBrut=" + salaireBrut + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nbHeures == null) ? 0 : nbHeures.hashCode());
		result = prime * result + ((salaireBrut == null) ? 0 : salaireBrut.hashCode());
		result = prime * result + ((taux == null) ? 0 : taux.hashCode());
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
		SalaireBrutDto other = (SalaireBrutDto) obj;
		if (nbHeures == null) {
			if (other.nbHeures != null)
				return false;
		} else if (!nbHeures.equals(other.nbHeures))
			return false;
		if (salaireBrut == null) {
			if (other.salaireBrut != null)
				return false;
		} else if (!salaireBrut.equals(other.salaireBrut))
			return false;
		if (taux == null) {
			if (other.taux != null)
				return false;
		} else if (!taux.equals(other.taux))
			return false;
		return true;
	}

	/**
	 * @return the nbHeures
	 */
	public BigDecimal getNbHeures() {
		return nbHeures;
	}

	/**
	 * @param nbHeures the nbHeures to set
	 */
	public void setNbHeures(BigDecimal nbHeures) {
		this.nbHeures = nbHeures;
	}

	/**
	 * @return the taux
	 */
	public BigDecimal getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(BigDecimal taux) {
		this.taux = taux;
	}

	/**
	 * @return the salaireBrut
	 */
	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

}
