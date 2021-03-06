package com.rrrs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class MyStreamApi {

	@GetMapping(value = "/stream")
	public void myStreamTest() {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		System.out.println(list);
		List<Integer> collect = list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(collect);
		
	}
}
