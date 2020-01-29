package com.bcits.springrest.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.springrest.beans.EmployeeInfoBean;

 

@Repository
public class EmployeeDAOHibernateImp implements EmlployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

//	@PersistenceContext
//	private EntityManager manager;

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean ) {
		// Store the Data into DB
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Boolean isAdd = false;
		try {
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			isAdd = true;
			return isAdd;
		} catch (Exception e) {
			e.printStackTrace();
			return isAdd;
		}

	}// End of addEmployee()

	@Override
	public boolean deleteEmployee(int empId) {

		EntityManager manager = entityManagerFactory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		EntityTransaction transaction = manager.getTransaction();
		Boolean isDelete = false;
		if (employeeInfoBean != null) {
			transaction.begin();
			manager.remove(employeeInfoBean);
			transaction.commit();
			isDelete = true;
		}
		manager.close();
		return isDelete;
	}// End of deleteEmployee()

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Integer empId= employeeInfoBean.getEmpId();
		String name = employeeInfoBean.getName();
		Long mobileNum = employeeInfoBean.getMobileNum();
		String officalMailId = employeeInfoBean.getOfficalMailId();
		Date dateOfBirth = employeeInfoBean.getDateOfBirth();
		Date dateOfjoining = employeeInfoBean.getDateOfjoining();
		String designation = employeeInfoBean.getDesignation();
		String bloodGroup = employeeInfoBean.getBloodGroup();
		Double employeeSalary = employeeInfoBean.getEmployeeSalary();
		Integer departmentId = employeeInfoBean.getDepartmentId();
		Integer managerId = employeeInfoBean.getManagerId();
		String password = employeeInfoBean.getPassword();

		EmployeeInfoBean employeeInfo = manager.find(EmployeeInfoBean.class, empId);
		Boolean isUpdate = false;
		if (employeeInfo != null) {
			transaction.begin();
			if(name != null && !name.isEmpty()) {
				employeeInfo.setName(name);
			}
			if(mobileNum !=null) {
				employeeInfo.setMobileNum(mobileNum);
			}
			if(officalMailId != null ) {
				employeeInfo.setOfficalMailId(officalMailId);
			}
			if(dateOfBirth != null) {
				employeeInfo.setDateOfBirth(dateOfBirth);
			}
			if(dateOfjoining != null) {
				employeeInfo.setDateOfjoining(dateOfjoining);
			}
			if(designation !=null && !designation.isEmpty()) {
				employeeInfo.setDesignation(designation);
			}
			if(bloodGroup != null && !bloodGroup.isEmpty()) {
				employeeInfo.setBloodGroup(bloodGroup);
			}
			if(employeeSalary != null) {
				employeeInfo.setEmployeeSalary(employeeSalary);
			}
			if(departmentId != null) {
				employeeInfo.setDepartmentId(departmentId);
			}
			if(managerId != null) {
				employeeInfo.setManagerId(managerId);
			}
			if(password != null && !password.isEmpty()) {
				employeeInfo.setPassword(password); 
			}
			
			
			transaction.commit();
			isUpdate = true;
		}
		manager.close();
		return isUpdate;
	}// End of updateEmployee()

	@Override
	public EmployeeInfoBean getEmployee(int empId) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		return employeeInfoBean;
	}// End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {

		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery("from EmployeeInfoBean");
		List<EmployeeInfoBean> info = query.getResultList();
		return info;

	}// End of getAllEmployee()s

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if (employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		} else {
			return null;
		}

	}// End of authenticate()

}// End of class
