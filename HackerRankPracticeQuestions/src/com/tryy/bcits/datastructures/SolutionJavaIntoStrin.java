package com.tryy.bcits.datastructures;

import java.util.Scanner;

public class SolutionJavaIntoStrin {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number ");
		int n = in.nextInt();
		in.close();
		String s = "";
		s += n;
		if (n == Integer.parseInt(s)) {
			System.out.println("Good job");
		} else {
			System.out.println("Wrong answer.");
		}
	}//End of main()
}//End of Class