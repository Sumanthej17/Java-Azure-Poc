package com.java.azure.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TMAP_TWOD_DTAG_CLAIMS_DATA")
public class Claim implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="claimTable" , strategy="increment")
	@GeneratedValue(generator="claimTable")
	@Column(name = "claimId")
	private Integer claimId;
	
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
	
	@OneToMany(mappedBy="claimOtherCost", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OtherCost> otherCost;	
	
	@OneToMany(mappedBy="claimInstalledParts", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<InstalledParts> installedParts;	
	
	@OneToMany(mappedBy="claimRemovedParts", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<RemovedParts> removedParts;	
	
	@OneToMany(mappedBy="claimClaimServiceInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToMany(mappedBy="claimClaimServiceInfo")
	//@JsonIgnore
	private Set<ClaimServiceInfo> claimServiceInfo;	
				
	public Set<ClaimServiceInfo> getClaimServiceInfo() {
		return claimServiceInfo;
	}

	public void setClaimServiceInfo(Set<ClaimServiceInfo> claimServiceInfo) {
		this.claimServiceInfo = claimServiceInfo;
		this.claimServiceInfo.forEach(claimSerInfo -> claimSerInfo.setClaimClaimServiceInfo(this));
	}

	public Set<InstalledParts> getInstalledParts() {
		return installedParts;
	}

	public void setInstalledParts(Set<InstalledParts> installedParts) {
		this.installedParts = installedParts;
		this.installedParts.forEach(installedPart -> installedPart.setClaimInstalledParts(this));
	}

	public Set<RemovedParts> getRemovedParts() {
		return removedParts;
	}

	public void setRemovedParts(Set<RemovedParts> removedParts) {
		this.removedParts = removedParts;
		this.removedParts.forEach(removedPart -> removedPart.setClaimRemovedParts(this));
	}

	public Set<OtherCost> getOtherCost() {
		return otherCost;
	}
	
	public void setOtherCost(Set<OtherCost> otherCost) {
		this.otherCost = otherCost;
		this.otherCost.forEach(oC -> oC.setClaimOtherCost(this));
	}
	
	public String getClaimNumber() {
		return claimNumber;
	}

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
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
	
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(Integer claimId,String claimNumber, String claimType, String accountName, String businessUnit, String serialNumber,
			String model, String partDescription, String part, Double hoursOnMachine, Date workOrderCreationDate,
			Date repairDate, Date purchaseDate, String invoiceNumber, String causalPartDescription,
			String policyDetails, Double laborRate, String claimStatus, String duplicateClaimNumber,
			String claimComments, Boolean preAuthRequired, String preAuthReason, String preAuthComments,
			String appealReason, String appealComments, Integer appealCount, String campaignMember, Date submissionDate,
			String submittedBy, Set<OtherCost> otherCost, Set<InstalledParts> installedParts,
			Set<RemovedParts> removedParts, Set<ClaimServiceInfo> claimServiceInfo
			) {
		super();
		this.claimId = claimId;
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
		this.otherCost = otherCost;
		this.installedParts = installedParts;
		this.removedParts = removedParts;
		this.claimServiceInfo = claimServiceInfo;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", claimType=" + claimType + ", accountName=" + accountName
				+ ", businessUnit=" + businessUnit + ", serialNumber=" + serialNumber + ", model=" + model
				+ ", partDescription=" + partDescription + ", part=" + part + ", hoursOnMachine=" + hoursOnMachine
				+ ", workOrderCreationDate=" + workOrderCreationDate + ", repairDate=" + repairDate + ", purchaseDate="
				+ purchaseDate + ", invoiceNumber=" + invoiceNumber + ", causalPartDescription=" + causalPartDescription
				+ ", policyDetails=" + policyDetails + ", laborRate=" + laborRate + ", claimStatus=" + claimStatus
				+ ", duplicateClaimNumber=" + duplicateClaimNumber + ", claimComments=" + claimComments
				+ ", preAuthRequired=" + preAuthRequired + ", preAuthReason=" + preAuthReason + ", preAuthComments="
				+ preAuthComments + ", appealReason=" + appealReason + ", appealComments=" + appealComments
				+ ", appealCount=" + appealCount + ", campaignMember=" + campaignMember + ", submissionDate="
				+ submissionDate + ", submittedBy=" + submittedBy + ", claimServiceInfo=" + claimServiceInfo + ", otherCost=" + otherCost + ", installedParts="	+ installedParts + ", removedParts=" + removedParts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountName, appealComments, appealCount, appealReason, businessUnit, campaignMember,
				causalPartDescription, claimComments, claimId, claimNumber, claimServiceInfo, claimStatus, claimType,
				duplicateClaimNumber, hoursOnMachine, installedParts, invoiceNumber, laborRate, model, otherCost, part,
				partDescription, policyDetails, preAuthComments, preAuthReason, preAuthRequired, purchaseDate,
				removedParts, repairDate, serialNumber, submissionDate, submittedBy, workOrderCreationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Claim other = (Claim) obj;
		return Objects.equals(accountName, other.accountName) && Objects.equals(appealComments, other.appealComments)
				&& Objects.equals(appealCount, other.appealCount) && Objects.equals(appealReason, other.appealReason)
				&& Objects.equals(businessUnit, other.businessUnit)
				&& Objects.equals(campaignMember, other.campaignMember)
				&& Objects.equals(causalPartDescription, other.causalPartDescription)
				&& Objects.equals(claimComments, other.claimComments) && Objects.equals(claimId, other.claimId)
				&& Objects.equals(claimNumber, other.claimNumber)
				&& Objects.equals(claimServiceInfo, other.claimServiceInfo)
				&& Objects.equals(claimStatus, other.claimStatus) && Objects.equals(claimType, other.claimType)
				&& Objects.equals(duplicateClaimNumber, other.duplicateClaimNumber)
				&& Objects.equals(hoursOnMachine, other.hoursOnMachine)
				&& Objects.equals(installedParts, other.installedParts)
				&& Objects.equals(invoiceNumber, other.invoiceNumber) && Objects.equals(laborRate, other.laborRate)
				&& Objects.equals(model, other.model) && Objects.equals(otherCost, other.otherCost)
				&& Objects.equals(part, other.part) && Objects.equals(partDescription, other.partDescription)
				&& Objects.equals(policyDetails, other.policyDetails)
				&& Objects.equals(preAuthComments, other.preAuthComments)
				&& Objects.equals(preAuthReason, other.preAuthReason)
				&& Objects.equals(preAuthRequired, other.preAuthRequired)
				&& Objects.equals(purchaseDate, other.purchaseDate) && Objects.equals(removedParts, other.removedParts)
				&& Objects.equals(repairDate, other.repairDate) && Objects.equals(serialNumber, other.serialNumber)
				&& Objects.equals(submissionDate, other.submissionDate)
				&& Objects.equals(submittedBy, other.submittedBy)
				&& Objects.equals(workOrderCreationDate, other.workOrderCreationDate);
	}

		
}
