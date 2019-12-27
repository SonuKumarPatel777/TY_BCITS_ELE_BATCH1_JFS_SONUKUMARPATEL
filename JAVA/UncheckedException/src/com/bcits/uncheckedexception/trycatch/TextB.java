package com.bcits.uncheckedexception.trycatch;

public class TextB {
	public static void main(String[] args) {
		String name = null;
		System.out.println("main method starts");
		try {
			System.out.println(name.length());
			System.out.println(10/0);
		}catch(ArithmeticException | NullPointerException a) {
			System.out.println(a.getMessage());
		}
		System.out.println("main ends");
	}
   
}
