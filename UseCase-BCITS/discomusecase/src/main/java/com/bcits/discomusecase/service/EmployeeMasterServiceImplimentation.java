package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.HelpConsumerBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.dao.EmployeeMasterDAO;
import com.bcits.discomusecase.validation.FormValidation;

@Service
public class EmployeeMasterServiceImplimentation implements EmployeeMasterService{
	
	FormValidation validation = new FormValidation();
	
	@Autowired
	private EmployeeMasterDAO dao;

	@Override
	public EmployeeMasterBean authentication(int employeeId, String password) {
		if(employeeId<1 && password.isEmpty()) {
			return null;
		}
		return dao.authentication(employeeId, password);
	}

	@Override
	public List<ConsumersMasterBean> getAllConsumer(String region) {
		if(validation.isRegionValidation(region)) {
			return null;
		}
		return dao.getAllConsumer(region);
	}

	@Override
	public boolean currentBillGeneration(CurrentBillBean currentBill) {
		if(currentBill != null &&(currentBill.getCurrentReading()>= currentBill.getPreviousReading())) {
			return dao.currentBillGeneration(currentBill);
			
		}
		return false;     
	}

	@Override
	public List<HelpConsumerBean> getAllComplaints(String region) {
		if(validation.isRegionValidation(region)) {
			return null;
		}
		return dao.getAllComplaints(region);
	}

	@Override
	public String getSingleComplaint(String meterNumber, Date queryDate) {
		return dao.getSingleComplaint(meterNumber, queryDate);
	}

	@Override
	public boolean removeEmployee(int employeeId) {
		return dao.removeEmployee(employeeId);
	}

	@Override
	public boolean sendRespond(String meterNumber, String response, Date date) {
		return dao.sendRespond(meterNumber, response, date);
	}

	@Override
	public boolean sendMail(String meterNumber) {
		return dao.sendMail(meterNumber);
	}



}//end of class
