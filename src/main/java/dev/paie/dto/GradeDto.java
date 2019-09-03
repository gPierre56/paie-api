/**
 * 
 */
package dev.paie.dto;

import java.math.BigDecimal;

/**
 * @author Guillaume
 *
 */
public class GradeDto {

	private String code;
	private BigDecimal nbHeuresBase;
	private BigDecimal tauxBase;

	public GradeDto(String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		super();
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}

	public GradeDto() {
		super();
	}

	@Override
	public String toString() {
		return "GradeDto [code=" + code + ", nbHeuresBase=" + nbHeuresBase + ", tauxBase=" + tauxBase + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((nbHeuresBase == null) ? 0 : nbHeuresBase.hashCode());
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
		GradeDto other = (GradeDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (nbHeuresBase == null) {
			if (other.nbHeuresBase != null)
				return false;
		} else if (!nbHeuresBase.equals(other.nbHeuresBase))
			return false;
		if (tauxBase == null) {
			if (other.tauxBase != null)
				return false;
		} else if (!tauxBase.equals(other.tauxBase))
			return false;
		return true;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

}
