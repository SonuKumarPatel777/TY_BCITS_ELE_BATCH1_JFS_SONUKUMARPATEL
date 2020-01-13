package com.bcits.jpawithhibernateapp2.test;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernateapp2.manytoone.EmolyeeAdressPK;
import com.bcits.jpawithhibernateapp2.manytoone.EmployeeAdressInfo;
import com.bcits.jpawithhibernateapp2.onetoone.EmployeeSecondaryInfo;

public class TestManyToOne {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transation = null;
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		test.setEmpId(126);
		test.setEmployeeName("Rahul  Kumar");
		test.setEmployeeofficalMailId("Rahulkumar12@gmail.com");
		test.setEmployeeMbNo(906784526l);
		test.setDateOfBirth(Date.valueOf("1989-12-10"));
		test.setDateOfjoining(Date.valueOf("2003-12-12"));
		test.setEmployeeDesignation("Tester");
		test.setEmployeeBloodGroup("B+");
		test.setEmployeeSalary(000);
		test.setEmployeeManagerId(20);
		
		
		EmolyeeAdressPK adressPK = new EmolyeeAdressPK();
		adressPK.setEmpId(126);
		adressPK.setAddress_type("current");
		
		EmployeeAdressInfo employeeAdressInfo =new EmployeeAdressInfo();
		employeeAdressInfo.setAddressPK(adressPK);
		employeeAdressInfo.setHouseno(58);
		employeeAdressInfo.setAddress1("JP Nagar");
		employeeAdressInfo.setAddress2("BBC");
		employeeAdressInfo.setLandmark("L3");
		employeeAdressInfo.setCity("Bangolour");
		employeeAdressInfo.setPincode(7752048);
		employeeAdressInfo.setPrimaryInfo1(test);
		 
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transation = manager.getTransaction();
			transation.begin();
//			EmployeePrimaryInfo pr=manager.find(EmployeePrimaryInfo.class, 126);
//			employeeAdressInfo.setPrimaryInfo(pr);
//			manager.persist(employeeAdressInfo);

//			System.out.println("Record save");
			EmployeePrimaryInfo pr=manager.find(EmployeePrimaryInfo.class, 102); 
			System.out.println(pr.getAdressInfos().get(0).getAddress1());
			
//			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transation.rollback();
		} finally {
			manager.close();

		} // End of Finally

	}//End of main

}//End of Class
