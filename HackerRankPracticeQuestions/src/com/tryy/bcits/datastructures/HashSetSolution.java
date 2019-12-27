package com.tryy.bcits.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HashSetSolution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of pairs you want to add");
		int n = Integer.parseInt(scanner.nextLine());
		HashSet<String> hashSet = new HashSet<String>();
		ArrayList<Integer> a= new ArrayList<Integer>(n);
		for(int i = 1;i <= n; i++) {
			System.out.println("Enter the "+i+"pair");
			hashSet.add(scanner.nextLine());
			a.add((hashSet.size()));
		}
		System.out.println("Output");
		for(int n1:a)
		System.out.println(n1);
		scanner.close();
     }

}
