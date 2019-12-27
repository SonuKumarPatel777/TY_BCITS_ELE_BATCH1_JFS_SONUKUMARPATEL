package com.bcits.mapinterface.linkedhashmap;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap1 {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String>  h1 = new LinkedHashMap<Integer, String>();
		h1.put(24,"Sonu");
		h1.put(27,"Sunita");
		h1.put(29,"Abhi");
		System.out.println(h1);
		System.out.println("***************************");
		Set<Map.Entry<Integer,String>> s1 = h1.entrySet();
		for (Map.Entry<Integer, String> entry : s1) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("-------------------");
			
		}
		
		System.out.println("-----------get(key)------------");
		System.out.println(h1.get(27));
		System.out.println("--------------keySet-------------");
		Set<Integer> s2 = h1.keySet();
		for (Integer integer : s2) {
			System.out.println(integer);
		}
		
		System.out.println("---------------values-------------");
		Collection<String> c1 = h1.values();
		for (String string : c1) {
			System.out.println(string);
		}
		 
	}

}
