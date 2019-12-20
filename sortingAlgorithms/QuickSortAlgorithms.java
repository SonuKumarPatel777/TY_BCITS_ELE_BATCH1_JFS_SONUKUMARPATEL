package com.ty.bcits.sortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class QuickSortAlgorithms {
	public static void quickSort(int []a,int l,int h) {
		int pivot = a[(l+h)/2];
		int i=l;
		int j=h;
		while(i<=j) {
			while(a[i]<pivot) {
				i++;
			}
			while(a[j]>pivot) {
				j--;
			}
			if(i<=j) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
			if(l<j)
				quickSort(a,l,j);
			if(i<h)
				quickSort(a,i,h);
		}
	}
	
	public static void countDurationOfQuickSort(int []a,int l,int h) {
	   	Instant start= Instant.now();
	   	quickSort(a,l,h);
	   	Instant end= Instant.now();
	   	long duration =Duration.between(start, end).toMillis();
	    double second=duration/1000.0;
	    System.out.println("Quick sort took "+second+"Second to sort an array");
	}

}
