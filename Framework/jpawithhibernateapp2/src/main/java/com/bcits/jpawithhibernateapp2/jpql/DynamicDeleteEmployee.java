package com.bcits.jpawithhibernateapp2.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicDeleteEmployee {

	public static void main(String[] args) {
		
			EntityManager manager =null;
			EntityTransaction transaction =null;
			try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction= manager.getTransaction();
			transaction.begin();
			String jpql=" delete from EmployeeInfo where empId=:id";
			Query query =manager.createQuery(jpql);
			query.setParameter("id",115);
			int count = query.executeUpdate();
			
			System.out.println("No of row affected" + count);
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
