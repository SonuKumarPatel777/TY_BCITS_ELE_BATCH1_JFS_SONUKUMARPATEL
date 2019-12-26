package com.bcits.collection.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList1 {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(24);
		a1.add(46);
		System.out.println(a1);
		System.out.println("-------------Using for loop--------");
		for (int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i));
		}
		System.out.println("---------------using foreach loop----");
		for(Integer n:a1)
			System.out.println(n);
		System.out.println("---------------by using iterator-------");
		Iterator<Integer> itr =a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("----------by using ListIterator----------");
		ListIterator<Integer> lt= a1.listIterator(a1.size());
		while(lt.hasPrevious()) {
			System.out.println(lt.previous());
			
		}
	}

}
