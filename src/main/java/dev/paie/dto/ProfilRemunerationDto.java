/**
 * 
 */
package dev.paie.dto;

import java.util.List;

import dev.paie.entites.Cotisation;

/**
 * @author Guillaume
 *
 */
public class ProfilRemunerationDto {

	private String code;
	private List<Cotisation> cotisations;

	public ProfilRemunerationDto(String code, List<Cotisation> cotisations) {
		super();
		this.code = code;
		this.cotisations = cotisations;
	}

	public ProfilRemunerationDto() {
		super();
	}

	@Override
	public String toString() {
		return "ProfilRemunerationDto [code=" + code + ", cotisations=" + cotisations + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((cotisations == null) ? 0 : cotisations.hashCode());
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
		ProfilRemunerationDto other = (ProfilRemunerationDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (cotisations == null) {
			if (other.cotisations != null)
				return false;
		} else if (!cotisations.equals(other.cotisations))
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
	 * @return the cotisations
	 */
	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	/**
	 * @param cotisations the cotisations to set
	 */
	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

}
