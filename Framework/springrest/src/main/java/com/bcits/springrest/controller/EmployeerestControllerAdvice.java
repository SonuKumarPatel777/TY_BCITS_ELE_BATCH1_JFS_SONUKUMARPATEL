package com.bcits.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bcits.springrest.beans.EmployeeResponse;
import com.bcits.springrest.exception.EmployeeException;

@RestControllerAdvice
public class EmployeerestControllerAdvice {
	
	
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse handlerEmployeeException(EmployeeException ex) {
		EmployeeResponse response =new EmployeeResponse();
		response.setStatusCode(501);
		response.setMessage("exception");
		response.setDescription(ex.getMessage());
		
		return response;
		
	}//end of handlerEmployeeException()

}//end of class
