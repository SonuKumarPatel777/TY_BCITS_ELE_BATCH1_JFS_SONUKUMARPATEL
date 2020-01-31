package com.bcits.discomusecase.dao;

import com.bcits.discomusecase.beans.ConsumersMasterBean;

public interface ConsumersMasterDAO {
	
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean);
    
	public ConsumersMasterBean authentication(String meterNumber, String password);
}//End of interface
