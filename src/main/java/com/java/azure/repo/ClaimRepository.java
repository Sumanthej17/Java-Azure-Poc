package com.java.azure.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.azure.dto.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	
	@Query("FROM Claim claim LEFT JOIN FETCH claim.otherCost otherCost LEFT JOIN FETCH claim.installedParts installedParts LEFT JOIN FETCH claim.removedParts removedParts LEFT JOIN FETCH claim.claimServiceInfo claimServiceInfo where claim.claimNumber=:claimNumber")
	public Claim getClaimNumberDetails(String claimNumber);
	
	public long deleteByClaimNumber(String claimNumber);
	
}
