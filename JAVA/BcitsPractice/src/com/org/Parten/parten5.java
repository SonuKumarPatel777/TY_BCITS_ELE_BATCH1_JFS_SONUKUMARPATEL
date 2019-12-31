package com.org.Parten;

public class parten5 {

	public static void main(String[] args) {
		for(int i=0;i<4;i++) {
	    	   for(int j=0;j<i;j++) {
	    		   System.out.print(" ");
	    	   }
	    	   for(int k=3;k>=i;k--) {
	    		   System.out.print("*");
	    	   }
	    	   System.out.println();
	       }
	}

}
