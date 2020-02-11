package com.bcits.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean getEntityManager() {
//		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setPersistenceUnitName("emsPersistenceUnit");
//		
//		return factoryBean;
//	}//End of getEntityManager()

//	@Bean
//	public JpaTransactionManager getManager(@Autowired EntityManagerFactory factory) {
//		JpaTransactionManager manager = new JpaTransactionManager();
//		manager.setEntityManagerFactory(factory);
//		return manager;
//	}
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManager() {
		LocalEntityManagerFactoryBean factoryBean =new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("emsPersistenceUnit");
		return factoryBean;
		
	}//End of getEntityManager()
	
	
}//End of class
