/**
 * 
 */
package dev.paie.dto;

/**
 * @author Guillaume
 *
 */
public class ajoutEmployeDto {

	private String matricule;
	private String codeEntreprise;
	private String codeProfil;
	private String codeGrade;

	public ajoutEmployeDto(String matricule, String codeEntreprise, String codeProfil, String codeGrade) {
		super();
		this.matricule = matricule;
		this.codeEntreprise = codeEntreprise;
		this.codeProfil = codeProfil;
		this.codeGrade = codeGrade;
	}

	public ajoutEmployeDto() {
		super();
	}

	@Override
	public String toString() {
		return "ajoutEmployeDto [matricule=" + matricule + ", codeEntreprise=" + codeEntreprise + ", codeProfil="
				+ codeProfil + ", codeGrade=" + codeGrade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeEntreprise == null) ? 0 : codeEntreprise.hashCode());
		result = prime * result + ((codeGrade == null) ? 0 : codeGrade.hashCode());
		result = prime * result + ((codeProfil == null) ? 0 : codeProfil.hashCode());
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
		ajoutEmployeDto other = (ajoutEmployeDto) obj;
		if (codeEntreprise == null) {
			if (other.codeEntreprise != null)
				return false;
		} else if (!codeEntreprise.equals(other.codeEntreprise))
			return false;
		if (codeGrade == null) {
			if (other.codeGrade != null)
				return false;
		} else if (!codeGrade.equals(other.codeGrade))
			return false;
		if (codeProfil == null) {
			if (other.codeProfil != null)
				return false;
		} else if (!codeProfil.equals(other.codeProfil))
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
	 * @return the codeEntreprise
	 */
	public String getCodeEntreprise() {
		return codeEntreprise;
	}

	/**
	 * @param codeEntreprise the codeEntreprise to set
	 */
	public void setCodeEntreprise(String codeEntreprise) {
		this.codeEntreprise = codeEntreprise;
	}

	/**
	 * @return the codeProfil
	 */
	public String getCodeProfil() {
		return codeProfil;
	}

	/**
	 * @param codeProfil the codeProfil to set
	 */
	public void setCodeProfil(String codeProfil) {
		this.codeProfil = codeProfil;
	}

	/**
	 * @return the codeGrade
	 */
	public String getCodeGrade() {
		return codeGrade;
	}

	/**
	 * @param codeGrade the codeGrade to set
	 */
	public void setCodeGrade(String codeGrade) {
		this.codeGrade = codeGrade;
	}

}
