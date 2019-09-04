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
public class TableauCotisationsImposablesDto {

	private List<CotisationsImposablesDto> cotisationsImposablesDto;
	private BigDecimal netAPayer;

	public TableauCotisationsImposablesDto(List<CotisationsImposablesDto> cotisationsImposablesDto,
			BigDecimal netAPayer) {
		super();
		this.cotisationsImposablesDto = cotisationsImposablesDto;
		this.netAPayer = netAPayer;
	}

	public TableauCotisationsImposablesDto() {
		super();
	}

	@Override
	public String toString() {
		return "TableauCotisationsImposablesDto [cotisationsImposablesDto=" + cotisationsImposablesDto + ", netAPayer="
				+ netAPayer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotisationsImposablesDto == null) ? 0 : cotisationsImposablesDto.hashCode());
		result = prime * result + ((netAPayer == null) ? 0 : netAPayer.hashCode());
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
		TableauCotisationsImposablesDto other = (TableauCotisationsImposablesDto) obj;
		if (cotisationsImposablesDto == null) {
			if (other.cotisationsImposablesDto != null)
				return false;
		} else if (!cotisationsImposablesDto.equals(other.cotisationsImposablesDto))
			return false;
		if (netAPayer == null) {
			if (other.netAPayer != null)
				return false;
		} else if (!netAPayer.equals(other.netAPayer))
			return false;
		return true;
	}

	/**
	 * @return the cotisationsImposablesDto
	 */
	public List<CotisationsImposablesDto> getCotisationsImposablesDto() {
		return cotisationsImposablesDto;
	}

	/**
	 * @param cotisationsImposablesDto the cotisationsImposablesDto to set
	 */
	public void setCotisationsImposablesDto(List<CotisationsImposablesDto> cotisationsImposablesDto) {
		this.cotisationsImposablesDto = cotisationsImposablesDto;
	}

	/**
	 * @return the netAPayer
	 */
	public BigDecimal getNetAPayer() {
		return netAPayer;
	}

	/**
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}

}
