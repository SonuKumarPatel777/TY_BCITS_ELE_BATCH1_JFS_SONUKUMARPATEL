package com.bcits.jpawithhibernateapp2.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountEmployee {

	public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
    EntityManager manager= factory.createEntityManager();
    String jpql = " select count(name)from EmployeeInfo ";
	Query query = manager.createQuery(jpql);
	Object count=query.getSingleResult();
	System.out.println("No of count=="+count); 
	manager.close();
	}

}
