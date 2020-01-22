package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeans implements InitializingBean, DisposableBean {
	
	private String message;
	public MessageBeans() {
		System.out.println("it's Instantiation phase");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Insid init phase");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying....");
	}

	
	//init & destroy phase
	
	/*
	 * public void init() { System.out.println("It's Initialization phase"); }
	 * public void destroy() { System.out.println("It's  Destory phase"); }
	 */
	
}//End of class
