package com.ty.bcits.sortingAlgorithms;

public class QuickSortAnalysis{
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
		QuickSortAlgorithms.countDurationOfQuickSort(a, 0, 9999);
		System.out.println("Reverse Array");
		QuickSortAlgorithms.countDurationOfQuickSort(b, 0, 9999);
		System.out.println("Random Array");
		QuickSortAlgorithms.countDurationOfQuickSort(c, 0, 9999);
		
	}


}
