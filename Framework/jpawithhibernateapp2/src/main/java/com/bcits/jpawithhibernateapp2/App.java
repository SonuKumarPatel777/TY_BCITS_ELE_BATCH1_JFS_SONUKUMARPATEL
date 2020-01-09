package com.bcits.jpawithhibernateapp2;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.Test;

public class App 
{
    public static void main( String[] args )
    {
    	Test test = new Test();
    	test.setEmployee_id(115);
    	test.setEmployee_name("Deberaja ");
    	test.setEmployeeoffical_mailId("deberaja14@gmail.com");
    	test.setEmployee_Mb_No(9064567342l);
    	test.setDate_Of_Birth(Date.valueOf("1994-11-15"));
    	test.setDate_Of_joining(Date.valueOf("2019-11-15"));
    	test.setEmployee_Designation("HR");
    	test.setEmployee_Blood_Group("B+");
    	test.setEmployeeSalary(52000);
    	test.setEmployee_DeptId(40);
    	test.setEmployee_ManagerId(1002);
    	
    	
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
