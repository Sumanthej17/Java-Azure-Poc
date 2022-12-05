package com.java.azure.service;

import java.util.Iterator;
import java.util.List;

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
		Long claimNumber = getClaimNumber();
		
		for(Claim claim:claimList) {
			claim.setClaimNumber(Long.valueOf(claimNumber).toString());				
			
			if(CollectionUtils.isEmpty(claim.getClaimServiceInfo())==false) {			
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
				Long costId = getRemovedPartsPartId();
				
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
		return null;
	}
	
	@Override
	public Claim upateClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public Claim getClaimById(String claimNumber) {	
		//return claimRepository.findById(claimNumber).get();		
		return claimRepository.getClaimNumberDetails(claimNumber);
	}

	@Override
	public void deleteClaimById(String claimNumber) {
		//try {
		claimRepository.deleteById(claimNumber);
//		}
//		catch(Exception e) {
//			throw new Exception("claim is not exist/found in the DB for the claimNumber :"+claimNumber);
//		}
	}	
	
}
