package com.bcits.springsecuritymvc.service;

import java.util.List;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;

public interface EmpServic {
	
	public boolean register(EmpInfoBean empInfoBean);
	public EmpInfoBean getEmployee(int empId);
	public List<EmpInfoBean> getAllEmployee();

}//end of service
