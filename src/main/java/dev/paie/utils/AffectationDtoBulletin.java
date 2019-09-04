/**
 * 
 */
package dev.paie.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.paie.dto.CollegueDto;
import dev.paie.dto.CollegueDtoBulletinSalaire;
import dev.paie.dto.DtoBulletinUnique;
import dev.paie.dto.EntrepriseDtoBulletinSalaire;
import dev.paie.dto.SalaireBrutDto;
import dev.paie.entites.BulletinSalaire;

/**
 * @author Guillaume Classe qui centralise les méthodes d'affectation
 *         d'attributs à l'objet nécessaire à l'affichage d'un bulletin de
 *         salaire unique
 */
@Component
public class AffectationDtoBulletin {

	/**
	 * Cette méthode est utilisée pour rattacher une entreprise à l'objet qui
	 * servira de vue lors de l'affichage d'un bulletin de salaire spécifique
	 * 
	 * @param dto      L'objet dont les données seront envoyés au navigateur
	 * @param bulletin le bulletin de salaire stocké en base
	 */
	public void affecterEntreprise(DtoBulletinUnique dto, BulletinSalaire bulletin) {
		dto.setEntreprise(new EntrepriseDtoBulletinSalaire(bulletin.getRemunerationEmploye().getEntreprise().getCode(),
				bulletin.getRemunerationEmploye().getEntreprise().getDenomination(),
				bulletin.getRemunerationEmploye().getEntreprise().getSiret()));
	}

	/**
	 * Cette méthode est utilisée pour rattacher un employé à l'objet qui servira de
	 * vue lors de l'affichage d'un bulletin de salaire spécifique
	 * 
	 * @param dto      L'objet dont les données seront envoyés au navigateur
	 * @param bulletin le bulletin de salaire stocké en base
	 */
	public void affecterEmploye(DtoBulletinUnique dto, BulletinSalaire bulletin) {
		RestTemplate rt = new RestTemplate();
		CollegueDto employe = rt.getForObject("https://guillaume-top-collegues.herokuapp.com/collegue/"
				.concat(bulletin.getRemunerationEmploye().getMatricule()), CollegueDto.class);

		dto.setEmploye(new CollegueDtoBulletinSalaire(employe.getMatricule(), employe.getNom(), employe.getPrenom(),
				employe.getDateDeNaissance()));
	}

	/**
	 * Cette méthode est utilisée pour rattacher une période à l'objet qui servira
	 * de vue lors de l'affichage d'un bulletin de salaire spécifique
	 * 
	 * @param dto      L'objet dont les données seront envoyés au navigateur
	 * @param bulletin le bulletin de salaire stocké en base
	 */
	public void affecterPeriode(DtoBulletinUnique dto, BulletinSalaire bulletin) {
		dto.setPeriode(bulletin.getPeriode());
	}

	/**
	 * Cette méthode est utilisée pour rattacher un calcul de salaire brut à l'objet
	 * qui servira de vue lors de l'affichage d'un bulletin de salaire spécifique
	 * 
	 * @param dto      L'objet dont les données seront envoyés au navigateur
	 * @param bulletin le bulletin de salaire stocké en base
	 */
	public void affecterSalaireBrut(DtoBulletinUnique dto, BulletinSalaire bulletin) {
		dto.setSalaireBrut(new SalaireBrutDto(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase(),
				bulletin.getRemunerationEmploye().getGrade().getTauxBase()));
		if (bulletin.getPrimeExceptionnelle() != null && !bulletin.getPrimeExceptionnelle().equals(BigDecimal.ZERO)) {
			dto.getSalaireBrut()
					.setSalaireBrut(dto.getSalaireBrut().getSalaireBrut().add(bulletin.getPrimeExceptionnelle()));
		}
	}

}
