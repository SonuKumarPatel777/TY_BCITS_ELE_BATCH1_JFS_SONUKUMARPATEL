package com.tryy.bcits.datastructures;

import java.util.Scanner;

public class SolutionReverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your String=");
		String s1 = scn.next();
		String s = s1.toLowerCase();
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (!(s.charAt(i) == s.charAt(len - 1 - i))) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("NO");

	}// End of main

}// End of Class
