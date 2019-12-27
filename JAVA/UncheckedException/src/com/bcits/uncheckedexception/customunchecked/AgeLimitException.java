package com.bcits.uncheckedexception.customunchecked;

public class AgeLimitException extends RuntimeException {
	String smg="Age below 18";
	public AgeLimitException() {
	
	}
	public AgeLimitException(String smg) {
		this.smg = smg;
	}
	@Override
	public String getMessage() {
		return this.smg;
	}
	
	

}
