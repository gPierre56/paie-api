/**
 * 
 */
package dev.paie.exception;

/**
 * @author Guillaume
 *
 */
public class MatriculeInvalideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489216193122912531L;

	private String erreur;

	public MatriculeInvalideException(String erreur) {

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
