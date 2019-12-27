package com.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhishek.Das
 *
 */
@Entity
@Table(name = "Employee_Project")
public class ProjectEmployee {

	@Id
	private int pId;
	private String pName;

	public ProjectEmployee() {

	}

	public ProjectEmployee(int pId, String pName) {
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

	@Override
	public String toString() {
		return "Project [pId=" + pId + ", pName=" + pName + "]";
	}

	
}
