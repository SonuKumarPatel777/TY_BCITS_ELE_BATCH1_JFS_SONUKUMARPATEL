package com.bcits.uncheckedexception.trycatch;

public class TestA {
	public static void main(String[] args) {
		String name = null;
		System.out.println("main method starts");
		try {
			System.out.println(10/0);
			System.out.println(name.length());
		}catch(ArithmeticException a) {
			System.out.println(a.getMessage());
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ends");
	}

}
