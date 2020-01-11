package com.bcits.jpawithhibernateapp2.curd;

 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class FindingNameEmployee {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select name from EmployeeInfo";
		Query query = manager.createQuery(jpql);
		List<String> list = query.getResultList();
		for (String employeeInfo : list) {
			 
			System.out.println(employeeInfo);
		}
		manager.close();

	}// End Of Main

}//End of Class
