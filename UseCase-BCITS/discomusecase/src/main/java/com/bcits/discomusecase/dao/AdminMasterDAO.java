package com.bcits.discomusecase.dao;

import java.util.List;

import com.bcits.discomusecase.beans.AdminMasterBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.TarrifMasterBean;
 
public interface AdminMasterDAO {
	 
	public AdminMasterBean authentication(String userId, String password);
	
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean);
	
	public List<TarrifMasterBean> getTarrife();
	
	public int getMulitplayerAmount(String typeOfConsumer, int unitsRange);
	
	public boolean tarrifChanged(String typeOfConsumer,int unitsRange,int mulitplayerAmount);
	
    public List<EmployeeMasterBean> getAllEmployee();
	 
}//End of interface
