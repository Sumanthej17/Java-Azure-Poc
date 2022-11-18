package com.java.azure.controller;

import java.util.List;

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
	
	@Autowired
	private JavaAzureClaimService javaAzureClaimService;
		
	@GetMapping("/")
	public String message() {
		return "Hello Azure POC";
	}
	
	@PostMapping("/addClaim")
	public List<Claim> addClaim(@RequestBody List<Claim> claimList) {
		return javaAzureClaimService.saveClaim(claimList);
	}
	
	@PutMapping("/updateClaim")
	public Claim updateClaim(@RequestBody Claim claim) {
		return javaAzureClaimService.upateClaim(claim);
	}	
	
	@GetMapping("/getClaim/{claimNumber}")
	public Claim getClaimById(@PathVariable String claimNumber) {
		return javaAzureClaimService.getClaimById(claimNumber);
	}
	
	@DeleteMapping("/deleteClaim/{claimNumber}")  
	private void deleteClaimById(@PathVariable String claimNumber)   
	{  
		javaAzureClaimService.deleteClaimById(claimNumber);  
	}  	
	
	@GetMapping("/getClaims")
	public List<Claim> getClaims() {
		// return javaAzureClaimService.getClaims();
		return null;
	}

}
