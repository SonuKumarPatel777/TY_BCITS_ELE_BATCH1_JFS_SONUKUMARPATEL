package com.ty.bcits.sortingAlgorithms;

import com.ty.bcits.searchingAlgorithms.BinarySearchAlgorithms;

public class Text {
	public static void main(String[] args) {
	    
		int [] a=new int[10000];  
		int [] b=new int[10000];
		int [] c=new int[10000];
		for(int i=1;i<=10000;i++)
			a[i-1]=i;
		for(int k=0;k<=9999;k++) {
			for(int j=a.length-1;j>0;j--)
				b[k]=a[j];
		}
		 
		for (int i = 0; i < 10000; i++) { 
            int rand = (int)Math.random();
            c[i]=rand;
		}
		System.out.println("Sorted Array");
		QuickSortAnalysis.countDurationOfQuickSort(a, 0, 9999);
		System.out.println("Reverse Array");
		BubbleSortAnalysis.countDurationOfBubbleSort(b);
		System.out.println("Random Array");
		BubbleSortAnalysis.countDurationOfBubbleSort(c);
		int [] arr= {4,2,5,9,8,13,45,67,4,5};
		MargeSortAnalysis.margeSort(arr);
		for(int n:arr)
			System.out.println(n);
		 
		
	}

}
