package com.org.Parten;

 

public class Parten8 {
	public static void main(String[] args) {
		  int [][] n= {{0,0,0,0,0,1,0,0,0,0,0},
				       {0,0,0,0,1,0,1,0,0,0,0},
				       {0,0,0,1,0,0,0,1,0,0,0},
				       {0,0,1,0,0,0,0,0,1,0,0},
				       {0,0,0,1,0,0,0,1,0,0,0},
				       {0,0,0,0,1,0,1,0,0,0,0},
				       {0,0,0,0,0,1,0,0,0,0,0}};
		   for(int i=0;i<7;i++) {
			   for(int j=0;j<11;j++) {
				   if(n[i][j]==1)
					   System.out.print(".");
				   else
					   System.out.print(" ");
			   }
			   System.out.println();
		   }
		  
	}

}
