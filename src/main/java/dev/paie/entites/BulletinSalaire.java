package dev.paie.entites;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	public BulletinSalaire() {
		super();
	}

	public BulletinSalaire(Integer id, String code, RemunerationEmploye remunerationEmploye, Periode periode,
			BigDecimal primeExceptionnelle) {
		super();
		this.id = id;
		this.code = code;
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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

	@Override
	public String toString() {
		return "BulletinSalaire [id=" + id + ", code=" + code + ", remunerationEmploye=" + remunerationEmploye
				+ ", periode=" + periode + ", primeExceptionnelle=" + primeExceptionnelle + "]";
	}

	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public Integer getId() {
		return id;
	}

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

}
