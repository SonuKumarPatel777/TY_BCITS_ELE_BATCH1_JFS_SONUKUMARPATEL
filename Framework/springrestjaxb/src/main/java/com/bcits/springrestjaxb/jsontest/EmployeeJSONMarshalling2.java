package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONMarshalling2 {
	
	public static void main(String[] args) {
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		 
		employeeInfoBean.setName("sonu kumar");
		employeeInfoBean.setMobileNum(7845124578L); 
		employeeInfoBean.setDateOfBirth(new Date());
		employeeInfoBean.setDateOfJoining(new Date());
		employeeInfoBean.setDesignation("SSD");
		employeeInfoBean.setBloodGroup("O+");
		employeeInfoBean.setEmployeeSalary((double) 55000);
		employeeInfoBean.setDepartmentId(45); 
		employeeInfoBean.setPassword("qweertyu");
		
		//marshalling into JSON
		
		try {
			ObjectMapper mapper =new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();//formated
			mapper.writeValue(new File("empjson4.json"), employeeInfoBean);
			mapper.writeValue(System.out, employeeInfoBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}//End of main()

}//End of class
