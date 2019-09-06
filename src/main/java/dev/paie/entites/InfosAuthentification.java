/**
 * 
 */
package dev.paie.entites;

/**
 * @author Guillaume
 *
 */
public class InfosAuthentification {

	private String nomUtilisateur;
	private String motDePasse;

	public InfosAuthentification(String nomUtilisateur, String motDePasse) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
	}

	public InfosAuthentification() {
		super();
	}

	@Override
	public String toString() {
		return "InfosAuthentification [nomUtilisateur=" + nomUtilisateur + ", motDePasse=" + motDePasse + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((nomUtilisateur == null) ? 0 : nomUtilisateur.hashCode());
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
		InfosAuthentification other = (InfosAuthentification) obj;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nomUtilisateur == null) {
			if (other.nomUtilisateur != null)
				return false;
		} else if (!nomUtilisateur.equals(other.nomUtilisateur))
			return false;
		return true;
	}

	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
