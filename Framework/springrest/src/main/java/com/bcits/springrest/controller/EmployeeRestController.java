package com.bcits.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.beans.EmployeeResponse;
import com.bcits.springrest.service.EmployeeService;

//@Controller
@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService service ;
	
	@GetMapping(path="/getEmployee",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean employeeInfoBean  = service.getEmployee(empId);
		
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
	 
	@GetMapping(path="/getAllEmployee",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public  EmployeeResponse getAllEmployee() {
		  List<EmployeeInfoBean> employeeList = service.getAllEmployee();
		  EmployeeResponse response = new EmployeeResponse();
		  if( employeeList != null) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("REcord fatched Successfully");
				response.setEmployeeList(employeeList);
			}else {
				response.setStatusCode(401);
				response.setMessage("failed");
				response.setDescription("Unable to fatch record");
			}
			return response;
		  
	}//end ofgetAllEmployee()
	
	
	@DeleteMapping(path="/deleteEmployee/{employeeID}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
    public EmployeeResponse deleteEmployee(@PathVariable(name = "employeeID")int empId) {
	     boolean isDelete = service.deleteEmployee(empId);
	     EmployeeResponse response = new EmployeeResponse();
		  if( isDelete ) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription(" Employee Record delete Successfully");
				 
			}else {
				response.setStatusCode(401);
				response.setMessage("failed");
				response.setDescription("Unable to delete Employee Record  ");
			}
			return response;
		
	}//End of deleteEmployee()
	
	@PostMapping(path="/addEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
    public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
	     boolean isAdded = service.addEmployee(employeeInfoBean,"qwert");
	     EmployeeResponse response = new EmployeeResponse();
		  if( isAdded ) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription(" Employee Record added Successfully");
				 
			}else {
				response.setStatusCode(401);
				response.setMessage("failed");
				response.setDescription("Unable to add Employee Record  ");
			}
			return response;
		
	}//End of addEmployee()
	
	@PutMapping(path="/updateEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
    public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
	     boolean isUpdate = service.updateEmployee(employeeInfoBean);
	     EmployeeResponse response = new EmployeeResponse();
		  if( isUpdate ) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription(" Employee Record update Successfully");
				 
			}else {
				response.setStatusCode(401);
				response.setMessage("failed");
				response.setDescription("Unable to update Employee Record  ");
			}
			return response;
		
	}//End of updateEmployee()

}//End of class
