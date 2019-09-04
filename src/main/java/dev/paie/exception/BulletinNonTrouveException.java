/**
 * 
 */
package dev.paie.exception;

/**
 * @author Guillaume
 *
 */
public class BulletinNonTrouveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5909629269407238481L;
	private String erreur;

	public BulletinNonTrouveException(String erreur) {
		super();
		this.erreur = erreur;
	}

	/**
	 * @return the erreur
	 */
	public String getErreur() {
		return erreur;
	}

	/**
	 * @param erreur the erreur to set
	 */
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

}
