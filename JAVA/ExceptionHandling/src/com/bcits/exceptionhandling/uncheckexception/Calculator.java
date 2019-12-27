package com.bcits.exceptionhandling.uncheckexception;

public class Calculator {
	void add(int a,int b) {
		System.out.println(a+b);
	}
	
	void divison(int a,int b) {
		try {
		    System.out.println(a/b);
		}catch(ArithmeticException k) {
			System.out.println("MATH ERROR");
			
		}
	}

}
