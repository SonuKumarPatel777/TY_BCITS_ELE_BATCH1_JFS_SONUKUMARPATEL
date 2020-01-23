package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig2;

public class EmployeeTest2 {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig2.class);
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
		
		System.out.println("Employee name :"+employeeBean.getName());
		System.out.println("Employee age :"+employeeBean.getAge());
		System.out.println("Dept ID :" +employeeBean.getDepartmentBean().getDepId());
		System.out.println("Dept name :" +employeeBean.getDepartmentBean().getDeptName());
	
	}//End of main()

}//End of class
