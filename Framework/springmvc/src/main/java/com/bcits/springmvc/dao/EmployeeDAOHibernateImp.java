package com.bcits.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springmvc.beans.EmployeeInfoBean;

@Repository
public class EmployeeDAOHibernateImp implements EmlployeeDAO{
	
	@PersistenceUnit
	private  EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		// Store the Data into DB
				EntityManager manager = entityManagerFactory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				Boolean isAdd = false;
				try {
					transaction.begin();
					manager.persist(employeeInfoBean);
					transaction.commit();
					isAdd = true;
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
		
		
	}

	@Override
	public boolean deleteEmployee(int empId) {
		 
		EntityManager manager = entityManagerFactory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		EntityTransaction transaction = manager.getTransaction();
		Boolean isDelete = false;
		if(employeeInfoBean != null){
			transaction.begin();
			manager.remove(employeeInfoBean);
			transaction.commit();
			isDelete = true; 
		} 
		manager.close();
		return isDelete;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		 
		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		return employeeInfoBean;
	}

	@Override
	public List<EmployeeInfoBean> getAll(EmployeeInfoBean employeeInfoBean) {
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery("from EmployeePrimaryInfo"); 
		List<EmployeeInfoBean> info = query.getResultList();
		return info;
		 
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
          
		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if(employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		}else {
			return null;
		}
		
	}//End of authenticate()

}//End of class
