package com.rrrs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rrrs.model.TestBody;

@RestController
public class Test19Feb21 {

	@Value("${spring.datasource.driver-class-name}")
	private static String dataBase;
	@PostMapping("/data")
	public String checkLength( @RequestBody TestBody body){
		//System.out.println(resultBind.getFieldErrorCount());
		System.out.println("body--"+dataBase);
		return ""+body;
	}
}
