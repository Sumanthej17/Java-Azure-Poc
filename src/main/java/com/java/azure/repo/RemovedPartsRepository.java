package com.java.azure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.azure.dto.RemovedParts;

public interface RemovedPartsRepository extends JpaRepository<RemovedParts, String> {	
	
	public RemovedParts findTop1ByOrderByPartIdDesc();	

}
