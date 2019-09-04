/**
 * 
 */
package dev.paie.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Guillaume
 *
 */
public class TableauCotisationsNonImposablesDto {

	private List<CotisationsNonImposablesDto> listeCotisations;
	private BigDecimal totalRetenue;
	private BigDecimal netImposable;

	public TableauCotisationsNonImposablesDto(List<CotisationsNonImposablesDto> listeCotisations,
			BigDecimal totalRetenue, BigDecimal netImposable) {
		super();
		this.listeCotisations = listeCotisations;
		this.totalRetenue = totalRetenue;
		this.netImposable = netImposable;
	}

	public TableauCotisationsNonImposablesDto() {
		super();
	}

	@Override
	public String toString() {
		return "TableauCotisationsNonImposablesDto [listeCotisations=" + listeCotisations + ", totalRetenue="
				+ totalRetenue + ", netImposable=" + netImposable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listeCotisations == null) ? 0 : listeCotisations.hashCode());
		result = prime * result + ((netImposable == null) ? 0 : netImposable.hashCode());
		result = prime * result + ((totalRetenue == null) ? 0 : totalRetenue.hashCode());
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
		TableauCotisationsNonImposablesDto other = (TableauCotisationsNonImposablesDto) obj;
		if (listeCotisations == null) {
			if (other.listeCotisations != null)
				return false;
		} else if (!listeCotisations.equals(other.listeCotisations))
			return false;
		if (netImposable == null) {
			if (other.netImposable != null)
				return false;
		} else if (!netImposable.equals(other.netImposable))
			return false;
		if (totalRetenue == null) {
			if (other.totalRetenue != null)
				return false;
		} else if (!totalRetenue.equals(other.totalRetenue))
			return false;
		return true;
	}

	/**
	 * @return the listeCotisations
	 */
	public List<CotisationsNonImposablesDto> getListeCotisations() {
		return listeCotisations;
	}

	/**
	 * @param listeCotisations the listeCotisations to set
	 */
	public void setListeCotisations(List<CotisationsNonImposablesDto> listeCotisations) {
		this.listeCotisations = listeCotisations;
	}

	/**
	 * @return the totalRetenue
	 */
	public BigDecimal getTotalRetenue() {
		return totalRetenue;
	}

	/**
	 * @param totalRetenue the totalRetenue to set
	 */
	public void setTotalRetenue(BigDecimal totalRetenue) {
		this.totalRetenue = totalRetenue;
	}

	/**
	 * @return the netImposable
	 */
	public BigDecimal getNetImposable() {
		return netImposable;
	}

	/**
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

}
