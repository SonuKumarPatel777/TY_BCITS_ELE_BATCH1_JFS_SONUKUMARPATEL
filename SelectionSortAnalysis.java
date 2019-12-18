package com.ty.bcits.sortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class SelectionSortAnalysis {
	public static void selectionSort(int[] a) {
		for(int i=0 ;i<=a.length-1;i++) {
			int index=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[index]) {
					index=j;
				}
			}
			if(i!=index) {
				int temp=a[index];
				a[index]=a[i];
				a[i]=temp;
			}
		}
	}
	
	public static void countDurationOfSelection(int []a) {
	   	Instant start= Instant.now();
	    selectionSort(a);
	   	Instant end= Instant.now();
	   	long duration =Duration.between(start, end).toMillis();
	    double second=duration/1000.0;
	    System.out.println("Selection sort took "+second+"Second to sort an array");
	}

}
