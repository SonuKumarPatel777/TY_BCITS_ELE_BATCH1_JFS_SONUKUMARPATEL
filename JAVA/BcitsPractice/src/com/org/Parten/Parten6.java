package com.org.Parten;

public class Parten6 {

	public static void main(String[] args) {
		int st=0;
		for(int i=0;i<4;i++) {
	    	   for(int j=3;j>=i;j--) {
	    		   System.out.print(" ");
	    	   }
	    	   for(int k=0;k<=st;k++) {
	    		   System.out.print("*");
	    	   }
	    	   System.out.println();
	    	   st+=2;
	       }
	}

}
