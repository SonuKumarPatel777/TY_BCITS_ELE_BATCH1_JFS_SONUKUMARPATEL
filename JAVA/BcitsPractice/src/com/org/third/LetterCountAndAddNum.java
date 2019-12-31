package com.org.third;

import java.util.Scanner;

public class LetterCountAndAddNum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str=s.nextLine();
		String str1="";
		String [] arr=str.split(" ");
		for (int i = 0; i < arr.length; i++) {
			str1+=arr[i]+arr[i].length()+" ";
			}
		str1=str1.trim();
		System.out.println("Output String: "+str1);
	}
}
