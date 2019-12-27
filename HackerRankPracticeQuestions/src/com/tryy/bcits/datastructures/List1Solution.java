package com.tryy.bcits.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List1Solution {
	    static Scanner scanner = new Scanner(System.in);
	    static List<Integer> list = null;
		public static void main(String[] args) {
			System.out.println("Enter the number of Elements You want to add");
			int n = Integer.parseInt(scanner.nextLine());
			list = new ArrayList<Integer>(n);
			for(int i = 1;i<=n;i++) {
				System.out.println("Enter the "+(i-1)+"th value");
				list.add(Integer.parseInt(scanner.nextLine()));
			}
			System.out.println(list.toString());
			System.out.println("Enter the number of Query you have");
			int q = Integer.parseInt(scanner.nextLine());
			for(int j = 1;j <= q;j++) {
				System.out.println("Enter the Query insert/delete ");
				String st = scanner.nextLine();
				if(st.equalsIgnoreCase("insert")) {
					System.out.println("Enter the index for insertion..");
					int x = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter the valu you want to insert");
					int y =Integer.parseInt(scanner.nextLine());
					list.add(x,y);
					n++;
			    }
				else if(st.equalsIgnoreCase("delete")) {
					System.out.println("Enter the index of the element you want to delete");
					int x = Integer.parseInt(scanner.nextLine());
					list.remove(x);
					n++;
				}
				else
					System.err.println("Enter the valid input");
				System.out.println(list.toString());
			}
		}

}
