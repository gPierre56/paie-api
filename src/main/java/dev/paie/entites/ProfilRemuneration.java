package dev.paie.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profil_remuneration")
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisation", joinColumns = {
			@JoinColumn(name = "profil_remuneration_id") }, inverseJoinColumns = {
					@JoinColumn(name = "cotisation_id") })
	private List<Cotisation> cotisations;

	public ProfilRemuneration() {
		super();
	}

	public ProfilRemuneration(Integer id, String code, List<Cotisation> cotisations) {
		super();
		this.id = id;
		this.code = code;
		this.cotisations = cotisations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((cotisations == null) ? 0 : cotisations.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProfilRemuneration other = (ProfilRemuneration) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (cotisations == null) {
			if (other.cotisations != null)
				return false;
		} else if (!cotisations.equals(other.cotisations))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfilRemuneration [id=" + id + ", code=" + code + ", cotisations=" + cotisations + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

}
