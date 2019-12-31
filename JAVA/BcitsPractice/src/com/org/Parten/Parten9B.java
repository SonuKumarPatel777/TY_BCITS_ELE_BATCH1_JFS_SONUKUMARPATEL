package com.org.Parten;

import java.util.Scanner;

public class Parten9B {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter the n=");
		int n=scn.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i+j==n+1||i==j) {
					if(i+j==n+1)
					   System.out.print(".");
					if(i==j)
					   System.out.print(".");
				}    
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
