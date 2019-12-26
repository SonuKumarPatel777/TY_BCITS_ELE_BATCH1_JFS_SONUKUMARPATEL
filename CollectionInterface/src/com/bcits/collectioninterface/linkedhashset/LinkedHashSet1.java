package com.bcits.collectioninterface.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSet1 {
	public static void main(String[] args) {
		java.util.LinkedHashSet<Integer> lhs  = new LinkedHashSet<Integer>();
		lhs.add(45);
		lhs.add(2);
		lhs.add(1);
		lhs.add(56);
		lhs.add(45);
		System.out.println(lhs);
		lhs.add(null);
		System.out.println(lhs);
		lhs.remove(1);
		System.out.println(lhs);
	}

}
