package com.tech.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SalaryNotFoundExceptionHandler {
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> salaryNotFoundException(SalaryNotFoundException s) {
		return new ResponseEntity<Object>(s.getMessage(), HttpStatus.NOT_FOUND);
	}

}
