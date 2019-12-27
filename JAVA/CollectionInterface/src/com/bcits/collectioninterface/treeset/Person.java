package com.bcits.collectioninterface.treeset;

public class Person implements Comparable<Person> {
	int age;
	String name;
	Person(int age, String name){
		this.age=age;
		this.name=name;
	}
//	@Override
//	public int compareTo(Person o) {
//		return this.age-o.age;
//	}
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	 

}
