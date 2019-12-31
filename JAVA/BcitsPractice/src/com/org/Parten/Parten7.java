package com.org.Parten;

import java.util.Scanner;

public class Parten7 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter n= ");
		int n=scn.nextInt();
		for(int i=0;i<n;i++) {
	    	   for(int j=n-2;j>=i;j--) {
	    		   System.out.print(" ");
	    	   }
	    	   for(int k=0;k<=i;k++) {
	    		   if(k==0||k==i)
	    		      System.out.print("*");
	    		   else
	    			   System.out.print(" ");
	    	   }
	    	   System.out.println();
	     }
		for(int i=0;i<n-1;i++) {
	    	   for(int j=0;j<=i;j++) {
	    		   System.out.print(" ");
	    	   }
	    	   for(int k=n-2;k>=i;k--) {
	    		   if(k==i||k==n-2)
	    		      System.out.print("*");
	    		   else
	    			   System.out.print(" ");
	    	   }
	    	   System.out.println();
	     }
	}

}
