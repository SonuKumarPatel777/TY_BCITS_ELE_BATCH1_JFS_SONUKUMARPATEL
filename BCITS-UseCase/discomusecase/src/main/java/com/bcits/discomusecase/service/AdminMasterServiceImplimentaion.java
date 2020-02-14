package com.bcits.discomusecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.AdminMasterBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.TarrifMasterBean;
import com.bcits.discomusecase.dao.AdminMasterDAO;
import com.bcits.discomusecase.validation.FormValidation;

@Service
public class AdminMasterServiceImplimentaion implements AdminMasterService{
	
	@Autowired
	 private AdminMasterDAO dao;
	
	FormValidation validation = new FormValidation();

	@Override
	public AdminMasterBean authentication(String userId, String password) {
		return dao.authentication(userId, password);
	}//end of authentication()

	@Override
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean, String cnfPassword) {
		if(!employeeMasterBean.getPassword().equals(cnfPassword)) {
			return false;
		}
		else if(!validation.employeeValidation(employeeMasterBean)) {
			return false;
		}
		return dao.registerEmployee(employeeMasterBean);
	}//end of registerEmployee()

	@Override
	public List<TarrifMasterBean> getTarrife() {
		return dao.getTarrife();
	}//end of getTarrife() 

	@Override
	public int getMulitplayerAmount(String typeOfConsumer, int unitsRange) {
		return dao.getMulitplayerAmount(typeOfConsumer, unitsRange);
	}//end of getMulitplayerAmount()

	@Override
	public boolean tarrifChanged(String typeOfConsumer,int unitsRange,int mulitplayerAmount) {
		return dao.tarrifChanged(typeOfConsumer, unitsRange, mulitplayerAmount);
	}

	@Override
	public List<EmployeeMasterBean> getAllEmployee() {
		return dao.getAllEmployee();
	}
	
}//end of class
