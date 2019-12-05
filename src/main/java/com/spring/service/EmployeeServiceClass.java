package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Employee;
import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceClass {


	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> findAllEmployees(){
		return repo.findAll();
	}
	
	public Employee addEmployee(Employee emp){
		  return repo.save(emp);
	}
	
	public Employee findOneEmployee(int eId){
		Optional<Employee> empOptional = repo.findById(eId);
		   if(empOptional.isPresent()) {
			   return empOptional.get();
		   }else {
			   return new Employee();
		   }
	}
	
	public void deleteEmployee(int eId){
		
		repo.deleteById(eId);
	}
	
	public Employee updateEmployee(Employee emp)
	{
		Employee e=new Employee();
		Optional<Employee> empOptional = repo.findById(emp.geteId());
		if(empOptional.isPresent())
		{
			e=empOptional.get();
			e.setName(emp.getName());
			e.setDesignation(emp.getDesignation());
			repo.save(e);
		}
		return e;
		
	}
}
