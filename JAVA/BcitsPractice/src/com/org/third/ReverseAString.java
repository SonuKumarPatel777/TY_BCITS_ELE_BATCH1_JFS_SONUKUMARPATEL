package com.org.third;

import java.util.Scanner;

public class ReverseAString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str=s.nextLine();
		String str1="";
		for (int i = str.length()-1; i >=0 ; i--) {
			str1 = str1+str.charAt(i);
		}
		str1=str1.trim();
		System.out.println("Reversed string is : " + str1);
		
	}
}
