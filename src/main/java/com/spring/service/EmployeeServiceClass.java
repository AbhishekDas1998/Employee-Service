package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Employee;
import com.spring.dto.Project;
import com.spring.dto.ProjectEmployee;
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
		return repo.findAll();
	}

	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}

	public Employee findOneEmployee(int eId) {
		Optional<Employee> empOptional = repo.findById(eId);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			return new Employee();
		}
	}

	public void deleteEmployee(int eId) {

		repo.deleteById(eId);
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

	public Project assignProject(Project project) {

		return restimpl.assignproject(project);

	}

	public Project getProjectsById(int pId) {
		return restimpl.getProjectbyId(pId);

	}

	public ProjectEmployee assignProjectEmployee(ProjectEmployee project) {

		ProjectEmployee emp = restimpl.getProjectEmployeebyId(project.geteId());
		Optional<Employee>employee=repo.findById(project.geteId());
		if(employee.isPresent())
		{
		String p="";
		 p = Integer.toString(emp.getpId());
		if(emp.geteId()==0)
		{
		project = restimpl.assignprojectEmployee(project);
		 p = Integer.toString(emp.getpId());
		}
		else if(p.isEmpty())
		{
			project = restimpl.assignprojectEmployee(project);
		}
		else {
			throw new EmployeeAlreadyhasProjectsException(
					"Employee with eId " + emp.geteId() + " already has projects ");
		}
		}
		else {
			throw new EmployeeNotFoundException("Employee doesn't exist");
		}
		return project;
		
	}

	public ProjectEmployee getProjectEmployeeById(int eId) {
		return restimpl.getProjectEmployeebyId(eId);

	}

}
