package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONUnmarshalling {

	public static void main(String[] args) {
		
		
		//Unmarshalling from JSON
		
		try {
			ObjectMapper mapper =new ObjectMapper();
			EmployeeInfoBean employeeInfoBean = mapper.readValue(new File("empjson3.json"),EmployeeInfoBean.class);
			
			System.out.println("Emp ID             :"+employeeInfoBean.getEmpId());
			System.out.println("Emp name           :"+employeeInfoBean.getName());
			System.out.println("Emp MN             :"+employeeInfoBean.getMobileNum());
			System.out.println("Emp OfficalMailId  :"+employeeInfoBean.getOfficalMailId());
			System.out.println("Emp DOB            :"+employeeInfoBean.getDateOfBirth());
			System.out.println("Emp Password       :"+employeeInfoBean.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}//End of main()

}//End of class
