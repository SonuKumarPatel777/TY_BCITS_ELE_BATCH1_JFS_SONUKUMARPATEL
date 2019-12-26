package com.bcits.collectioninterface.vector;

import java.util.Vector;

public class Vector1 {
	public static void main(String[] args) {
		Vector<Integer>  v = new Vector<Integer>();
		v.add(20);
		v.add(null);
		v.add(40);
		v.add(80);
		v.add(40);
		v.add(50);
		System.out.println(v);
		System.out.println("----------remove----------");
		v.remove(3);
		System.out.println(v);
		System.out.println(v.isEmpty());
		System.out.println(v.size());
		System.out.println(v.contains(20));
		v.trimToSize();
		System.out.println(v);
		v.insertElementAt(80, 0);
		System.out.println(v);
		System.out.println(v.capacity());
		v.setElementAt(100, 0);
		System.out.println(v);
		v.trimToSize();
		System.out.println(v.capacity());


	}

}
