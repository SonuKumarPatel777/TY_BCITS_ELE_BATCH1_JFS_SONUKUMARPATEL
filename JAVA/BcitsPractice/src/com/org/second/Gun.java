package com.org.second;

public class Gun {
	Bullet b1;
	public Gun() {
		
	}

	public Gun(Bullet b1) {
		super();
		this.b1 = b1;
	}

	@Override
	public String toString() {
		return "GUn is here  " + b1 ;
	}
}
