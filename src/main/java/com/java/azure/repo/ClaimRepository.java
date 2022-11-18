package com.java.azure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.azure.dto.Claim;

public interface ClaimRepository extends JpaRepository<Claim, String> {
	
	public Claim findTop1ByOrderByClaimNumberDesc();

}
