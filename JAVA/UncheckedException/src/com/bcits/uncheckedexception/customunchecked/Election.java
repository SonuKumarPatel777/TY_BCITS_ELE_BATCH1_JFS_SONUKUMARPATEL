package com.bcits.uncheckedexception.customunchecked;

public class Election {
	void vote(int age) {
		if(age>=18) {
			System.out.println(" allow him/her for vote");
		}else {
			throw new AgeLimitException();
		}
	}

}
