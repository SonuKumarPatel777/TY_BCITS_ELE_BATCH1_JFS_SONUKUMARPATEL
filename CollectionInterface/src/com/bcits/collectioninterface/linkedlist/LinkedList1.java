package com.bcits.collectioninterface.linkedlist;

import java.util.LinkedList;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<Integer> l1= new LinkedList<Integer>();
		l1.add(10);
		l1.add(30);
		l1.add(40);
		System.out.println(l1);
		l1.remove(2);
		System.out.println(l1);
		int n = l1.size();
		System.out.println(n);
		System.out.println(l1.isEmpty());
		
	}

}
