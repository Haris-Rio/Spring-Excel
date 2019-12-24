package com.example.demo;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TechNetRequestData {

	private List<TechNetData> techNetDataList;

	public List<TechNetData> getTechNetDataList() {
		return techNetDataList;
	}

	public void setTechNetDataList(List<TechNetData> techNetDataList) {
		this.techNetDataList = techNetDataList;
	}

	
	  
	@Override 
	public String toString() { 
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	
	}
	  
	  //TODO toString()
	 }
