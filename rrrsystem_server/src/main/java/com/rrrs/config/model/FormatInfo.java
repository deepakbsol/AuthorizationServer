package com.rrrs.config.model;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormatInfo {

    @Valid
	@JsonProperty("config")
	private ConfigInfo configInfo;

    @Valid
	@JsonProperty("mappings")
	private List<MapInfo> mapInfo;

	public FormatInfo() {
		super();
	}

	public FormatInfo(ConfigInfo configInfo, List<MapInfo> mapInfo) {
		super();
		this.configInfo = configInfo;
		this.mapInfo = mapInfo;
	}

	public ConfigInfo getConfigInfo() {
		return configInfo;
	}

	public void setConfigInfo(ConfigInfo configInfo) {
		this.configInfo = configInfo;
	}

	public List<MapInfo> getMapInfo() {
		return mapInfo;
	}

	public void setMapInfo(List<MapInfo> mapInfo) {
		this.mapInfo = mapInfo;
	}

	@Override
	public String toString() {
		return "FormatInfo [configInfo=" + configInfo + ", mapInfo=" + mapInfo + "]";
	}

}
