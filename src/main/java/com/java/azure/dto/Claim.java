package com.java.azure.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TMAP_TWOD_DTAG_CLAIMS_DATA")
public class Claim implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	
	@Id 	
	@Column(name = "claimNumber")
	private String claimNumber;
	
	@Column(name = "claimType")
	private String claimType;	
	
	@Column(name = "accountName")
	private String accountName;
	
	@Column(name = "businessUnit")
	private String businessUnit;
	
	@Column(name = "serialNumber")
	private String serialNumber;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "partDescription")
	private String partDescription;
	
	@Column(name = "part")
	private String part;
	
	@Column(name = "hoursOnMachine")
	private Double hoursOnMachine;
	
	@Column(name = "workOrderCreationDate")
	private Date workOrderCreationDate;
	
	@Column(name = "repairDate")
	private Date repairDate;
	
	@Column(name = "purchaseDate")
	private Date purchaseDate;
	
	@Column(name = "invoiceNumber")
	private String invoiceNumber;
	
	@Column(name = "causalPartDescription")
	private String causalPartDescription;
	
	@Column(name = "policyDetails")
	private String policyDetails;
	
	@Column(name = "laborRate")
	private Double laborRate;
	
	@Column(name = "claimStatus")
	private String claimStatus;
	
	@Column(name = "duplicateClaimNumber")
	private String duplicateClaimNumber;
	
	@Column(name = "claimComments")
	private String claimComments;
	
	@Column(name = "preAuthRequired")
	private Boolean preAuthRequired;
	
	@Column(name = "preAuthReason")
	private String preAuthReason;
	
	@Column(name = "preAuthComments")
	private String preAuthComments;
	
	@Column(name = "appealReason")
	private String appealReason;
	
	@Column(name = "appealComments")
	private String appealComments;
	
	@Column(name = "appealCount")
	private Integer appealCount;
	
	@Column(name = "campaignMember")
	private String campaignMember;
	
	@Column(name = "submissionDate")
	private Date submissionDate;
	
	@Column(name = "submittedBy")
	private String submittedBy;

	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimType=" + claimType + ", accountName=" + accountName
				+ ", businessUnit=" + businessUnit + ", serialNumber=" + serialNumber + ", model=" + model
				+ ", partDescription=" + partDescription + ", part=" + part + ", hoursOnMachine=" + hoursOnMachine
				+ ", workOrderCreationDate=" + workOrderCreationDate + ", repairDate=" + repairDate + ", purchaseDate="
				+ purchaseDate + ", invoiceNumber=" + invoiceNumber + ", causalPartDescription=" + causalPartDescription
				+ ", policyDetails=" + policyDetails + ", laborRate=" + laborRate + ", claimStatus=" + claimStatus
				+ ", duplicateClaimNumber=" + duplicateClaimNumber + ", claimComments=" + claimComments
				+ ", preAuthRequired=" + preAuthRequired + ", preAuthReason=" + preAuthReason + ", preAuthComments="
				+ preAuthComments + ", appealReason=" + appealReason + ", appealComments=" + appealComments
				+ ", appealCount=" + appealCount + ", campaignMember=" + campaignMember + ", submissionDate="
				+ submissionDate + ", submittedBy=" + submittedBy + "]";
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public Double getHoursOnMachine() {
		return hoursOnMachine;
	}

	public void setHoursOnMachine(Double hoursOnMachine) {
		this.hoursOnMachine = hoursOnMachine;
	}

	public Date getWorkOrderCreationDate() {
		return workOrderCreationDate;
	}

	public void setWorkOrderCreationDate(Date workOrderCreationDate) {
		this.workOrderCreationDate = workOrderCreationDate;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCausalPartDescription() {
		return causalPartDescription;
	}

	public void setCausalPartDescription(String causalPartDescription) {
		this.causalPartDescription = causalPartDescription;
	}

	public String getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(String policyDetails) {
		this.policyDetails = policyDetails;
	}

	public Double getLaborRate() {
		return laborRate;
	}

	public void setLaborRate(Double laborRate) {
		this.laborRate = laborRate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getDuplicateClaimNumber() {
		return duplicateClaimNumber;
	}

	public void setDuplicateClaimNumber(String duplicateClaimNumber) {
		this.duplicateClaimNumber = duplicateClaimNumber;
	}

	public String getClaimComments() {
		return claimComments;
	}

	public void setClaimComments(String claimComments) {
		this.claimComments = claimComments;
	}

	public Boolean getPreAuthRequired() {
		return preAuthRequired;
	}

	public void setPreAuthRequired(Boolean preAuthRequired) {
		this.preAuthRequired = preAuthRequired;
	}

	public String getPreAuthReason() {
		return preAuthReason;
	}

	public void setPreAuthReason(String preAuthReason) {
		this.preAuthReason = preAuthReason;
	}

	public String getPreAuthComments() {
		return preAuthComments;
	}

	public void setPreAuthComments(String preAuthComments) {
		this.preAuthComments = preAuthComments;
	}

	public String getAppealReason() {
		return appealReason;
	}

	public void setAppealReason(String appealReason) {
		this.appealReason = appealReason;
	}

	public String getAppealComments() {
		return appealComments;
	}

	public void setAppealComments(String appealComments) {
		this.appealComments = appealComments;
	}

	public Integer getAppealCount() {
		return appealCount;
	}

	public void setAppealCount(Integer appealCount) {
		this.appealCount = appealCount;
	}

	public String getCampaignMember() {
		return campaignMember;
	}

	public void setCampaignMember(String campaignMember) {
		this.campaignMember = campaignMember;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Claim(String claimNumber, String claimType, String accountName, String businessUnit, String serialNumber,
			String model, String partDescription, String part, Double hoursOnMachine, Date workOrderCreationDate,
			Date repairDate, Date purchaseDate, String invoiceNumber, String causalPartDescription,
			String policyDetails, Double laborRate, String claimStatus, String duplicateClaimNumber,
			String claimComments, Boolean preAuthRequired, String preAuthReason, String preAuthComments,
			String appealReason, String appealComments, Integer appealCount, String campaignMember, Date submissionDate,
			String submittedBy) {
		super();
		this.claimNumber = claimNumber;
		this.claimType = claimType;
		this.accountName = accountName;
		this.businessUnit = businessUnit;
		this.serialNumber = serialNumber;
		this.model = model;
		this.partDescription = partDescription;
		this.part = part;
		this.hoursOnMachine = hoursOnMachine;
		this.workOrderCreationDate = workOrderCreationDate;
		this.repairDate = repairDate;
		this.purchaseDate = purchaseDate;
		this.invoiceNumber = invoiceNumber;
		this.causalPartDescription = causalPartDescription;
		this.policyDetails = policyDetails;
		this.laborRate = laborRate;
		this.claimStatus = claimStatus;
		this.duplicateClaimNumber = duplicateClaimNumber;
		this.claimComments = claimComments;
		this.preAuthRequired = preAuthRequired;
		this.preAuthReason = preAuthReason;
		this.preAuthComments = preAuthComments;
		this.appealReason = appealReason;
		this.appealComments = appealComments;
		this.appealCount = appealCount;
		this.campaignMember = campaignMember;
		this.submissionDate = submissionDate;
		this.submittedBy = submittedBy;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
