package com.tryy.bcits.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map1Solution {
	public static void main(String[] args) {
		System.out.println("Enter the number of entries in the phone book ");
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		Map<String, Long> map = new HashMap<String, Long>(n);
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter the " + i + " person name");
			String name = scanner.nextLine(); 
			System.out.println("Enter the " + i + " person phone number ");
			
			int nm = Integer.parseInt(scanner.nextLine());
			Long num = (long) nm;
			map.put(name, num);
		}
		System.out.println(map.toString());
		System.out.println("Enter the name you want phone number");
		String str = scanner.nextLine();
		if(map.get(str) != null) 
		   System.out.println(str+" phone number is "+map.get(str));
		else
			System.err.println("Entry not Found");
	}

}