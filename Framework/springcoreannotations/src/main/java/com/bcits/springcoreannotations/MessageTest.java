package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.MessageBean;
import com.bcits.springcoreannotations.config.MessageConfig;

public class MessageTest {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
		MessageBean messageBean = context.getBean(MessageBean.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();

		System.out.println(messageBean.getMessage());

	}// End of main()

}// End of Class
