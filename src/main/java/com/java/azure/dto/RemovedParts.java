package com.java.azure.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TMAP_TWOD_DTAG_REMOVED_PARTS_DATA")
public class RemovedParts implements Serializable {		
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="removedPartsTable" , strategy="increment")
	@GeneratedValue(generator="removedPartsTable")
	@Column(name="partId")
	private Integer partId;	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="claimId", nullable=false)
	@JsonIgnore
	private Claim claimRemovedParts;	

	public Claim getClaimRemovedParts() {
		return claimRemovedParts;
	}

	public void setClaimRemovedParts(Claim claimRemovedParts) {
		this.claimRemovedParts = claimRemovedParts;
	}

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

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
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

	public RemovedParts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RemovedParts(Integer partId, Claim claimRemovedParts, String partDescription, BigDecimal quantity,
			BigDecimal perUnitPrice, String uOM, String partNumber) {
		super();
		this.partId = partId;
		this.claimRemovedParts = claimRemovedParts;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.perUnitPrice = perUnitPrice;
		this.uOM = uOM;
		this.partNumber = partNumber;
	}

	@Override
	public String toString() {
		return "RemovedParts [partId=" + partId + ", claimRemovedParts=" + claimRemovedParts + ", partDescription=" + partDescription
				+ ", quantity=" + quantity + ", perUnitPrice=" + perUnitPrice + ", uOM=" + uOM + ", partNumber="
				+ partNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(claimRemovedParts, partDescription, partId, partNumber, perUnitPrice, quantity, uOM);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemovedParts other = (RemovedParts) obj;
		return Objects.equals(claimRemovedParts, other.claimRemovedParts)
				&& Objects.equals(partDescription, other.partDescription) && Objects.equals(partId, other.partId)
				&& Objects.equals(partNumber, other.partNumber) && Objects.equals(perUnitPrice, other.perUnitPrice)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(uOM, other.uOM);
	}	

}
