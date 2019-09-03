package dev.paie.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entreprise")
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String siret;
	private String denomination;
	private String adresse;
	private String urssaf;
	private String codeNaf;

	public Entreprise(Integer id, String code, String siret, String denomination, String adresse, String urssaf,
			String codeNaf) {
		super();
		this.id = id;
		this.code = code;
		this.siret = siret;
		this.denomination = denomination;
		this.adresse = adresse;
		this.urssaf = urssaf;
		this.codeNaf = codeNaf;
	}

	public Entreprise() {
		super();
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", code=" + code + ", siret=" + siret + ", denomination=" + denomination
				+ ", adresse=" + adresse + ", urssaf=" + urssaf + ", codeNaf=" + codeNaf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((codeNaf == null) ? 0 : codeNaf.hashCode());
		result = prime * result + ((denomination == null) ? 0 : denomination.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((siret == null) ? 0 : siret.hashCode());
		result = prime * result + ((urssaf == null) ? 0 : urssaf.hashCode());
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
		Entreprise other = (Entreprise) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codeNaf == null) {
			if (other.codeNaf != null)
				return false;
		} else if (!codeNaf.equals(other.codeNaf))
			return false;
		if (denomination == null) {
			if (other.denomination != null)
				return false;
		} else if (!denomination.equals(other.denomination))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (siret == null) {
			if (other.siret != null)
				return false;
		} else if (!siret.equals(other.siret))
			return false;
		if (urssaf == null) {
			if (other.urssaf != null)
				return false;
		} else if (!urssaf.equals(other.urssaf))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getUrssaf() {
		return urssaf;
	}

	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
