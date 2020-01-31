package com.bcits.discomusecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.dao.ConsumersMasterDAO;

@Service
public class ConsumerMasterServiceImplimentaion implements ConsumerMasterService{
	
	@Autowired
	private ConsumersMasterDAO dao;

	@Override
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean, String cnfPassword) {
		if(!consumersMasterBean.getPassword().equals(cnfPassword)) {
			return false;
		}
		return dao.registerConsumer(consumersMasterBean);
	}//end of registerConsumer()
	
	
	@Override
	public ConsumersMasterBean authentication(String meterNumber, String password) {
		
		return dao.authentication(meterNumber, password);
	}//end of authentication()

}//end of class
