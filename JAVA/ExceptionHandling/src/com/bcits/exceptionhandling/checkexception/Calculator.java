package com.bcits.exceptionhandling.checkexception;

public class Calculator {
	void divison(int a,int b) {
		try {
		     Class.forName("Person");
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found");
			
		}
	}

}
