package com.ty.bcits.sortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class InsertationSortAnalysis {
	public static void insertationSort(int []a) {
		int key,j;
		for(int i=1 ;i<a.length;i++) {
		    key=a[i];
			j=i-1;
			while(j>-1&& a[j]>key) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
	}
	
	public static void countDurationOfInsertationSort(int []a) {
	   	  Instant start= Instant.now();
	   	  insertationSort(a);
	   	  Instant end= Instant.now();
	   	  long duration =Duration.between(start, end).toMillis();
	      double second=duration/1000.0;
	      System.out.println("Insertation sort took "+second+"Second to sort an array");
	}

}
