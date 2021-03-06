package com.rrrs.config.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rrrs.config.annotation.LongDateFormat;
import com.rrrs.config.annotation.ValidFormatName;
import com.rrrs.config.annotation.ValidTable;

public class ConfigInfo {

	@ValidTable
	@JsonProperty("tablename")
	private String tablename;

	@ValidFormatName
	@JsonProperty("formatname")
	private String formatname;

	@JsonProperty("desc")
	private String desc;

	@JsonProperty("fileext")
	private String fileExt;

	@JsonProperty("colscount")
	private int colCount;

	@JsonProperty("formatid")
	private int configId;

	@JsonProperty("flag")
	private boolean flag;

	@JsonIgnore
	private String userIns;
	@JsonIgnore
	@LongDateFormat
	private Date dateIns;
	@JsonProperty("delimiter")
	private Character delimiter;

	public Character getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(Character delimiter) {
		this.delimiter = delimiter;
	}


	public ConfigInfo() {
		super();
	}


	public String getTablename() {
		return tablename;
	}


	public void setTablename(String tablename) {
		this.tablename = tablename;
	}


	public String getFormatname() {
		return formatname;
	}


	public void setFormatname(String formatname) {
		this.formatname = formatname;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getFileExt() {
		return fileExt;
	}


	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}


	public int getColCount() {
		return colCount;
	}


	public void setColCount(int colCount) {
		this.colCount = colCount;
	}


	public int getConfigId() {
		return configId;
	}


	public void setConfigId(int configId) {
		this.configId = configId;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
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


	@Override
	public String toString() {
		return "ConfigInfo [tablename=" + tablename + ", formatname=" + formatname + ", desc=" + desc + ", fileExt="
				+ fileExt + ", colCount=" + colCount + ", configId=" + configId + ", flag=" + flag + ", userIns="
				+ userIns + ", dateIns=" + dateIns + ", delimiter=" +delimiter+"]";
	}

}
