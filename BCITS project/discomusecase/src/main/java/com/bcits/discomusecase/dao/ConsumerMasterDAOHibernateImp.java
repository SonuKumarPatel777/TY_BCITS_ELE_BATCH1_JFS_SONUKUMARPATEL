package com.bcits.discomusecase.dao;

 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
 

@Repository
public class ConsumerMasterDAOHibernateImp implements ConsumersMasterDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(consumersMasterBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return false;
	}//end of registerConsumer()
	
	
	@Override
	public ConsumersMasterBean authentication(String meterNumber, String password) {
		EntityManager manager = emf.createEntityManager();
		ConsumersMasterBean consumersMasterBean = manager.find(ConsumersMasterBean.class, meterNumber );
		if (consumersMasterBean != null && consumersMasterBean.getPassword().equals(password)) {
			return consumersMasterBean;
		} else {
			return null;
		}
	}//end of authentication()

}//end of class
