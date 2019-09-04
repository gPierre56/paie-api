/**
 * 
 */
package dev.paie.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import dev.paie.entites.Periode;

/**
 * @author Guillaume
 *
 */
public class BulletinSalaireDto {

	private ZonedDateTime dateCreation;
	private Periode periode;
	private String matricule;
	private BigDecimal salaireBrut;
	private BigDecimal netImposable;
	private BigDecimal netAPayer;

	public BulletinSalaireDto(ZonedDateTime dateCreation, Periode periode, String matricule, BigDecimal salaireBrut,
			BigDecimal netImposable, BigDecimal netAPayer) {
		super();
		this.dateCreation = dateCreation;
		this.periode = periode;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
		this.netImposable = netImposable;
		this.netAPayer = netAPayer;
	}

	public BulletinSalaireDto(ZonedDateTime dateCreation, Periode periode, String matricule, BigDecimal salaireBrut) {
		super();
		this.dateCreation = dateCreation;
		this.periode = periode;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
	}

	public BulletinSalaireDto() {
		super();
	}

	@Override
	public String toString() {
		return "BulletinSalaireDto [dateCreation=" + dateCreation + ", periode=" + periode + ", matricule=" + matricule
				+ ", salaireBrut=" + salaireBrut + ", netImposable=" + netImposable + ", netAPayer=" + netAPayer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((netAPayer == null) ? 0 : netAPayer.hashCode());
		result = prime * result + ((netImposable == null) ? 0 : netImposable.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime * result + ((salaireBrut == null) ? 0 : salaireBrut.hashCode());
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
		BulletinSalaireDto other = (BulletinSalaireDto) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (netAPayer == null) {
			if (other.netAPayer != null)
				return false;
		} else if (!netAPayer.equals(other.netAPayer))
			return false;
		if (netImposable == null) {
			if (other.netImposable != null)
				return false;
		} else if (!netImposable.equals(other.netImposable))
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
		return true;
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

	/**
	 * @return the netImposable
	 */
	public BigDecimal getNetImposable() {
		return netImposable;
	}

	/**
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

	/**
	 * @return the netAPayer
	 */
	public BigDecimal getNetAPayer() {
		return netAPayer;
	}

	/**
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}

}
