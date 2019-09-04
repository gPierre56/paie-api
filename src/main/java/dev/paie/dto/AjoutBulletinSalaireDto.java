/**
 * 
 */
package dev.paie.dto;

/**
 * @author Guillaume
 *
 */
public class AjoutBulletinSalaireDto {

	private Integer periode;
	private String matricule;
	private Double primeExceptionelle;

	public AjoutBulletinSalaireDto(Integer periode, String matricule, Double primeExceptionelle) {
		super();
		this.periode = periode;
		this.matricule = matricule;
		this.primeExceptionelle = primeExceptionelle;
	}

	public AjoutBulletinSalaireDto() {
		super();
	}

	@Override
	public String toString() {
		return "AjoutBulletinSalaireDto [periode=" + periode + ", matricule=" + matricule + ", primeExceptionelle="
				+ primeExceptionelle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime * result + ((primeExceptionelle == null) ? 0 : primeExceptionelle.hashCode());
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
		AjoutBulletinSalaireDto other = (AjoutBulletinSalaireDto) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
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
		return true;
	}

	/**
	 * @return the periode
	 */
	public Integer getPeriode() {
		return periode;
	}

	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(Integer periode) {
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
	 * @return the primeExceptionelle
	 */
	public Double getPrimeExceptionelle() {
		return primeExceptionelle;
	}

	/**
	 * @param primeExceptionelle the primeExceptionelle to set
	 */
	public void setPrimeExceptionelle(Double primeExceptionelle) {
		this.primeExceptionelle = primeExceptionelle;
	}

}
