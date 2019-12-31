package com.org.second;
interface IceCream {
	public void recive(IceCream flavour);
	}

public class Baby implements IceCream  {
	IceCream ic;
	String s="";
	Baby(){
	}
	Baby(IceCream i){
	    ic=i;
	}
	@Override
	public String toString() {
		return s;
	}

	@Override
	public void recive(IceCream flavour) {
		  System.out.println("Baby is having  " + ic + " flavoured Icecream");	
	}

}
