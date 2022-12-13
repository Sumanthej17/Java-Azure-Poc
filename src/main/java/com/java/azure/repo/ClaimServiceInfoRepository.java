package com.java.azure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.azure.dto.ClaimServiceInfo;

public interface ClaimServiceInfoRepository extends JpaRepository<ClaimServiceInfo, Integer> {	
	

}
