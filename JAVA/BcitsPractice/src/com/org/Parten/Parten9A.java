package com.org.Parten;

import java.util.Scanner;

public class Parten9A{
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter the n=");
		int n=scn.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==n/2||j==n/2) {
					if(i==n/2)
					    System.out.print(".");
					if(j==n/2)
						System.out.print(".");
				}	
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
