package com.bcits.mapinterface.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		TreeMap<Student, Integer> t1 = new TreeMap<Student, Integer>(new SortAge());
		t1.put(new Student(15,"sonu"),78);
		t1.put(new Student(20,"basanta"),99);
		t1.put(new Student(8,"jayanti"),101);
		t1.put(new Student(18,"Debendra"),178);
		            Set<Map.Entry<Student,Integer>> s1 = t1.entrySet();
		            for (Entry<Student, Integer> entry : s1) {
						System.out.println(entry.getKey());
						System.out.println(entry.getValue());
						System.out.println("-----------------------");
					}
	}

}
