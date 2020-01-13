package com.bcits.jpawithhibernateapp2.test;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernateapp2.onetoone.EmployeeBankInfo;
import com.bcits.jpawithhibernateapp2.onetoone.EmployeeSecondaryInfo;

public class Test2OneToOne {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transation = null;
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		test.setEmpId(125);
		test.setEmployeeName("Nitish  Kumar");
		test.setEmployeeofficalMailId("nitishkumar12@gmail.com");
		test.setEmployeeMbNo(9064856789l);
		test.setDateOfBirth(Date.valueOf("1996-11-11"));
		test.setDateOfjoining(Date.valueOf("2019-12-12"));
		test.setEmployeeDesignation("Tester");
		test.setEmployeeBloodGroup("B+");
		test.setEmployeeSalary(54000);
		test.setEmployeeDeptId(20);
		test.setEmployeeManagerId(1002);
		
		EmployeeBankInfo bankinfo =  new EmployeeBankInfo();
		bankinfo.setAccountno(45781269784l);
		bankinfo.setBankName("HDFC");
		bankinfo.setBranchname("Bansangudi");
		bankinfo.setIfscCode("HDFC12000789");
		bankinfo.setPrimaryInfo(test);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transation = manager.getTransaction();
			transation.begin();
			manager.persist(bankinfo);
			System.out.println("Recod Save");
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transation.rollback();
		} finally {
			manager.close();

		}//End of Finally
		
		

	}//End Of Main

}//End Of Class
