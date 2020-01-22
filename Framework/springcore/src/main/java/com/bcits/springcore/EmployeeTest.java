package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;
import com.bcits.springcore.beans.MessageBeans;

public class EmployeeTest {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
	
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
	 
		/*
		 * EmployeeBean employeeBean = (EmployeeBean) context.getBean("employee");
		 * System.out.println("Name " + employeeBean.getName());
		 * System.out.println("Age  " + employeeBean.getAge());
		 * 
		 * EmployeeBean employeeBean2 = (EmployeeBean) context.getBean("employee2");
		 * System.out.println("Name " + employeeBean2.getName());
		 * System.out.println("Age  " + employeeBean2.getAge());
		 */
		EmployeeBean employeeBean = (EmployeeBean) context.getBean("employee");
        System.out.print("Enter the Employee name= ");
		employeeBean.setName(scn.nextLine());
		System.out.print("Enter the Employee age= ");
		employeeBean.setAge(scn.nextInt());
		scn.nextLine();
		
		EmployeeBean employeeBean2 = (EmployeeBean) context.getBean("employee");
        System.out.print("Enter the Employee name= ");
		employeeBean2.setName(scn.nextLine());
		System.out.print("Enter the Employee age= ");
		employeeBean2.setAge(scn.nextInt());
		
		System.out.println("Name " + employeeBean.getName());
	    System.out.println("Age  " + employeeBean.getAge());
	    System.out.println("Name " + employeeBean2.getName());
	    System.out.println("Age  " + employeeBean2.getAge());
		
        
	}// End Of main()

}// End of Class
