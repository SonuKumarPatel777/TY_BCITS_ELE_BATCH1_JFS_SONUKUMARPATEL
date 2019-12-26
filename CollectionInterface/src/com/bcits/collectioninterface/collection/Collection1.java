package com.bcits.collectioninterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
	public static void main(String[] args) {
		Collection<Integer> c1 =new ArrayList<Integer>();
		c1.add(15);
		c1.add(20);
		c1.add(25);
		c1.add(30);
		Collection<Integer> c2 =new ArrayList<Integer>();
		c2.add(15);
		c2.add(88);
		c2.add(89);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("---------------------");
		c2.addAll(c1);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("------------------------");
		c2.removeAll(c1);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("------------containsAll----------------");
		System.out.println(c2.containsAll(c1));
		System.out.println("----------------retainAll-------------");
		Collection<Integer> c3 =new ArrayList<Integer>();
		c3.add(1);
		c3.add(2);
		c3.add(2);
		c3.add(3);
		Collection<Integer> c4 =new ArrayList<Integer>();
		c4.add(1);
		c4.add(2);
		c4.add(8);
		System.out.println(c3);
		System.out.println(c4);
		c4.retainAll(c3);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println("------------------toArray---------");
		Object [] o1=c4.toArray();
		for (int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
		}
	    
	}

}
