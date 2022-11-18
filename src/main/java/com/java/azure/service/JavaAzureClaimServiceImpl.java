package com.java.azure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.azure.dto.Claim;
import com.java.azure.repo.ClaimRepository;

@Service
public class JavaAzureClaimServiceImpl implements JavaAzureClaimService {	
	
	public static final Long DEFAULT_CLAIM_NUMBER=(long) 68787000;
	
	@Autowired
	ClaimRepository claimRepository;

	@Override
	public List<Claim> saveClaim(List<Claim> claimList) {		
		Long claimNumber = getClaimNumber();
		for(Claim c:claimList) {
			c.setClaimNumber(Long.valueOf(claimNumber).toString());	
			claimNumber++;
		}			
		return claimRepository.saveAll(claimList);
	}	

	private Long getClaimNumber() {			
		Claim claim = claimRepository.findTop1ByOrderByClaimNumberDesc();
		if(claim!=null) {
			return Long.valueOf(Long.parseLong(claim.getClaimNumber())+1);
		}		
		return DEFAULT_CLAIM_NUMBER;
	}

	@Override
	public List<Claim> getClaims() {
		// return claimRepository.findAll();
		return null;
	}
	
	@Override
	public Claim upateClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public Claim getClaimById(String claimNumber) {	
		return claimRepository.findById(claimNumber).get();		
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
