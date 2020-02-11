package com.bcits.discomusecase.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidation {
	
	public  boolean meterNumberValidation(String meterNumber) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Matcher hasSpeical = special.matcher(meterNumber);

		if (meterNumber == null || meterNumber.isEmpty()) {
			return true;

		} else if (hasSpeical.find()) {
			return true;
		}
		return false;

	}//end of meterNumberValidation()
	
	public  boolean isRegionValidation(String region) 
	{ 
		return ((region != null) && (region.matches("^[a-zA-Z]*$")));
	} 

}//end of class
