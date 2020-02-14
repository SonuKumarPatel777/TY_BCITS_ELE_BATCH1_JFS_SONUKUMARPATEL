package com.bcits.discomusecase.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;

public class FormValidation {

	public boolean meterNumberValidation(String meterNumber) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Matcher hasSpeical = special.matcher(meterNumber);
		if (meterNumber == null || meterNumber.isEmpty()) {
			return true;
		} else if (hasSpeical.find()) {
			return true;
		}
		return false;
	}// end of meterNumberValidation()

	public boolean isRegionValidation(String region) {
		return ((region != null) && (region.matches("^[a-zA-Z]*$")));
	}// end of isRegionValidation()

	public boolean nameValidation(String str) {
		if (str != null || !str.isEmpty()) {
			return true;
		}
		return false;
	}// end of nameValidation()

	public boolean isEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}// end of isEmailValid()

	public boolean isMobileNoValid(String s) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}// end of isMobileNoValid()

	public boolean typeOfConsumerValidation(String str) {
		if (str != null || !str.isEmpty()) {
			return true;
		}
		return false;
	}// end of typeOfConsumerValidation()

	public boolean validateAddress(String address) {
		if (address != null && !address.isEmpty()) {
			return true;
		}
		return false;
	}// end of validateAddress()

	public boolean validateZip(int zip) {
		String zipCode = zip + "";
		if ((zipCode.length() == 6)) {
			return true;
		}
		return false;

	}// end of validateZip() 

	public boolean validatePassword(String password) {
		if (password !=null && password.length() >= 4) {
			return true;
		}
		return false;

	}// end of validatePassword()

	public boolean consumerValidation(ConsumersMasterBean consumersMasterBean) {
		FormValidation validation = new FormValidation();
		if (validation.nameValidation(consumersMasterBean.getName())
				&& (!validation.meterNumberValidation(consumersMasterBean.getMeterNumber()))
				&& (validation.isEmailValid(consumersMasterBean.getEmail()))
				&& (validation.isMobileNoValid(consumersMasterBean.getMeterNumber()))
				&& (validation.isRegionValidation(consumersMasterBean.getRegion()))
				&& (validation.typeOfConsumerValidation(consumersMasterBean.getConsumerType()))
				&& (validation.validateAddress(consumersMasterBean.getAddress1()))
				&& (validation.validateAddress(consumersMasterBean.getAddress2()))
				&& (validation.nameValidation(consumersMasterBean.getCity()))
				&& (validation.validateZip(consumersMasterBean.getZip()))
				&& (validation.validatePassword(consumersMasterBean.getPassword()))) {
			return true;
		}
		return false;

	}// end of consumerValidation()
	
	public boolean validateEmpId(int empId) {
		String zipCode = empId + "";
		if (!(zipCode.length()<=3)) {
			return true;
		}
		return false;

	}// end of validateZip()
	public boolean employeeValidation(EmployeeMasterBean employeeMasterBean) {
		FormValidation validation = new FormValidation();
		if (validation.nameValidation(employeeMasterBean.getName())
				&& (validation.isRegionValidation(employeeMasterBean.getRegion()))
				&& (validation.validateEmpId(employeeMasterBean.getEmployeeId()))
				&& (validation.nameValidation(employeeMasterBean.getDesignation()))
				&& (validation.validatePassword(employeeMasterBean.getPassword()))) {
			return  true;
		}
		return false;

	}// end of consumerValidation()

}// end of class
