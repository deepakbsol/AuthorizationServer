package com.rrrs.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/resource")
public class MyTestController {

	@GetMapping(value = "/test")
	public String test(){
		return "hello !!!";
	}
}
