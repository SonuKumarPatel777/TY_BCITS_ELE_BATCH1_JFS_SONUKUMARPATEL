package com.bcits.springcoreannotations;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();
		
		EmployeeBean employeeBean1 =context.getBean(EmployeeBean.class);
		System.out.print("Enter employee-1 name : ");
		employeeBean1.setName(sc.nextLine());
		System.out.print("Enter employee-1 Age : ");
		employeeBean1.setAge(sc.nextInt());
		sc.nextLine();
		
		EmployeeBean employeeBean2 =context.getBean(EmployeeBean.class);
		System.out.print("Enter employee-2 name : ");
		employeeBean2.setName(sc.nextLine());
		System.out.print("Enter employee-2 Age : ");
		employeeBean2.setAge(sc.nextInt());
		sc.nextLine();
		sc.nextLine();
		
		System.out.println("Employee name :"+employeeBean1.getName());
		System.out.println("Employee age :"+employeeBean1.getAge());
		System.out.println("----------------------------------------------");
		System.out.println("Employee name :"+employeeBean2.getName());
		System.out.println("Employee age :"+employeeBean2.getAge());

	}//End of main()

}//End of Class
