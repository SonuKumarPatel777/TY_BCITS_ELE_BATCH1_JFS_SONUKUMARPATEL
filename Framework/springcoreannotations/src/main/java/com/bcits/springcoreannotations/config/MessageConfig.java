package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.MessageBean;
import com.bcits.springcoreannotations.mypostprocessor.MyBeanFactoryPostProcessor;
import com.bcits.springcoreannotations.mypostprocessor.MyBeanPostProcessor;

@Configuration
public class MessageConfig {

	@Bean(name="messageBean")
	public MessageBean getMessageBean() {
		MessageBean messageBean = new MessageBean();
		messageBean.setMessage("welcome to Spring core...");
		return messageBean;

	}// End Of getMessageBean()
	
	@Bean
	public MyBeanPostProcessor getMyBBP() {
		return new MyBeanPostProcessor();
	}//End of getMyBBP()
	
	@Bean
	public MyBeanFactoryPostProcessor getMyBFPP() {
		return new MyBeanFactoryPostProcessor();
	}

}// End of Class
