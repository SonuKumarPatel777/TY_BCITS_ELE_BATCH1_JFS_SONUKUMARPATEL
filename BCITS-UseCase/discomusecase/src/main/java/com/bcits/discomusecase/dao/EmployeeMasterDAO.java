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
	
	public int countConsumer(String region);
	
	public boolean currentBillGeneration(CurrentBillBean currentBill,String region);
	
	public List<HelpConsumerBean> getAllComplaints(String region);
	
	public boolean removeEmployee(int employeeId);

	public boolean sendRespond(String meterNumber,String response,String query);
	
	public boolean sendMail(String meterNumber, String email);
	
	public List<Object[]> getAllPaidAmount(String region);
	
	public List<Object[]> getAllNotPaidAmount(String region);
	
}//end of interface
