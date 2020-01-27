package com.bcits.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.customexceptions.EmployeeException;
import com.bcits.springmvc.dao.EmlployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmlployeeDAO dao;
	
	@Override
	public boolean deleteEmployee(int empId) {
		if(empId<1) {
			return false;
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
			throw new EmployeeException("Invlid Employee ID !!");
		}
		
		EmployeeInfoBean employeeInfoBean = dao.getEmployee(empId);
		if(employeeInfoBean == null) {
			throw new EmployeeException(" Employee ID  Not Found!!");
		}
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
