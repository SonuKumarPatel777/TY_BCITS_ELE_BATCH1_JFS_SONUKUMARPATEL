package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bcits.springcoreannotations.beans.EmployeeBean;

@Configuration
public class EmployeeConfig {
	
	
	/*
	 * @Bean
	 * @Scope("prototype") 
	 * public EmployeeBean getEmployeeBean() {
	 *     EmployeeBean employeeBean = new EmployeeBean();
	 *     employeeBean.setName("Ashin");
	 *     employeeBean.setAge(24);
	 * 
	 * return employeeBean; }
	 */
	
	@Bean
	/* @Scope("prototype") */
	public EmployeeBean getEmployeeBean() {
		EmployeeBean employeeBean = new EmployeeBean();
		return employeeBean;
	}

}//End of class
