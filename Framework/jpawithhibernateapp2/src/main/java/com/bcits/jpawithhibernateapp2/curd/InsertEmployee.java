package com.bcits.jpawithhibernateapp2.curd;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeeInfo;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transation = null;
		EmployeeInfo test = new EmployeeInfo();
		test.setEmployeeId(121);
		test.setEmployeeName("Sunil");
		test.setEmployeeofficalMailId("sunil141@gmail.com");
		test.setEmployeeMbNo(9064567342l);
		test.setDateOfBirth(Date.valueOf("1995-11-11"));
		test.setDateOfjoining(Date.valueOf("2018-11-10"));
		test.setEmployeeDesignation("HR");
		test.setEmployeeBloodGroup("O+");
		test.setEmployeeSalary(54000);
		test.setEmployeeDeptId(40);
		test.setEmployeeManagerId(1002);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transation = manager.getTransaction();
			transation.begin();
			manager.persist(test);
			System.out.println("Record save");
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transation.rollback();
		} finally {
			manager.close();

		}//End of Finally

	}//End of main
	
}//End of Class
