package com.example.demo;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TechNetData {
private String fulfilmentCenter;
//private List<String> fulfilmentCenterList;
//	
//	public List<String> getFulfilmentCenterList() {
//	return fulfilmentCenterList;
//}
//
//public void setFulfilmentCenterList(List<String> fulfilmentCenterList) {
//	this.fulfilmentCenterList = fulfilmentCenterList;
//}

	private List<String> techId;

	
	 
	public TechNetData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechNetData(String fulfilmentCenter, List<String> techId) {
	
	this.fulfilmentCenter = fulfilmentCenter;
	this.techId = techId;
}

	public String getFulfilmentCenter() {
		return fulfilmentCenter;
	}

	public void setFulfilmentCenter(String fulfilmentCenter) {
		this.fulfilmentCenter = fulfilmentCenter;
	}

	public List<String> getTechId() {
		return techId;
	}

	public void setTechId(List<String> techId) {
		this.techId = techId;
	}
	
	  @Override public String toString() { return
	  ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	  
	  }
	 
}
