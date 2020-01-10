package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeeInfo;

public class FindEmployee {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("test");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfo info = manager.find(EmployeeInfo.class, 101);
		
	
		System.out.println(" Employee_ID---------"+info.getEmployeeId());
		System.out.println(" Employee_name-------"+info.getEmployeeName());
		System.out.println(" Employee_MobileNO---"+info.getEmployeeMbNo());
		System.out.println(" Employee_offical_mailId-------"+info.
				           getEmployeeofficalMailId());
		System.out.println(" Employee_Date_Of_Birth-------"+info.getDateOfBirth());
		System.out.println(" Employee_Date_Of_joining-------"+info.getDateOfjoining());
		System.out.println(" Employee_Designation-------"+info.getEmployeeDesignation());
		System.out.println(" Employee_Blood_Group-------"+info.getEmployeeBloodGroup());
		System.out.println(" Employee_Salary-------"+info.getEmployeeSalary());
		System.out.println(" Employee_DeptId-------"+info.getEmployeeDeptId());
		System.out.println(" Employee_ManagerId-------"+info.getEmployeeManagerId());
		System.out.println("<========================================================>");
		
		
		
	}//End of main

}//End of the Class
