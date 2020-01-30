package com.bcits.employeedatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;
import com.bcits.employeedatajpa.beans.EmployeeResponse;
import com.bcits.employeedatajpa.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping(path = "/getEmp",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean employeeInfoBean  = repository.findById(empId).get();
		
		EmployeeResponse response = new EmployeeResponse();
		
		if(employeeInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Record Found for ID"+empId);
			response.setEmployeeInfoBean(employeeInfoBean);
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Employee Record not Found for ID"+empId);
		}
		return response;
		
	}//end of getEmployee()
	
	@GetMapping(path = "/getEmpData",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployeeData(int empId, String password) {
		 EmployeeInfoBean  employeeInfoBean= repository.findByIdAndPassword(empId, password);
		
		EmployeeResponse response = new EmployeeResponse();
		
		if(employeeInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Record Found for ID"+empId);
			response.setEmployeeInfoBean(employeeInfoBean);
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Employee Record not Found for ID"+empId);
		}
		return response;
		
	}//end of getEmployee()
}
