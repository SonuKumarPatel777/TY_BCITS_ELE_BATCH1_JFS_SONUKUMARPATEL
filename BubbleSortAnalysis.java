package com.ty.bcits.sortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class BubbleSortAnalysis {
		public static void bubbleSort(int arr[])
	    {
	        
	        for (int i = 0; i < arr.length-1; i++) {
	            for (int j = 0; j < arr.length-1-i; j++) {
	                if (arr[j] > arr[j+1])
	                {
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	            }
	        }
	    }
		
		public static void countDurationOfBubbleSort(int []a) {
		   	Instant start= Instant.now();
		   	bubbleSort(a);
		   	Instant end= Instant.now();
		   	long duration =Duration.between(start, end).toMillis();
		    double second=duration/1000.0;
		    System.out.println("Bubble sort took "+second+"Second to sort an array");
		}
		
		

}
