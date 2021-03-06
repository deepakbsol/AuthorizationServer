package com.rrrs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class childClass {

	@JsonProperty("child")
	private String childData;

	@Override
	public String toString() {
		return "childClass [child=" + childData + "]";
	}
	
}
