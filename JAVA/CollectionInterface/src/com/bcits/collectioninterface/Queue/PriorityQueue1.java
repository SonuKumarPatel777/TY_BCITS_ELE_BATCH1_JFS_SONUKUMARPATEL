package com.bcits.collectioninterface.Queue;

import java.util.PriorityQueue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> p1 = new PriorityQueue<Integer>();
		p1.add(52);
		p1.add(85);
		p1.add(52);
		p1.add(78);
		p1.add(55);
		p1.add(8);
		System.out.println(p1);
		p1.remove();
		System.out.println(p1);
		p1.remove();
		System.out.println(p1);
		
	}

}
