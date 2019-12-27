package com.bcits.exceptionhandling.checkexception;

public class Text {
	public static void main(String[] args) {
		System.out.println("main methyod starts");
		Calculator c1 = new Calculator();
		c1.divison(100, 0);
		System.out.println("main ends");
	}
}
