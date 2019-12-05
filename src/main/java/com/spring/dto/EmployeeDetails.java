package com.spring.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_skill_proj")
public class EmployeeDetails {

	@Id
	@GeneratedValue
	private long empdetailid;
	private long empId;
	private long skillId;
	private long projectId;
	private String skillName;
	private String projectName;

	public EmployeeDetails() {

	}

	public long getEmpdetailid() {
		return empdetailid;
	}

	public void setEmpdetailid(long empdetailid) {
		this.empdetailid = empdetailid;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
