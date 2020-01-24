package com.bcits.discomusecase.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryFactory {
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	private EntityManagerFactoryFactory() { }
	
	public static  EntityManagerFactory getEntityManagerFactoryInstance() {
		if( entityManagerFactory != null) {
			return entityManagerFactory;
		}
		return entityManagerFactory = Persistence.createEntityManagerFactory
				                      ("discomUsecasePersistenceUnit");
		
	}//End of getEntityManagerFactoryInstance()

}//End of class
