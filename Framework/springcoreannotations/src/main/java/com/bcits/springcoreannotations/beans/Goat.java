package com.bcits.springcoreannotations.beans;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Goat implements Animal {

	@Override
	public void eat() {
          System.out.println("goat eating ");		
	}

	@Override
	public void speak() {
       System.out.println("mmmmmmmmmm");		
	}
}//End of class
