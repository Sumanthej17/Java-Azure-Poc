package com.java.azure.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.java.azure.dto.Claim;
import com.java.azure.dto.ClaimServiceInfo;
import com.java.azure.dto.InstalledParts;
import com.java.azure.dto.OtherCost;
import com.java.azure.dto.RemovedParts;
import com.java.azure.repo.ClaimRepository;
import com.java.azure.repo.ClaimServiceInfoRepository;
import com.java.azure.repo.InstalledPartsRepository;
import com.java.azure.repo.OtherCostRepository;
import com.java.azure.repo.RemovedPartsRepository;

@Service
public class JavaAzureClaimServiceImpl implements JavaAzureClaimService {
	
	Logger logger = LoggerFactory.getLogger(JavaAzureClaimServiceImpl.class);
	
	public static final Long DEFAULT_CLAIM_NUMBER=(long) 68787000;
	
	public static final Long DEFAULT_JOB_ID=(long) 1;
	
	public static final Long DEFAULT_PART_ID=(long) 1;
	
	public static final Long DEFAULT_COST_ID=(long) 1;
	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	ClaimServiceInfoRepository claimServiceInfoRepository;
	
	@Autowired
	InstalledPartsRepository installedPartsRepository;
	
	@Autowired
	RemovedPartsRepository removedPartsRepository;
	
	@Autowired
	OtherCostRepository otherCostRepository;

	@Override
	public List<Claim> saveClaim(List<Claim> claimList) {	
		
		logger.info("[saveClaim] - to add the Claim data is started");		
		
		Long claimNumber = getClaimNumber();
		
		for(Claim claim:claimList) {
			claim.setClaimNumber(Long.valueOf(claimNumber).toString());				
			
			if(CollectionUtils.isEmpty(claim.getClaimServiceInfo())==false) {				
				logger.info("Adding the ClaimServiceInfo data");			
				Long jobId = getJobId();				
				Iterator<ClaimServiceInfo> claimServiceInfoIterator = claim.getClaimServiceInfo().iterator();					
				while(claimServiceInfoIterator.hasNext()) {					
					ClaimServiceInfo claimServiceInfo = claimServiceInfoIterator.next();
					claimServiceInfo.setJobId(Long.valueOf(jobId).toString());					
					claimServiceInfo.setClaimClaimServiceInfo(claim);					
					jobId++;
				}
			}
			
			if(CollectionUtils.isEmpty(claim.getInstalledParts())==false) {					
				logger.info("Adding the InstalledParts data");
				Long partId = getInstalledPartsPartId();				
				Iterator<InstalledParts> installedPartsIterator = claim.getInstalledParts().iterator();					
				while(installedPartsIterator.hasNext()) {					
					InstalledParts installedParts = installedPartsIterator.next();
					installedParts.setPartId(Long.valueOf(partId).toString());					
					installedParts.setClaimInstalledParts(claim);					
					partId++;
				}
			}
			
			if(CollectionUtils.isEmpty(claim.getRemovedParts())==false) {					
				logger.info("Adding the RemovedParts data");
				Long partId = getRemovedPartsPartId();				
				Iterator<RemovedParts> removedPartsIterator = claim.getRemovedParts().iterator();				
				while(removedPartsIterator.hasNext()) {					
					RemovedParts removedParts = removedPartsIterator.next();
					removedParts.setPartId(Long.valueOf(partId).toString());					
					removedParts.setClaimRemovedParts(claim);					
					partId++;
				}
			}
			
			if(CollectionUtils.isEmpty(claim.getOtherCost())==false) {
				logger.info("Adding the OtherCost data");
				Long costId = getCostId();				
				Iterator<OtherCost> otherCostIterator = claim.getOtherCost().iterator();				
				while(otherCostIterator.hasNext()) {					
					OtherCost otherCost = otherCostIterator.next();
					otherCost.setCostId(Long.valueOf(costId).toString());					
					otherCost.setClaimOtherCost(claim);					
					costId++;
				}
			}			
			claimNumber++;
		}		
		claimRepository.saveAll(claimList);		
		logger.info("[saveClaim] - to add the Claim data is completed");
		return claimList;
	}	

	private Long getClaimNumber() {			
		Claim claim = claimRepository.findTop1ByOrderByClaimNumberDesc();
		if(claim!=null) {
			return Long.valueOf(Long.parseLong(claim.getClaimNumber())+1);
		}		
		return DEFAULT_CLAIM_NUMBER;
	}
	
	
	private Long getJobId() {			
		ClaimServiceInfo claimServiceInfo = claimServiceInfoRepository.findTop1ByOrderByJobIdDesc();
		if(claimServiceInfo!=null) {
			return Long.valueOf(Long.parseLong(claimServiceInfo.getJobId())+1);
		}		
		return DEFAULT_JOB_ID;
	}
	
	private Long getRemovedPartsPartId() {			
		RemovedParts removedParts = removedPartsRepository.findTop1ByOrderByPartIdDesc();
		if(removedParts!=null) {
			return Long.valueOf(Long.parseLong(removedParts.getPartId())+1);
		}		
		return DEFAULT_PART_ID;
	}
	
	private Long getInstalledPartsPartId() {			
		InstalledParts installedParts = installedPartsRepository.findTop1ByOrderByPartIdDesc();
		if(installedParts!=null) {
			return Long.valueOf(Long.parseLong(installedParts.getPartId())+1);
		}		
		return DEFAULT_PART_ID;
	}
	
	private Long getCostId() {			
		OtherCost otherCost = otherCostRepository.findTop1ByOrderByCostIdDesc();
		if(otherCost!=null) {
			return Long.valueOf(Long.parseLong(otherCost.getCostId())+1);
		}		
		return DEFAULT_COST_ID;
	}
	
	

	@Override
	public List<Claim> getClaims() {
		logger.info("[getClaims] - returning all claims data details");
		return null;
	}
	
	@Override
	public Claim upateClaim(Claim claim) {
		logger.info("[upateClaim] - upading the Claim data for claim id: "+claim.getClaimNumber());
		return claimRepository.save(claim);
	}

	@Override
	public Claim getClaimById(String claimNumber) {	
		logger.info("[getClaimById] - finding the Claim data for claim id: "+claimNumber);	
		//return claimRepository.findById(claimNumber).get();		
		return claimRepository.getClaimNumberDetails(claimNumber);
	}

	@Override
	public String deleteClaimById(String claimNumber) {
		logger.info("[deleteClaimById] - deleting the Claim data for claim id: "+claimNumber);	
		try {
		claimRepository.deleteById(claimNumber);
		return "successfully claim data is deleted for claimNumber : "+claimNumber;
		}
		catch(Exception e) {
			logger.error("Deletion Exception : "+e);	
			//throw new Exception("claim is not exist/found in the DB for the claimNumber :"+claimNumber);
			return "claim is not exist/found in the DB for the claimNumber :"+claimNumber;
		}
	}	
	
}
