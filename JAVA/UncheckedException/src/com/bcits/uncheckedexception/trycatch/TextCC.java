package com.bcits.uncheckedexception.trycatch;

public class TextCC {
	public static void main(String[] args) {
		System.out.println("main starts");
		try {
		A.a();
		}catch(ArithmeticException a) {
			System.out.println(a.getMessage());
		}
		System.out.println(" main ends");
		
	}

}
