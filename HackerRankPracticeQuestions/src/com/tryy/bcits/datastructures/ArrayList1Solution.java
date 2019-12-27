package com.tryy.bcits.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of line..");
		int n=scanner.nextInt();
		ArrayList<ArrayList<Integer>> arraylists = new ArrayList<ArrayList<Integer>>(n);
		
		ArrayList<Integer> arraylist =null; 
	    for(int i = 1;i <= n;i++) {
			System.out.println("Enter the number of elements you want to add in "+i+"th line");
			int d = scanner.nextInt();
			arraylist=new ArrayList<Integer>(d);
			arraylist.add(0,d);
			for(int j = 1;j <= d;j++) {
				System.out.println("Enter the valu "+j+"th place");
				arraylist.add(scanner.nextInt());	 
			}
			arraylists.add(arraylist);
			System.out.println(arraylists.toString());
		}
	    System.out.println("Enter the number of Queries");
	    int q=scanner.nextInt();
	    for(int k=1;k<=q;k++) {
	        System.out.println("Enter the line number");
	        int x=scanner.nextInt();
	        System.out.println("Enter the position");
	        int y=scanner.nextInt();
	        System.out.println(arraylists.get(x-1).get(y));
	   }
	    scanner.close();
	}

}
