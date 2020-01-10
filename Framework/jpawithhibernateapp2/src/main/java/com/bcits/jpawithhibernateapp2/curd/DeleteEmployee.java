package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeeInfo;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeeInfo info = manager.find(EmployeeInfo.class, 120);
			manager.remove(info);
			transaction.commit();
			System.out.println("Record  Delete");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}

}
