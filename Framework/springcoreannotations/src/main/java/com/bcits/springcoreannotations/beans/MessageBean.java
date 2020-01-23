package com.bcits.springcoreannotations.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean, DisposableBean{

	private String message;
	
	public MessageBean() {
		System.out.println("instantioation-Phase");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("initialization-phase");
		
	}
	
	@Override
	public void destroy() throws Exception {
		 System.out.println("destroy-phase");
		
	}

}// End of Class
