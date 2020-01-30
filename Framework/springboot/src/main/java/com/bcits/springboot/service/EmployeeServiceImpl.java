package com.bcits.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springboot.beans.EmployeeInfoBean;
import com.bcits.springboot.dao.EmlployeeDAO;
import com.bcits.springboot.exception.EmployeeException;

 

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmlployeeDAO dao;
	
	@Override
	public boolean deleteEmployee(int empId) {
		if(empId<1) {
			 throw new EmployeeException("Invlid Employee Id");
		}
		return dao.deleteEmployee(empId);
	}
	

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean,String confpassword) {
		if(employeeInfoBean.getPassword().equals(confpassword)) {
			return dao.addEmployee(employeeInfoBean);
		}
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.updateEmployee(employeeInfoBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if(empId<1) {
			 throw new EmployeeException("Invlid Employee Id");
		}
		
		EmployeeInfoBean employeeInfoBean = dao.getEmployee(empId);		 
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
