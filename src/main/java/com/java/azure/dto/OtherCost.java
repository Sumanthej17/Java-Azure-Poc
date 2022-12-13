package com.java.azure.dto;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "TMAP_TWOD_DTAG_OTHER_COST_DATA")
public class OtherCost implements Serializable {		
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="otherCostTable" , strategy="increment")
	@GeneratedValue(generator="otherCostTable")
	@Column(name="costId")
	private Integer costId;	
	
	@Column(name="costCategoryType")
	private String costCategoryType;
	
	@Column(name="totalCost")
	private BigDecimal totalCost;
	
	@Column(name="comments")
	private String comments;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="claimId", nullable=false)
	@JsonIgnore
	private Claim claimOtherCost;	

	public Claim getClaimOtherCost() {
		return claimOtherCost;
	}

	public void setClaimOtherCost(Claim claimOtherCost) {
		this.claimOtherCost = claimOtherCost;
	}

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public String getCostCategoryType() {
		return costCategoryType;
	}

	public void setCostCategoryType(String costCategoryType) {
		this.costCategoryType = costCategoryType;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OtherCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OtherCost [costId=" + costId + ", costCategoryType=" + costCategoryType + ", totalCost=" + totalCost
				+ ", comments=" + comments + "]";
	}	
	

}
