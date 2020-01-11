package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class UpdateEmployee {
	public static void main(String[] args) {
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory  entityManagerFactor= Persistence.createEntityManagerFactory("test");
			manager= entityManagerFactor.createEntityManager();
			 transaction= manager.getTransaction();
			 transaction.begin();
			 EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class, 101);
			 info.setEmployeeSalary(80000);
			 transaction.commit();
			 System.out.println("Record Update");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			manager.close();
		}
		
	}//End of main

}//End of Class
