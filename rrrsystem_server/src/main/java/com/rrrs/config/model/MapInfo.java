package com.rrrs.config.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rrrs.config.annotation.ValidColumn;
import com.rrrs.config.annotation.ValidDatatype;
import com.rrrs.config.annotation.ValidHeader;

@Entity
@Table(name = "")
public class MapInfo implements Serializable{
	
	@JsonProperty("id")
	@Column(name="")
	private Integer seqId;
	
	@ValidHeader
	@JsonProperty("col")
	@Column(name = "")
	private String col;
	
	@ValidColumn
	@JsonProperty("tabcol")
	@Column(name = "")
	private String tabcol;

	@JsonIgnore
	@Column(name = "")
	private Integer configId;
	
	@JsonIgnore
	@Column(name = "")
	private String userIns;
	
	@JsonIgnore
	@Column(name = "")
	private Date dateIns;
	
	@ValidDatatype
	@JsonProperty("datatype")
	@Column(name = "")
	private String datatype;
	
	@JsonProperty("datasize")
	@Column(name = "")
	private int datasize;
	
	@JsonProperty("nullable")
	@Column(name = "")
	private String defaultvalue;

	public Integer getSeqId() {
		return seqId;
	}

	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getTabcol() {
		return tabcol;
	}

	public void setTabcol(String tabcol) {
		this.tabcol = tabcol;
	}

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getUserIns() {
		return userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public Date getDateIns() {
		return dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public int getDatasize() {
		return datasize;
	}

	public void setDatasize(int datasize) {
		this.datasize = datasize;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}


}
