package com.bcits.jpawithhibernateapp2.test;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernateapp2.onetoone.EmployeeSecondaryInfo;
import com.bctis.jpawithhibernateapp2.manytomany.ProjectInfo;

public class TestManyToMany {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transation = null;
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		
//		ProjectInfo pinf1 = new ProjectInfo();
//		pinf1.setPid(22);
//		pinf1.setProjName("R-commercr");
//		pinf1.setTechnology("java");
//		pinf1.setStartDate(Date.valueOf("2020-01-01") );
//		pinf1.setEndDAte(Date.valueOf("2022-01-01"));
//		pinf1.setLocation("bangalore");
//		
//		ProjectInfo pinf2 = new ProjectInfo();
//		pinf2.setPid(33);
//		pinf2.setProjName("X-commercr");
//		pinf2.setTechnology("java");
//		pinf2.setStartDate(Date.valueOf("2020-01-01") );
//		pinf2.setEndDAte(Date.valueOf("2022-01-01"));
//		pinf2.setLocation("bangalore");
//		
//		ArrayList<ProjectInfo> arrProjectInfos = new ArrayList<ProjectInfo>();
//		arrProjectInfos.add(pinf1);
//		arrProjectInfos.add(pinf2);
//		 
		
		test.setEmpId(130);
		test.setEmployeeName("Sarthak Sahoo");
		test.setEmployeeofficalMailId("sarthasahoo02@gmail.com");
		test.setEmployeeMbNo(9064511122l);
		test.setDateOfBirth(Date.valueOf("1996-12-11"));
		test.setDateOfjoining(Date.valueOf("2019-12-10"));
		test.setEmployeeDesignation("Tester");
		test.setEmployeeBloodGroup("B+");
		test.setEmployeeSalary(25000);
		test.setEmployeeDeptId(40);
		test.setEmployeeManagerId(1004);
		
		EmployeePrimaryInfo test1 = new EmployeePrimaryInfo();
		test1.setEmpId(131);
		test1.setEmployeeName("Akankhya Sahoo");
		test1.setEmployeeofficalMailId("sahooakankhya@gmail.com");
		test1.setEmployeeMbNo(9040228899l);
		test1.setDateOfBirth(Date.valueOf("1995-12-11"));
		test1.setDateOfjoining(Date.valueOf("2018-11-10"));
		test1.setEmployeeDesignation("Developer");
		test1.setEmployeeBloodGroup("O+");
		test1.setEmployeeSalary(52000);
		test1.setEmployeeDeptId(20);
		test1.setEmployeeManagerId(1004);
		
		ArrayList<EmployeePrimaryInfo> arrayList =new ArrayList<EmployeePrimaryInfo>();
		arrayList.add(test);
		arrayList.add(test1);
		
		ProjectInfo pinf = new ProjectInfo();
		pinf.setPid(11);
		pinf.setProjName("E-commercr");
		pinf.setTechnology("java");
		pinf.setStartDate(Date.valueOf("2020-01-01") );
		pinf.setEndDate(Date.valueOf("2022-01-01"));
		pinf.setLocation("bangalore");
		pinf.setPrimaryInfo(arrayList);
		 

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transation = manager.getTransaction();
			transation.begin();
			 manager.persist(pinf);
			System.out.println("Record Retrive");
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transation.rollback();
		} finally {
			manager.close();

		} // End of Finally

	}//End Of main

}//End Of Class
