package com.spring.dto;

public class Project {

	private int pId;
	private String pName;

	public Project() {

	}

	public Project(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;

	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

}
