package com.bcits.discomusecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.dao.EmployeeMasterDAO;

@Service
public class EmployeeMasterServiceImplimentation implements EmployeeMasterService{
	
	@Autowired
	private EmployeeMasterDAO dao;

	@Override
	public EmployeeMasterBean authentication(int employeeId, String designation) {
		if(employeeId<1 && designation.isEmpty()) {
			return null;
		}
		return dao.authentication(employeeId, designation);
	}

}//end of class
