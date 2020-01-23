package com.bcits.springcoreannotations.beans;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Elephent implements Animal {

	@Override
	public void eat() {
        System.out.println("Elephant eating");		
	}

	@Override
	public void speak() {
		System.out.println("hhhhhhhhh");
	}
	
}//End of class
