package com.bcits.springsecuritymvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.dao.EmpDAO;
@Service
public class EmpServiceHibranateeImpl implements EmpServic{
	
	@Autowired
	private EmpDAO dao;

	@Override
	public boolean register(EmpInfoBean empInfoBean) {
		return dao.register(empInfoBean);
	}

	@Override
	public EmpInfoBean getEmployee(int empId) {
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmpInfoBean> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
