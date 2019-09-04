package dev.paie.entites;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "bulletin_salaire")
public class BulletinSalaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	@ManyToOne
	@JoinColumn
	private RemunerationEmploye remunerationEmploye;
	@ManyToOne
	@JoinColumn
	private Periode periode;
	private BigDecimal primeExceptionnelle;

	private ZonedDateTime dateCreation;

	public BulletinSalaire() {
		super();
	}

	public BulletinSalaire(String code, RemunerationEmploye remunerationEmploye, Periode periode,
			BigDecimal primeExceptionnelle) {
		super();
		this.code = code;
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	@PrePersist
	public void fixerDateCreation() {
		this.dateCreation = ZonedDateTime.now();
	}

	@Override
	public String toString() {
		return "BulletinSalaire [id=" + id + ", code=" + code + ", remunerationEmploye=" + remunerationEmploye
				+ ", periode=" + periode + ", primeExceptionnelle=" + primeExceptionnelle + ", dateCreation="
				+ dateCreation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime * result + ((primeExceptionnelle == null) ? 0 : primeExceptionnelle.hashCode());
		result = prime * result + ((remunerationEmploye == null) ? 0 : remunerationEmploye.hashCode());
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
		BulletinSalaire other = (BulletinSalaire) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (periode == null) {
			if (other.periode != null)
				return false;
		} else if (!periode.equals(other.periode))
			return false;
		if (primeExceptionnelle == null) {
			if (other.primeExceptionnelle != null)
				return false;
		} else if (!primeExceptionnelle.equals(other.primeExceptionnelle))
			return false;
		if (remunerationEmploye == null) {
			if (other.remunerationEmploye != null)
				return false;
		} else if (!remunerationEmploye.equals(other.remunerationEmploye))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the remunerationEmploye
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	/**
	 * @param remunerationEmploye the remunerationEmploye to set
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	/**
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}

	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	/**
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	/**
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

	/**
	 * @return the dateCreation
	 */
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

}
