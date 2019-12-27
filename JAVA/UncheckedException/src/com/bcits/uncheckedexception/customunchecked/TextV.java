package com.bcits.uncheckedexception.customunchecked;

public class TextV {
	public static void main(String[] args) {
		System.out.println("main starts");
		Election e1 = new Election();
		try {
			e1.vote(12);
		}catch(AgeLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ends");
		
	}

}
