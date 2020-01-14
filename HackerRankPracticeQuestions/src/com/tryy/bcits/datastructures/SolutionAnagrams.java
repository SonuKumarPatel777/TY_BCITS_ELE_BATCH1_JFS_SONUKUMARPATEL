package com.tryy.bcits.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionAnagrams {

	public static void main(String[] args) {
		boolean status = true;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Yours first String=");
		String s1 = scanner.nextLine();
		String s3 = s1.replace(" ", "");
		String s5 = s3.toLowerCase();
		System.out.print("Enter Yours Second  String=");
		String s2 = scanner.nextLine();
		String s4 = s2.replace(" ", "");
		String s6 = s4.toLowerCase();
		if (s3.length() != s4.length()) {
			System.out.println("Not a Anagrams");
		} else {
			char[] arr1 = s5.toCharArray();
			char[] arr2 = s6.toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			status = Arrays.equals(arr1, arr2);
		}
		if (status)
			System.out.println("Anagrams");
		else
			System.out.println("Not a Anagrams");

	}// End of main Method

}// End of Class
