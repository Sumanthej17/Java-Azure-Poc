package com.java.azure.service;

import java.util.List;

import com.java.azure.dto.Claim;

public interface JavaAzureClaimService {	
	
	public List<Claim> saveClaim(List<Claim> claimList);	
	
	public Claim upateClaim(Claim claim);
	
//	public List<Claim> getClaims();

	public Claim getClaimById(String claimNumber);
	
	public String deleteClaimByNumber(String claimNumber);
	
}
