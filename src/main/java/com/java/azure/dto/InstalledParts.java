package com.java.azure.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TMAP_TWOD_DTAG_INSTALLED_PARTS_DATA")
public class InstalledParts implements Serializable {		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="partId")
	private String partId;

	@Column(name="partDescription")
	private String partDescription;
	
	@Column(name="quantity")
	private BigDecimal quantity;
	
	@Column(name="perUnitPrice")
	private BigDecimal perUnitPrice;
	
	@Column(name="uOM")
	private String uOM;
	
	@Column(name="partNumber")
	private String partNumber;	
	
	@ManyToOne
	@JoinColumn(name="claimNumber", nullable=false)
	private Claim claimInstalledParts;
	

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(BigDecimal perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}

	public String getuOM() {
		return uOM;
	}

	public void setuOM(String uOM) {
		this.uOM = uOM;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public InstalledParts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstalledParts(String partId, String partDescription, BigDecimal quantity, BigDecimal perUnitPrice,
			String uOM, String partNumber) {
		super();
		this.partId = partId;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.perUnitPrice = perUnitPrice;
		this.uOM = uOM;
		this.partNumber = partNumber;
	}

	@Override
	public String toString() {
		return "InstalledParts [partId=" + partId + ", partDescription=" + partDescription + ", quantity=" + quantity
				+ ", perUnitPrice=" + perUnitPrice + ", uOM=" + uOM + ", partNumber=" + partNumber + "]";
	}	

		
}
