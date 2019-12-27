package com.spring.dto;

/**
 * @author Abhishek.Das
 *
 */
public class EmployeeProject {

	private int eId;
	private String pName;
	
	
	public EmployeeProject() {
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
