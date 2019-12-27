package com.bcits.collectioninterface.treeset;

import java.util.TreeSet;

public class TreeSet1 {
	public static void main(String[] args) {
		TreeSet<Person> ts =new TreeSet<Person>(new SortAge());
		ts.add(new Person(15,"Sonu"));
		ts.add(new Person(21,"Kumar"));
		ts.add(new Person(24,"Basanta"));
		ts.add(new Person(17,"Jayanti"));
		System.out.println(ts);
		
	}

}
