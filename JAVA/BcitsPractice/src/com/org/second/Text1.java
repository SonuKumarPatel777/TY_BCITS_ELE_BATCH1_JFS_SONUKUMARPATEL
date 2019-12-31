package com.org.second;

import java.util.Scanner;

 
public class Text1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("which flavour IceCream");
		String str1=scn.next();
		IceCream flavour1  = new Baby();
		Baby b1 = new Baby(flavour1);
		b1.recive(flavour1);
		
	}
	 
}
