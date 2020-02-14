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
	public int countConsumer(String region) {
		if(validation.isRegionValidation(region)) {
			return 0;
		}
		return dao.countConsumer(region);
	}

	@Override
	public boolean currentBillGeneration(CurrentBillBean currentBill,String region) {
		if(currentBill != null &&(currentBill.getCurrentReading()>= currentBill.getPreviousReading())) {
			
			return dao.currentBillGeneration(currentBill,region);
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
	public boolean removeEmployee(int employeeId) {
		return dao.removeEmployee(employeeId);
	}

	@Override
	public boolean sendRespond(String meterNumber, String response,String query) {
		return dao.sendRespond(meterNumber, response, query);
	}

	@Override
	public boolean sendMail(String meterNumber,String email) {
		return dao.sendMail(meterNumber, email);
	}

	@Override
	public List<Object[]> getAllPaidAmount(String region) {
		return dao.getAllNotPaidAmount(region);
	}

	@Override
	public List<Object[]> getAllNotPaidAmount(String region) {
		return dao.getAllNotPaidAmount(region);
	}


}//end of class
