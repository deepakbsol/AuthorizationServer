package com.rrrs.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class TestResource {

	@GetMapping("/test")
	public String getTestMessage() {
		System.out.println("tested");
		return "tested ";
	}
	
}
