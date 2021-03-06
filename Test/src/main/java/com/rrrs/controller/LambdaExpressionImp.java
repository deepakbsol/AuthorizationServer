package com.rrrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrrs.functionalInterface.Interface1;
import com.rrrs.functionalInterface.Interface2;
import com.rrrs.functionalInterface.MyFunctionalInterface;
import com.rrrs.model.MethodImplementationsClass;

@RestController
@RequestMapping("/api/lambda")
public class LambdaExpressionImp {

	MyFunctionalInterface myFunctionalInterface=()->{
		System.out.println("imaplemented");
	};
	Interface1 intrf1=x -> {
		return x*x;
	};
	@GetMapping("/test")
	public void test() {
		myFunctionalInterface.ma();
		System.out.println("done");
	}
	@GetMapping("/test2")
	public void test2(){
		myFunctionalInterface.ma();
	}
	
	@GetMapping("/square")
	public double square(@RequestParam(name = "number") double number) {
		return intrf1.square(number);
	}
	private MethodImplementationsClass inter;
	@Autowired
	public void setMethodImplementationsClass(MethodImplementationsClass inter) {
		this.inter=inter;
	}
	@GetMapping("/methodMapping/{data1}/{data2}")
	public double methodMapping(@PathVariable(name = "data1") double num1,@PathVariable(name = "data2") double num2) {
		Interface2 it=inter::sumOfData;
		return it.sum(num1, num2);
	}
	
	
	
}
