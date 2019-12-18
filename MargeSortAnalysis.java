package com.ty.bcits.sortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class MargeSortAnalysis {
	public static void margeSort(int a []) {
		if(a.length==1)return;
		int [] l = new int[a.length/2];
		int [] r = new int[a.length-l.length];
		int i;
		for( i = 0;i < l.length;i++) 
			l[i] = a[i];
		for(int j = 0;j<r.length;j++) {
			r[j] = a[j];
			i++;
		}
		margeSort(l);
		margeSort(r);
		sort(l,r,a);
	}
	
	public static void sort(int []a,int []b,int []c) {
		int i = 0,j = 0,k = 0;
		while(i<a.length&&j<b.length) {
			if(a[i] < b[i]) {
				c[k] = a[i];
				i++;
				k++;
			}
			else {
				c[k] = b[j];
				j++;
				k++;
			}
		}
		while(i < a.length) {
			c[k] = a[i];
			i++;
			k++;
		}
		while(j < a.length) {
			c[k]=b[j];
			i++;
			k++;
		}
			
	}
  public static void countDurationOfMargeSort(int []a) {
   	  Instant start= Instant.now();
   	  margeSort(a);
   	  Instant end= Instant.now();
   	  long duration =Duration.between(start, end).toMillis();
      double second=duration/1000.0;
      System.out.println("Marge sort took "+second+"Second to sort an array");
}
	 
}
