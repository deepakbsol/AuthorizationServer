package com.rrrs.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.rrrs.annotation.CustomeLength;

public class TestBody {

	@JsonProperty("name")
	private String names;
	@JsonProperty("usn")
	@JsonIgnore
	private String usn;
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public childClass getDatavalue() {
		return datavalue;
	}

	public void setDatavalue(childClass datavalue) {
		this.datavalue = datavalue;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd:MM:yyyy")
	private Date date;
	//@JsonProperty("childData")
	@JsonUnwrapped
	private childClass datavalue;
	/*
	 * public String getName() { return names; }
	 */

	/*
	 * public void setNAMe(String abc) { this.names = abc; } public String getUsn()
	 * { return usn; } public void setUsn(String usn) { this.usn = usn; }
	 */
	@Override
	public String toString() {
		return "TestBody [name=" + names + ", usn=" + usn +", date="+date +", datavalue= "+datavalue+"]";
	}
	
}
