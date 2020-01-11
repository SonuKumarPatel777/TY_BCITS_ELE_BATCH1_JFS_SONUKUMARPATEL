package com.bcits.jpawithhibernateapp2.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteEmployee {
	public static void main(String[] args) {
		 EntityManager manager =null;
		 EntityTransaction transaction =null;
		 try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			 manager = entityManagerFactory.createEntityManager();
			 transaction = manager.getTransaction();
			 transaction.begin();
			 String jpql=" delete from EmployeeInfo where empId=121";
			 Query query=manager.createQuery(jpql);
			 int count =query.executeUpdate();
			 System.out.println(" No of row effected"+count);
			 transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		 finally {
			manager.close();
		}
				 
	}//End of main

}//End of Class
