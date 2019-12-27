package com.bcits.uncheckedexception.trycatch;

public class TestC {
	public static void main(String[] args) {
		String name = null;
		System.out.println("main method starts");
		try {
			try {
				System.out.println(10/0);
			
			}catch(ArithmeticException a) {
				System.out.println(a.getMessage());
			}
			System.out.println(name.length());
		}catch(NullPointerException a) {
			System.out.println(a.getMessage());
		}
		System.out.println("main ends");
	}

}
