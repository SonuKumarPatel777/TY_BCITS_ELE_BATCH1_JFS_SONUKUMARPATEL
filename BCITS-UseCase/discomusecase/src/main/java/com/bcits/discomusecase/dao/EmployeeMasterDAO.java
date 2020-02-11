package com.bcits.discomusecase.dao;

 
import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.HelpConsumerBean;
 

public interface EmployeeMasterDAO {
	
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean);
	
	public EmployeeMasterBean authentication(int employeeId, String password);
	
	public List<ConsumersMasterBean> getAllConsumer(String region );
	
	public boolean currentBillGeneration(CurrentBillBean currentBill);
	
	public List<HelpConsumerBean> getAllComplaints(String region);
	
	public String getSingleComplaint(String meterNumber,Date queryDate);
	
	public boolean removeEmployee(int employeeId);

	public boolean sendRespond(String meterNumber,String response ,Date date);
	
	public boolean sendMail(String meterNumber);
}//end of interface
