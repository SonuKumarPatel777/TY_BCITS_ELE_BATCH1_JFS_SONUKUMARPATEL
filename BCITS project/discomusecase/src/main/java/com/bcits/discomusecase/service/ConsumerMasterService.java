package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.BillHistoryBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;

public interface ConsumerMasterService {
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean , String cnfPassword);
    
	public ConsumersMasterBean authentication(String meterNumber, String password);
	
	public List<MonthlyConsumptionBean> getMonthlyConsumption(String meterNumber);
	
	public CurrentBillBean getCurrentBill(String meterNumber);
	
	public List<BillHistoryBean> getBillHistory(String meterNumber);
	
	public CurrentBillBean getBillAmount(String meterNumber);
	
	public boolean successfullBillPayment(String meterNumber,Date date,Double amount);
	
    public ConsumersMasterBean getConsumer(String meterNumber);
	
	public int getPreviousReading(String meterNumber);
	
}//end of interface
