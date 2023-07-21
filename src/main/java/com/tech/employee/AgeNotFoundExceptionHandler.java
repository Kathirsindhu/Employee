package com.tech.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AgeNotFoundExceptionHandler {
	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<Object> ageNotFoundException(AgeNotFoundException a) {
		return new ResponseEntity<Object>(a.getMessage(), HttpStatus.NOT_FOUND);
	}

}
