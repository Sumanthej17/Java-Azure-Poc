package com.java.azure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaAzureController {
	
	@GetMapping("/message")
	public String message() {
		return "Hello Azure POC";
	}


}
