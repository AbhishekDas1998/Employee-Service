package com.spring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	public Employee() {

	}

	public Employee(int eId, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			String designation) {
		super();
		this.eId = eId;
		this.name = name;
		this.designation = designation;
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
