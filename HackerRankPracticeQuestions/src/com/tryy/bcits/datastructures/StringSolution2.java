package com.tryy.bcits.datastructures;

class Solution {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		int n = s.length();
		for (int i = 0; i < 3; i++) {
			int k1 = n - 1 - i;
			smallest += s.charAt(k1);
			largest += s.charAt(i);
		}

		return smallest + "\n" + largest;
	}

}

public class StringSolution2 {
	public static void main(String[] args) {
		Solution.getSmallestAndLargest("welcometojava", 3);
		System.out.println("ghtyf");

	}

}
