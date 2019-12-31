package com.org.third;

interface I{
	int a=11;
	default void sub() {
		System.out.println("Sub");
	}
	static void add() {
		System.out.println("add");
		
	}
}
abstract class B{
	   static int a;
	   int age;
	   String name;
	   B(int a, String b){
		   age=a;
		   name=b;
	   }
	   static void add() {
		   System.out.println(" B class add");
	   }
	   
	   void sub() {
		   System.out.println("B class sub");
	   }
}

public class A implements I {
	public static void main(String[] args) {
		I.add();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	}

}
