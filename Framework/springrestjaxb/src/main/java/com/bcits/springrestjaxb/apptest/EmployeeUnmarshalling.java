package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnmarshalling {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfoBean.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			EmployeeInfoBean employeeInfoBean =(EmployeeInfoBean) unmarshaller.unmarshal(new File("employeeInfo2.xml"));
			System.out.println("Emp ID :"+employeeInfoBean.getEmpId());
			System.out.println("Emp name :"+employeeInfoBean.getName());
			System.out.println("Emp MN :"+employeeInfoBean.getMobileNum());
			System.out.println("Emp OfficalMailId :"+employeeInfoBean.getOfficalMailId());
			System.out.println("Emp DOB :"+employeeInfoBean.getDateOfBirth());
			
			 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
       
	}//End of main()

}//End of Class
