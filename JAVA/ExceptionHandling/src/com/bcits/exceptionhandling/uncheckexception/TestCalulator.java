package com.bcits.exceptionhandling.uncheckexception;

public class TestCalulator {

	public static void main(String[] args) {
		System.out.println("main methyod starts");
		Calculator c1 = new Calculator();
		c1.divison(100, 5);
		c1.divison(100, 0);
		c1.divison(20, 5);
		c1.divison(100, 20);
		System.out.println("main ends");

	}

}
