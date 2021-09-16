package com.Neosoft.Employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Error> ExcepHandle(Throwable t){
		Error error= new Error();
		error.setId(1);
		error.setName(t.getMessage());
		error.setExcep(t);
		error.setEcode("ECD420");
		return  new ResponseEntity<Error>(error,HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
	
		 
	}



}
