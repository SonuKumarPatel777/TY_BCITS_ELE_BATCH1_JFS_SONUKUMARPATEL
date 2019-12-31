package com.org.third;

import java.util.Scanner;

public class WordReverse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str=s.nextLine();
		String str1="";
		String [] arr=str.split(" ");
		for (int i = 0; i < arr.length; i++) {
			for(int j=arr[i].length()-1;j>=0;j--) {
				str1+=arr[i].charAt(j);
			    }
			str1+=" ";
			}
		str1=str1.trim();
		System.out.println("Output String: "+str1);
	}

}
