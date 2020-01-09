package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

public class App 
{
    public static void main( String[] args )
    {
    	Test test =new Test();
    	test.setMid(1);
    	test.setMovieName("kgf");
    	test.setMovieRating("best");
    	
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    	EntityManager manager= entityManagerFactory.createEntityManager();
    	EntityTransaction transation= manager.getTransaction();
    	transation.begin();
    	manager.persist(test);
    	System.out.println("Record save");
    	transation.commit();
    	manager.close();
    }
}
