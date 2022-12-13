package com.java.azure.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.azure.dto.Claim;
import com.java.azure.repo.ClaimRepository;

@Service
public class JavaAzureClaimServiceImpl implements JavaAzureClaimService {
	
	Logger logger = LoggerFactory.getLogger(JavaAzureClaimServiceImpl.class);
		
	@Autowired
	ClaimRepository claimRepository;
	
	@Override
	public List<Claim> saveClaim(List<Claim> claimList) {	
		
		logger.info("[saveClaim] - to add the Claim data is started");		
		claimRepository.saveAll(claimList);		
		logger.info("[saveClaim] - to add the Claim data is completed");
		return claimList;
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
		//return claimRepository.getByClaimNumber(claimNumber);
		return claimRepository.getClaimNumberDetails(claimNumber);		
	}

	@Override
	@Transactional
	public String deleteClaimByNumber(String claimNumber) {
		logger.info("[deleteClaimByClaimNumber] - deleting the Claim data for claimNumber: "+claimNumber);	
		try {
		claimRepository.deleteByClaimNumber(claimNumber);
		return "successfully claim data is deleted for claimNumber : "+claimNumber;
		}
		catch(Exception e) {
			logger.error("Deletion Exception : "+e);	
			//throw new Exception("claim is not exist/found in the DB for the claimNumber :"+claimNumber);
			return "claim is not exist/found in the DB for the claimNumber :"+claimNumber;
		}
	}	
	
}
