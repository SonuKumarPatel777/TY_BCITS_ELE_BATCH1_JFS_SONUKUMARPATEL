package com.bcits.discomusecase.dao;

 
import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
 

public interface EmployeeMasterDAO {
	
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean);
	
	public EmployeeMasterBean authentication(int employeeId, String password);
	
	public List<ConsumersMasterBean> getAllConsumer(String region );
	
	public boolean addCurrentBillToMonthlyConsumption(CurrentBillBean currentBill);

}//end of interface
