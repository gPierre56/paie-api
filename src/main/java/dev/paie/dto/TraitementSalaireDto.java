/**
 * 
 */
package dev.paie.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.paie.entites.Cotisation;
import dev.paie.entites.Periode;

/**
 * @author Guillaume
 *
 */
public class TraitementSalaireDto {

	private ZonedDateTime dateCreation;
	private Periode periode;
	private String matricule;
	private BigDecimal nbHeuresBase;
	private BigDecimal tauxBase;
	private List<Cotisation> cotisationsBrutes = new ArrayList<>();
	private List<Cotisation> cotisationsImposables = new ArrayList<>();
	private List<Cotisation> cotisationsNonImposables = new ArrayList<>();
	private BigDecimal salaireBrut;
	private BigDecimal netImposable;
	private BigDecimal netAPayer;
	private BigDecimal primeExceptionelle;

	public TraitementSalaireDto(ZonedDateTime dateCreation, Periode periode, String matricule, BigDecimal nbHeuresBase,
			BigDecimal tauxBase, List<Cotisation> cotisationsBrutes) {
		super();
		this.dateCreation = dateCreation;
		this.periode = periode;
		this.matricule = matricule;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
		this.cotisationsBrutes = cotisationsBrutes;
	}

	public TraitementSalaireDto(ZonedDateTime dateCreation, Periode periode, String matricule, BigDecimal nbHeuresBase,
			BigDecimal tauxBase, List<Cotisation> cotisationsBrutes, BigDecimal primeExceptionelle) {
		super();
		this.dateCreation = dateCreation;
		this.periode = periode;
		this.matricule = matricule;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
		this.cotisationsBrutes = cotisationsBrutes;
		this.primeExceptionelle = primeExceptionelle;
	}

	public TraitementSalaireDto() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotisationsBrutes == null) ? 0 : cotisationsBrutes.hashCode());
		result = prime * result + ((cotisationsImposables == null) ? 0 : cotisationsImposables.hashCode());
		result = prime * result + ((cotisationsNonImposables == null) ? 0 : cotisationsNonImposables.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((nbHeuresBase == null) ? 0 : nbHeuresBase.hashCode());
		result = prime * result + ((netAPayer == null) ? 0 : netAPayer.hashCode());
		result = prime * result + ((netImposable == null) ? 0 : netImposable.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime * result + ((primeExceptionelle == null) ? 0 : primeExceptionelle.hashCode());
		result = prime * result + ((salaireBrut == null) ? 0 : salaireBrut.hashCode());
		result = prime * result + ((tauxBase == null) ? 0 : tauxBase.hashCode());
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
		TraitementSalaireDto other = (TraitementSalaireDto) obj;
		if (cotisationsBrutes == null) {
			if (other.cotisationsBrutes != null)
				return false;
		} else if (!cotisationsBrutes.equals(other.cotisationsBrutes))
			return false;
		if (cotisationsImposables == null) {
			if (other.cotisationsImposables != null)
				return false;
		} else if (!cotisationsImposables.equals(other.cotisationsImposables))
			return false;
		if (cotisationsNonImposables == null) {
			if (other.cotisationsNonImposables != null)
				return false;
		} else if (!cotisationsNonImposables.equals(other.cotisationsNonImposables))
			return false;
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
		if (nbHeuresBase == null) {
			if (other.nbHeuresBase != null)
				return false;
		} else if (!nbHeuresBase.equals(other.nbHeuresBase))
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
		if (primeExceptionelle == null) {
			if (other.primeExceptionelle != null)
				return false;
		} else if (!primeExceptionelle.equals(other.primeExceptionelle))
			return false;
		if (salaireBrut == null) {
			if (other.salaireBrut != null)
				return false;
		} else if (!salaireBrut.equals(other.salaireBrut))
			return false;
		if (tauxBase == null) {
			if (other.tauxBase != null)
				return false;
		} else if (!tauxBase.equals(other.tauxBase))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TraitementSalaireDto [dateCreation=" + dateCreation + ", periode=" + periode + ", matricule="
				+ matricule + ", nbHeuresBase=" + nbHeuresBase + ", tauxBase=" + tauxBase + ", cotisationsBrutes="
				+ cotisationsBrutes + ", cotisationsImposables=" + cotisationsImposables + ", cotisationsNonImposables="
				+ cotisationsNonImposables + ", salaireBrut=" + salaireBrut + ", netImposable=" + netImposable
				+ ", netAPayer=" + netAPayer + ", primeExceptionelle=" + primeExceptionelle + "]";
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
	 * @return the nbHeuresBase
	 */
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}

	/**
	 * @param nbHeuresBase the nbHeuresBase to set
	 */
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	/**
	 * @return the tauxBase
	 */
	public BigDecimal getTauxBase() {
		return tauxBase;
	}

	/**
	 * @param tauxBase the tauxBase to set
	 */
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}

	/**
	 * @return the cotisationsBrutes
	 */
	public List<Cotisation> getCotisationsBrutes() {
		return cotisationsBrutes;
	}

	/**
	 * @param cotisationsBrutes the cotisationsBrutes to set
	 */
	public void setCotisationsBrutes(List<Cotisation> cotisationsBrutes) {
		this.cotisationsBrutes = cotisationsBrutes;
	}

	/**
	 * @return the cotisationsImposables
	 */
	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	/**
	 * @param cotisationsImposables the cotisationsImposables to set
	 */
	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	/**
	 * @return the cotisationsNonImposables
	 */
	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	/**
	 * @param cotisationsNonImposables the cotisationsNonImposables to set
	 */
	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
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
	 * @return the primeExceptionelle
	 */
	public BigDecimal getPrimeExceptionelle() {
		return primeExceptionelle;
	}

	/**
	 * @param primeExceptionelle the primeExceptionelle to set
	 */
	public void setPrimeExceptionelle(BigDecimal primeExceptionelle) {
		this.primeExceptionelle = primeExceptionelle;
	}

}
