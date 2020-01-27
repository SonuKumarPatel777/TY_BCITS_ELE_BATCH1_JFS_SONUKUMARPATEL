package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.springmvc.customexceptions.EmployeeException;
@ControllerAdvice
public class EmployeeControllerAdvice {
	
	@ExceptionHandler(EmployeeException.class)
	public String handleEmployeeException(EmployeeException empEx, HttpServletRequest req) {
		String errMsg= empEx.getMessage();
		req.setAttribute("errMsg", errMsg);
		
		return "errPage";
		
	}

}//End of class
