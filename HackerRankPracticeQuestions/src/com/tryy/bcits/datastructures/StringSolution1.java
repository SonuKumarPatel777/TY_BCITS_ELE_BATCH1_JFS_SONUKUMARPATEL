package com.tryy.bcits.datastructures;

import java.util.Scanner;

public class StringSolution1 {
	public static void main(String[] args) {
		System.out.println("Enter Your String");
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(" Enter the Start indice number");
		int start = scn.nextInt();
		System.out.println(" Enter the end indice number");
		int end = scn.nextInt();
		String str = "";
		for (int i = start; i < end; i++) {
			str += s.charAt(i);
		}
		System.out.println(str);
	}// End Of Main

}// End Of Class
