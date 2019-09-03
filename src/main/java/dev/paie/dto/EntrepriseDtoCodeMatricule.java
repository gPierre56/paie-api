/**
 * 
 */
package dev.paie.dto;

/**
 * @author Guillaume
 *
 */
public class EntrepriseDtoCodeMatricule {

	private String code;
	private String denomination;

	public EntrepriseDtoCodeMatricule(String code, String denomination) {
		super();
		this.code = code;
		this.denomination = denomination;
	}

	public EntrepriseDtoCodeMatricule() {
		super();
	}

	@Override
	public String toString() {
		return "EntrepriseDtoCodeMatricule [code=" + code + ", denomination=" + denomination + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((denomination == null) ? 0 : denomination.hashCode());
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
		EntrepriseDtoCodeMatricule other = (EntrepriseDtoCodeMatricule) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (denomination == null) {
			if (other.denomination != null)
				return false;
		} else if (!denomination.equals(other.denomination))
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
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * @param denomination the denomination to set
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

}
