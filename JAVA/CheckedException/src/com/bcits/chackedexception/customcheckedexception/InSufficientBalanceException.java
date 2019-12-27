package com.bcits.chackedexception.customcheckedexception;

public class InSufficientBalanceException extends Exception {
	  String msg = "Insufficient balance";
	  public   InSufficientBalanceException() {
		  
	  }
	  public   InSufficientBalanceException(String msg) {
		  this.msg=msg;
		  
	  }
	@Override
	public String getMessage() {
		return this.msg;
	}
	  

}
