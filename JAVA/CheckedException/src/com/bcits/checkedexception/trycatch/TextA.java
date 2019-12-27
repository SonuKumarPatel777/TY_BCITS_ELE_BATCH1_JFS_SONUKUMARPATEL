package com.bcits.checkedexception.trycatch;

public class TextA {
	public static void main(String[] args) {
		System.out.println(" main start");
		Person p1 =new Person();
		try {
			p1.clone();
			System.out.println("Object is clone");
		}catch(CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		System.out.println("main ends");		
	}

}
