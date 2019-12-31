package com.org.third;

import java.util.Scanner;

public class SwopingTheWord{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str=s.nextLine();
		String str1="";
		String [] arr=str.split(" ");
		for (int i = 0; i < arr.length; i++) {
			if(i==0) {
				str1+=arr[arr.length-1]+" ";
				} else if(i%2==0) {
					str1+=arr[i-2]+" ";
				} else {
					str1+=arr[i]+" ";
				}
		}
		str1=str1.trim();
		System.out.println("Output String: "+str1);
}

}
