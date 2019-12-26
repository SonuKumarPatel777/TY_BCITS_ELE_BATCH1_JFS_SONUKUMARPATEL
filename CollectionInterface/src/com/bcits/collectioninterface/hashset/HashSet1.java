package com.bcits.collectioninterface.hashset;

import java.util.HashSet;

public class HashSet1 {
	public static void main(String[] args) {
		HashSet<Integer> hs =new HashSet<Integer>();
		hs.add(45);
		hs.add(2);
		hs.add(1);
		hs.add(56);
		System.out.println(hs);
		hs.add(null);
		System.out.println(hs);
	}

}
