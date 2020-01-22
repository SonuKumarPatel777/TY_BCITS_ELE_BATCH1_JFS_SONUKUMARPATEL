package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.MessageBeans;

public class MessageTest {

	public static void main(String[] args) {
		
		ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
		((ConfigurableApplicationContext)context).registerShutdownHook();//After main 
		
		MessageBeans messageBeans = (MessageBeans)context.getBean("message");
		System.out.println(messageBeans.getMessage());
		
//		 ((AbstractApplicationContext)context).close();
		MessageBeans messageBeans2 = (MessageBeans)context.getBean("message");
		System.out.println(messageBeans2.getMessage());

	}//End Of main()

}//End of Class
