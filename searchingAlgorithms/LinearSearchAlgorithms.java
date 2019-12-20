package com.ty.bcits.searchingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class LinearSearchAlgorithms {
	public static int linearSearch(int arr[], int x) 
	{ 
	    int n = arr.length; 
	    for(int i = 0; i < n; i++) 
	    { 
	        if(arr[i] == x) 
	            return i; 
	    } 
	    return -1; 
	}
	
	public static void countDurationOfLinearSearch(int []a ,int x) {
	   	  Instant start= Instant.now();
	   	  linearSearch(a,x);
	   	  Instant end= Instant.now();
	   	  long duration =Duration.between(start, end).toMillis();
	      double second=duration/1000.0;
	      System.out.println("Linear Search took "+second+"Second to search an element");
	}
}
