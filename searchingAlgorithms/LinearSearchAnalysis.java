package com.ty.bcits.searchingAlgorithms;

public class LinearSearchAnalysis {
	public static void main(String[] args) {
        int [] a= {4,5,22,6,17,8,9,11,8,7,13,14,16,18};
        System.out.println(LinearSearchAlgorithms.linearSearch(a, 22));
        LinearSearchAlgorithms.countDurationOfLinearSearch(a, 5);
	}

}
