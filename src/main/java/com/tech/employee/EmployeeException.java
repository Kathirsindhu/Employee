package com.tech.employee;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException extends Exception {
	@ExceptionHandler(EmployeeException1.class)
	public ResponseEntity<Object> noNameExceptionHandling(EmployeeException1 n) {
		return new ResponseEntity<Object>(n.getMessage(), HttpStatus.NOT_FOUND);
	}

}
