package com.bcits.springsecuritymvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

 
import com.bcits.springsecuritymvc.beans.EmpInfoBean;

@Repository
public class EmpDAOImpl implements EmpDAO{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean register(EmpInfoBean empInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isRegister = false;
		try {
			transaction.begin();
			manager.persist(empInfoBean);
			transaction.commit();
			isRegister = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return isRegister;
	}

	@Override
	public EmpInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EmpInfoBean empInfoBean = manager.find(EmpInfoBean.class, empId);
		manager.close();
		return empInfoBean;
	}

	@Override
	public List<EmpInfoBean> getAllEmployee() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from EmpInfoBean");
		List<EmpInfoBean> info = query.getResultList();
		manager.close();
		return info;
		 
	}

}//end of class
