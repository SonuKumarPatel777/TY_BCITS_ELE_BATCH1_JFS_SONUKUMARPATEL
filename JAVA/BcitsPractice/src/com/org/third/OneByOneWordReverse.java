package com.org.third;

import java.util.Scanner;

public class OneByOneWordReverse {
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
				if(i<arr.length-1)
				str1+=arr[++i]+" ";
				}
			System.out.println("Output String: "+str1);
	}

}
