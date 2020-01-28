package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshallingTest {

	public static void main(String[] args) {
		
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		employeeInfoBean.setEmpId(101101);
		employeeInfoBean.setName("sonu kumar");
		employeeInfoBean.setMobileNum(7845124578L);
		employeeInfoBean.setOfficalMailId("sonuku@gmail.com");
		employeeInfoBean.setDateOfBirth(new Date());
		employeeInfoBean.setDateOfJoining(new Date());
		employeeInfoBean.setDesignation("SSD");
		employeeInfoBean.setBloodGroup("O+");
		employeeInfoBean.setEmployeeSalary((double) 55000);
		employeeInfoBean.setDepartmentId(45);
		employeeInfoBean.setManagerId(1002);
		employeeInfoBean.setPassword("qweertyu");
		
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfoBean.class);
			Marshaller marshaller =context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//for Formated xml
			marshaller.marshal(employeeInfoBean,System.out);
			marshaller.marshal(employeeInfoBean,new File("employeeInfo.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}//End of main()

}//End of class
