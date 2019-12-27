package com.bcits.collectioninterface.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {
	public static void main(String[] args) {
	     List<Integer> a1 = new ArrayList<Integer>();
	     a1.add(10);
	     a1.add(20);
	     a1.add(30);
	     System.out.println(a1);
	     System.out.println("----------------addInIndex------------");
	     a1.add(1,55);
	     System.out.println(a1);
	     System.out.println("------------remove(index)---------------");
	     a1.remove(2);
	     System.out.println(a1);
	     System.out.println("-----------set---------------------------");
	     a1.set(1, 88);
	     System.out.println(a1);
	     System.out.println("----------------get----------------------");
	     System.out.println(a1.get(0));
	     System.out.println("-----------------indexof-----------------");
	     a1.add(10);
	     System.out.println(a1);
	     System.out.println(a1.indexOf(10));
	     System.out.println("-------------------addList----------------");
	     List<Integer> a2 = new ArrayList<Integer>();
	     a2.add(17);
	     a2.add(18);
	     a1.addAll(1, a2);
	     System.out.println(a1);
	     System.out.println("---------------------------------get--------");
	     System.out.println(a1.lastIndexOf(10));
	     for (int i = 0; i < a1.size(); i++) {
	    	 System.out.println(a1.get(i));
			
		}
	     System.out.println("------------subList-------------------------");
	     List li=a1.subList(0,1);
	     for (int i = 0; i < li.size(); i++) {
	    	 System.out.println(li.get(i));
			
		}
	     }

}
