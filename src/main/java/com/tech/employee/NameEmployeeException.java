package com.tech.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NameEmployeeException {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameNotFoundException(NameNotFoundException n) {
		return new ResponseEntity<Object>(n.getMessage(), HttpStatus.NOT_FOUND);
	}

}
