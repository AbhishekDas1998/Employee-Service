package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class EmployeeAlreadyhasProjectsException extends RuntimeException {

	public EmployeeAlreadyhasProjectsException(String message) {
		super(message);

	}

	
}
