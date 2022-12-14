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
@Table(name = "TMAP_TWOD_DTAG_CLAIM_SERVICE_INFO_DATA")
public class ClaimServiceInfo implements Serializable {		
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="claimServiceTable" , strategy="increment")
	@GeneratedValue(generator="claimServiceTable")	
	@Column(name="jobId")
	private Integer jobId;	
	
	@Column(name="jobCode")
	private String jobCode;
	
	@Column(name="standardLaborHour")
	private BigDecimal standardLaborHour;
	
	@Column(name="jobDescription")
	private String jobDescription;
	
	@Column(name="totalLaborHour")
	private BigDecimal totalLaborHour;
	
	@Column(name="laborRate")
	private BigDecimal laborRate;
	
	@Column(name="comments")
	private String comments;
	
	@ManyToOne(optional = false)
	//@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="claimId", nullable=false)
	@JsonIgnore
	private Claim claimClaimServiceInfo;		

	public Claim getClaimClaimServiceInfo() {
		return claimClaimServiceInfo;
	}

	public void setClaimClaimServiceInfo(Claim claimClaimServiceInfo) {
		this.claimClaimServiceInfo = claimClaimServiceInfo;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public BigDecimal getStandardLaborHour() {
		return standardLaborHour;
	}

	public void setStandardLaborHour(BigDecimal standardLaborHour) {
		this.standardLaborHour = standardLaborHour;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public BigDecimal getTotalLaborHour() {
		return totalLaborHour;
	}

	public void setTotalLaborHour(BigDecimal totalLaborHour) {
		this.totalLaborHour = totalLaborHour;
	}

	public BigDecimal getLaborRate() {
		return laborRate;
	}

	public void setLaborRate(BigDecimal laborRate) {
		this.laborRate = laborRate;
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

	public ClaimServiceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaimServiceInfo(Integer jobId, String jobCode, BigDecimal standardLaborHour, String jobDescription,
			BigDecimal totalLaborHour, BigDecimal laborRate, String comments, Claim claimClaimServiceInfo) {
		super();
		this.jobId = jobId;
		this.jobCode = jobCode;
		this.standardLaborHour = standardLaborHour;
		this.jobDescription = jobDescription;
		this.totalLaborHour = totalLaborHour;
		this.laborRate = laborRate;
		this.comments = comments;
		this.claimClaimServiceInfo = claimClaimServiceInfo;
	}

	@Override
	public String toString() {
		return "ClaimServiceInfo [jobId=" + jobId + ", jobCode=" + jobCode + ", standardLaborHour=" + standardLaborHour
				+ ", jobDescription=" + jobDescription + ", totalLaborHour=" + totalLaborHour + ", laborRate="
				+ laborRate + ", comments=" + comments + ", claimClaimServiceInfo=" + claimClaimServiceInfo + "]";
	}
		
}
