package com.bcits.jpawithhibernateapp2.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class ReadEmployee {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		String jpql = " from EmployeeInfo ";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> list = query.getResultList();
		for (EmployeePrimaryInfo employeeInfo : list) {
			System.out.println(" Employee_ID---------" + employeeInfo.getEmployeeId());
			System.out.println(" Employee_name-------" + employeeInfo.getEmployeeName());
			System.out.println(" Employee_MobileNO---" + employeeInfo.getEmployeeMbNo());
			System.out.println(" Employee_offical_mailId-------" + employeeInfo.getEmployeeofficalMailId());
			System.out.println(" Employee_Date_Of_Birth-------" + employeeInfo.getDateOfBirth());
			System.out.println(" Employee_Date_Of_joining-------" + employeeInfo.getDateOfjoining());
			System.out.println(" Employee_Designation-------" + employeeInfo.getEmployeeDesignation());
			System.out.println(" Employee_Blood_Group-------" + employeeInfo.getEmployeeBloodGroup());
			System.out.println(" Employee_Salary-------" + employeeInfo.getEmployeeSalary());
			System.out.println(" Employee_DeptId-------" + employeeInfo.getEmployeeDeptId());
			System.out.println(" Employee_ManagerId-------" + employeeInfo.getEmployeeManagerId());
			System.out.println("<========================================================>");
		}

	}// End Of Main

}// End Of Class
