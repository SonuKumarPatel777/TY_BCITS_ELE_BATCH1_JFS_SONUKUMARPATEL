package com.ty.bcits.sortingAlgorithms;

import java.util.Random;

public class RandomArrayCreation {
	public int[] randomArrayCreation(int size) {
		Random random =new Random();
		int intArray []=new int[size];
		for(int i=0;i<intArray.length;i++) {
			intArray[i]=random.nextInt(100);
		}
		return intArray;
		
	}

}
