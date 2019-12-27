package com.bcits.chackedexception.customcheckedexception;

public class Text {

	public static void main(String[] args) {
          System.out.println("main starts");
          ATMSimulator a1 = new ATMSimulator();
          try {
        	  a1.withDraw(41000);
          }catch(InSufficientBalanceException e) {
        	  System.out.println(e.getMessage());
          }
          System.out.println("main ends");
	}

}
