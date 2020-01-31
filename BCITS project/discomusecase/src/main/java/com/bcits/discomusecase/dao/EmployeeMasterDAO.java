package com.bcits.discomusecase.dao;

 
import com.bcits.discomusecase.beans.EmployeeMasterBean;

public interface EmployeeMasterDAO {
	
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean);
	public EmployeeMasterBean authentication(int empId , String designation);

}//end of interface
