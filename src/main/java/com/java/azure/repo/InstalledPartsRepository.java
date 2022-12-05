package com.java.azure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.azure.dto.InstalledParts;

public interface InstalledPartsRepository extends JpaRepository<InstalledParts, String> {	
	
	public InstalledParts findTop1ByOrderByPartIdDesc();	

}
