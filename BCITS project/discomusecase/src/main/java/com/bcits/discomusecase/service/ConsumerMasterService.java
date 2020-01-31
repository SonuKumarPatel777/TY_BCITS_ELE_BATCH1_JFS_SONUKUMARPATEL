package com.bcits.discomusecase.service;

import com.bcits.discomusecase.beans.ConsumersMasterBean;

public interface ConsumerMasterService {
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean , String cnfPassword);
    
	public ConsumersMasterBean authentication(String meterNumber, String password);
}//end of interface
