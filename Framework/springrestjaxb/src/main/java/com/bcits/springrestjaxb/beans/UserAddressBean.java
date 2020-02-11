package com.bcits.springrestjaxb.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name ="user-address")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAddressBean {
	
	
	@XmlElement(name="house-number")
	private int housnumber;
	@XmlElement 
	private  String street;
	@XmlElement 
	private  String city;
	@XmlElement(name="addres-type")
	private  char addressType;
	

}//End of class
