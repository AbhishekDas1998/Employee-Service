package com.spring.dto;

public class Employee_Project {

	private int eId;
	private String pName;
	
	
	public Employee_Project() {
	}
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "Employee_Project [eId=" + eId + ", pName=" + pName + "]";
	}
	
	
	
	
	
}
