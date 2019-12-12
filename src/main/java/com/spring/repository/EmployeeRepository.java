package com.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.Employee;
import com.spring.dto.Project;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


	
}
