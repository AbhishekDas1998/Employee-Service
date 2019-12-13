package com.spring.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Employee_Details")
public class Employee {

	@Id
	@Column(name = "E_Id")
	private int eId;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	@Column(name = "E_name")
	private String name;

	@Column(name = "E_Designation")
	private String designation;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "Emp_Id")
	private List<SkillsEmployee> skill;

	public Employee() {

	}

	public List<SkillsEmployee> getSkill() {
		return skill;
	}

	public void setSkill(List<SkillsEmployee> skill) {
		this.skill = skill;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
