package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import javax.xml.bind.ValidationEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.BillHistoryBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.HelpConsumerBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.dao.ConsumersMasterDAO;
import com.bcits.discomusecase.validation.FormValidation;

@Service
public class ConsumerMasterServiceImplimentaion implements ConsumerMasterService{
	
	FormValidation validation = new FormValidation();
	@Autowired
	private ConsumersMasterDAO dao;

	@Override
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean, String cnfPassword) {
		if(!consumersMasterBean.getPassword().equals(cnfPassword)) {
			return false;
		}
		else if(validation.consumerValidation(consumersMasterBean)){
			return false;
		}
		return  dao.registerConsumer(consumersMasterBean);
	}//end of registerConsumer()
	
	
	@Override
	public ConsumersMasterBean authentication(String meterNumber, String password) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
		return dao.authentication(meterNumber, password);
	}//end of authentication()
	
	@Override
	public List<MonthlyConsumptionBean> getMonthlyConsumption(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
	    return dao.getMonthlyConsumption(meterNumber);
		
	}//end of getMonthlyConsumption()


	@Override
	public CurrentBillBean getCurrentBill(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
		return dao.getCurrentBill(meterNumber);
	}//end of getCurrentBill(


	@Override
	public List<BillHistoryBean> getBillHistory(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
		return dao.getBillHistory(meterNumber);
	}//end of getBillHistory()


	@Override
	public  Double getBillAmount(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
		return dao.getBillAmount(meterNumber);
	}//end of getBillAmount()


	@Override
	public boolean successfullBillPayment(String meterNumber, Date date, Double amount) {
		if(validation.meterNumberValidation(meterNumber)) {
			return false;
		}
		 return dao.successfullBillPayment(meterNumber, date, amount);
	}//end of successfullBillPayment()


	@Override
	public ConsumersMasterBean getConsumer(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
		return dao.getConsumer(meterNumber);
	}//end of getConsumer()


	@Override
	public int getPreviousReading(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return 0;
		}
		return dao.getPreviousReading(meterNumber);
	}//end of getPreviousReading()


	@Override
	public boolean setQuerie(ConsumersMasterBean consumersMasterBean, String querie) {
		return dao.setQuerie(consumersMasterBean, querie);
	}//end of setQuerie()


	@Override
	public boolean authenticationForSetPassword(ConsumersMasterBean consumersMasterBean) {
		return dao.authenticationForSetPassword(consumersMasterBean);
	}//end of authenticationForSetPassword()


	@Override
	public boolean reSetPassword(ConsumersMasterBean consumersMasterBean, String confPassword) {
		if(!consumersMasterBean.getPassword().equals(confPassword)) {
			return false;
		}
		return dao.reSetPassword(consumersMasterBean);
	}//end of reSetPassword()


	@Override
	public List<HelpConsumerBean> getAllResponse(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return null;
		}
		return dao.getAllResponse(meterNumber);
	}//end of getAllResponse()


	@Override
	public boolean removeConsumer(String meterNumber) {
		if(validation.meterNumberValidation(meterNumber)) {
			return false;
		}
		return dao.removeConsumer(meterNumber);
	}//end of removeConsumer()


	@Override
	public String getEmail(String meterNumber) {
		return dao.getEmail(meterNumber);
	}//end of getEmail()


	@Override
	public boolean clearPandingBill(String meterNumber, Double billAmount) {
		return dao.clearPandingBill(meterNumber, billAmount);
	}//end of clearPandingBill()


}//end of class
