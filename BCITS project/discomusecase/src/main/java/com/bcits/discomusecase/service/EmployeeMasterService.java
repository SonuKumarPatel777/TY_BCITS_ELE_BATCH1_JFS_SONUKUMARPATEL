package com.bcits.discomusecase.service;

import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;

public interface EmployeeMasterService {
	public EmployeeMasterBean authentication(int empId , String  password);
	
	public List<ConsumersMasterBean> getAllConsumer(String region );
	
	public boolean addCurrentBillToMonthlyConsumption(CurrentBillBean currentBill);
}//end of service
