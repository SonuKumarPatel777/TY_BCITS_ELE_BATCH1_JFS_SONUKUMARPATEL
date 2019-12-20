package com.ty.bcits.searchingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class BinarySearchAlgorithms {
	public static int binarySearch(int [] a,int x) {
		int l = 0;
		int h = a.length-1;
		int m;
		while(l <= h) {
			m = (l + h) / 2;
			if(x ==a[m]) {
				return m;
			}
			else if (x < a[m]){
				h = m-1;
			}
			else
				l = m+1;
		}
		return -1;
	}
	
	public static void countDurationOfBinarySearch(int []a ,int x) {
	   	  Instant start= Instant.now();
	   	  binarySearch(a,x);
	   	  Instant end= Instant.now();
	   	  long duration =Duration.between(start, end).toMillis();
	      double second=duration/1000.0;
	      System.out.println("Binary Search took "+second+"Second to search an element");
	}
}
