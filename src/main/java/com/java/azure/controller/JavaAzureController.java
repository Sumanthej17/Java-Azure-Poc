package com.java.azure.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.azure.dto.Claim;
import com.java.azure.service.JavaAzureClaimService;

@RestController
public class JavaAzureController {
	
	Logger logger = LoggerFactory.getLogger(JavaAzureController.class);
	
	@Autowired
	private JavaAzureClaimService javaAzureClaimService;
		
	@GetMapping("/")
	public String message() {		
		logger.info("[message] Home Page message");		
		return "Welcome Azure Java POC";
	}
	
	@PostMapping("/addClaim")
	public List<Claim> addClaim(@RequestBody List<Claim> claimList) {
		logger.info("[addClaim] rest api - triggered");
		return javaAzureClaimService.saveClaim(claimList);
	}
	
	@PutMapping("/updateClaim")
	public Claim updateClaim(@RequestBody Claim claim) {
		logger.info("[updateClaim] rest api - triggered");
		return javaAzureClaimService.upateClaim(claim);
	}	
	
	@GetMapping("/getClaim/{claimNumber}")
	public Claim getClaimById(@PathVariable String claimNumber) {
		logger.info("[getClaim] rest api - triggered");
		long startTime = System.currentTimeMillis();
		Claim claim = javaAzureClaimService.getClaimById(claimNumber);
        long endtime = System.currentTimeMillis();
        logger.info("Time taken for Execution is : " + (endtime-startTime) +"ms");
		return claim;
	}
	
	@DeleteMapping("/deleteClaim/{claimNumber}")  
	private String deleteClaimByClaimNumber(@PathVariable String claimNumber)   
	{  
		logger.info("[deleteClaimById] rest api - triggered");
		return javaAzureClaimService.deleteClaimByNumber(claimNumber);  
	}  	
	
	@GetMapping("/getClaims")
	public List<Claim> getClaims() {
		logger.info("[getClaims] rest api - triggered");
		// return javaAzureClaimService.getClaims();
		return null;
	}

}
