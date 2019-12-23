package com.spring.dto;

/**
 * @author Abhishek.Das
 *
 */
public class Employee_Skill {

	private int eId;
	private String sName;

	public Employee_Skill() {
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Employee_Skill [eId=" + eId + ", sName=" + sName + "]";
	}

}
