/**
 * 
 */
package dev.paie.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import dev.paie.dto.TraitementSalaireDto;

/**
 * @author Guillaume
 *
 */
@Component
public class CalculSalaire {

	/**
	 * @param bulletin Cette fonction prend en paramètre un objet qui va etre traité
	 *                 pour le calcul des salaires. Cette méthode triera ses
	 *                 cotisations selon le fait qu'elles soient imposables ou non
	 */
	public void separerCotisations(TraitementSalaireDto bulletin) {
		for (int i = 0; i < bulletin.getCotisationsBrutes().size(); i++) {
			if (bulletin.getCotisationsBrutes().get(i).getImposable()) {
				bulletin.getCotisationsImposables().add(bulletin.getCotisationsBrutes().get(i));
			} else {
				bulletin.getCotisationsNonImposables().add(bulletin.getCotisationsBrutes().get(i));
			}
		}

	}

	/**
	 * @param Cette fonction prend en paramètre un objet qui va etre traité pour le
	 *              calcul des salaires. Elle va fixer le salaire brut de chaque
	 *              objet en le calculant par rapport au taux de base du salarié et
	 *              à son nombre d'heures de base. une prime exceptionelle peut
	 *              éventuellement y être ajouté
	 */
	public void calculerSalaireBrut(TraitementSalaireDto bulletin) {
		if (bulletin.getPrimeExceptionelle() != null) {
			bulletin.setSalaireBrut((bulletin.getNbHeuresBase().multiply(bulletin.getTauxBase())
					.add(bulletin.getPrimeExceptionelle())));
		} else {
			bulletin.setSalaireBrut((bulletin.getNbHeuresBase().multiply(bulletin.getTauxBase())));
		}
	}

	/**
	 * @param Cette fonction prend en paramètre un objet qui va etre traité pour le
	 *              calcul des salaires. Elle va fixer le salaire net imposable de
	 *              chaque objet en le calculant par rapport aux charges salariales
	 */
	public void calculSalaireNet(TraitementSalaireDto bulletin) {
		BigDecimal charges = BigDecimal.ZERO;
		for (int j = 0; j < bulletin.getCotisationsNonImposables().size(); j++) {

			if (bulletin.getCotisationsNonImposables().get(j).getTauxSalarial() != null) {
				charges = charges.add(bulletin.getCotisationsNonImposables().get(j).getTauxSalarial()
						.multiply(bulletin.getSalaireBrut()));

			}
			bulletin.setNetImposable(bulletin.getSalaireBrut().subtract(charges));
		}
	}

	/**
	 * @param Cette fonction prend en paramètre un objet qui va etre traité pour le
	 *              calcul des salaires. Elle va fixer le net à payer de chaque
	 *              objet en le calculant par rapport aux cotisations imposables
	 */
	public void calculNetAPayer(TraitementSalaireDto bulletin) {
		BigDecimal charges = BigDecimal.ZERO;
		for (int j = 0; j < bulletin.getCotisationsImposables().size(); j++) {
			charges = charges.add(
					bulletin.getSalaireBrut().multiply(bulletin.getCotisationsImposables().get(j).getTauxSalarial()));
		}

		bulletin.setNetAPayer(bulletin.getNetImposable().subtract(charges));
	}

}
