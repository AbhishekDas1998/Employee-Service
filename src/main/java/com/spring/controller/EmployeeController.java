package com.spring.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.dto.Employee;
import com.spring.dto.EmployeeProject;
import com.spring.dto.EmployeeSkill;
import com.spring.service.EmployeeServiceClass;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceClass ser;

	@GetMapping(path = "/getAllEmployees")
	public List<Employee> findAllEmployees() {
		return ser.findAllEmployees();
	}

	@PostMapping(path = "/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) throws Exception {
		Employee savedEmployee = ser.addEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{eId}")
				.buildAndExpand(savedEmployee.geteId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/getEmployee/{eId}")
	public Employee findOneEmployee(@PathVariable int eId) {
		return ser.findOneEmployee(eId);

	}

	@DeleteMapping(path = "/deleteEmployee/{eId}")
	public String deleteEmployee(@PathVariable int eId) {
		ser.deleteEmployee(eId);
		return "Employee deleted with eId " + eId;

	}

	@PutMapping(path = "/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		ser.updateEmployee(employee);
		return "Employee updated with id " + employee.geteId();
	}

	@PostMapping(path = "/addEmployeeSkill")
	public ResponseEntity<Employee> addEmployeeSkill(@Valid @RequestBody EmployeeSkill employee) throws Exception {
		Employee savedEmployee = ser.assignSkillEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{eId}")
				.buildAndExpand(savedEmployee.geteId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/addEmployeeProject")
	public ResponseEntity<Employee> addEmployeeProject(@Valid @RequestBody EmployeeProject employee) throws Exception {
		Employee savedEmployee = ser.assignProjectEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{eId}")
				.buildAndExpand(savedEmployee.geteId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
