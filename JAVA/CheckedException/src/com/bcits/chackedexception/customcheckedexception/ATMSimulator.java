package com.bcits.chackedexception.customcheckedexception;


public class ATMSimulator {
	int balance=40000;
	void withDraw(int amt) throws InSufficientBalanceException {
		if(amt<=balance) {
			System.out.println("withdraw Successfull");
		}else
			throw new InSufficientBalanceException();
	}

}
