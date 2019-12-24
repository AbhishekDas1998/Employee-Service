package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.dto.Employee;
import com.spring.dto.Employee_Project;
import com.spring.dto.Employee_Skill;
import com.spring.dto.SkillsEmployee;
import com.spring.exception.EmployeeAlreadyhasProjectsException;
import com.spring.exception.EmployeeNotFoundException;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.RestTempleteImpl;

@Service
public class EmployeeServiceClass {

	@Autowired
	EmployeeRepository repo;

	@Autowired
	RestTempleteImpl restimpl;

	public List<Employee> findAllEmployees() {
		
		List<Employee> employee= repo.findAll();
		if(employee.isEmpty())
		{
			throw new EmployeeNotFoundException("No Employees found");
		}
		return employee;
	}

	public Employee addEmployee(Employee emp) throws JsonMappingException, JsonProcessingException {
		return repo.save(emp);
	}

	public Employee findOneEmployee(int eId) {
		Optional<Employee> empOptional = repo.findById(eId);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			throw new EmployeeNotFoundException("Employee Not found with eId =" + eId);
		}
	}

	public void deleteEmployee(int eId) {
		Optional<Employee> empOptional = repo.findById(eId);
		if (empOptional.isPresent()) {
		repo.deleteById(eId);
		}
		else {
			throw new EmployeeNotFoundException("Employee Not found with eId =" + eId);
		}
	}

	public Employee updateEmployee(Employee emp) {
		Employee e = new Employee();
		Optional<Employee> empOptional = repo.findById(emp.geteId());
		if (empOptional.isPresent()) {
			e = empOptional.get();
			e.setName(emp.getName());
			e.setDesignation(emp.getDesignation());
			repo.save(e);
		}
		return e;

	}

	public Employee assignSkillEmployee(Employee_Skill employee) throws JsonMappingException, JsonProcessingException {
		Optional<Employee> empOptional = repo.findById(employee.geteId());
		if (empOptional.isPresent()) {
			Employee e = empOptional.get();

			List<SkillsEmployee> empSkills = e.getSkill();
			for (SkillsEmployee skills : restimpl.getSkillByName(employee.getsName())) {
				empSkills.add(skills);
			}
			e.setSkill(empSkills);
			return repo.save(e);
		} else {
			throw new EmployeeNotFoundException("Employee Not found");
		}
	}
	
	
	public Employee assignProjectEmployee(Employee_Project employee) throws JsonMappingException, JsonProcessingException {
		Optional<Employee> empOptional = repo.findById(employee.geteId());
		if (empOptional.isPresent()) {
			
			Employee e = empOptional.get();
			if(e.getProject()==null)
			{
			e.setProject(restimpl.getProjectByName(employee.getpName()));
			return repo.save(e);
			}
			else {
				throw new EmployeeAlreadyhasProjectsException("Employee already has projects");
			}
		} else {
			throw new EmployeeNotFoundException("Employee Not found");
		}
	}
	

}
