package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("importAllConfigs.xml");
		EmployeeBean employeeBean = context.getBean("employee", EmployeeBean.class);

		System.out.println("Employee name   :" + employeeBean.getName());
		System.out.println("Employee age    :" + employeeBean.getAge());
		System.out.println("Department ID   :" + employeeBean.getDepartmentBean().getDeptId());
		System.out.println("Department name :" + employeeBean.getDepartmentBean().getDeptName());

	}// End of main()

}// End of Class
