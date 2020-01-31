package com.bcits.discomusecase.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.EmployeeMasterBean;

@Repository
public class EmployeeMasterDAOHibernateImp implements EmployeeMasterDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean) {
		return false;
	}

	@Override
	public EmployeeMasterBean authentication(int employeeId, String designation) {
		EntityManager manager = emf.createEntityManager();
		EmployeeMasterBean empMasterInfo = manager.find(EmployeeMasterBean.class, employeeId);
		if(empMasterInfo != null && empMasterInfo.getDesignation().equals(designation)) {
			return empMasterInfo;
		}
		return null;
	}

}//end of class
