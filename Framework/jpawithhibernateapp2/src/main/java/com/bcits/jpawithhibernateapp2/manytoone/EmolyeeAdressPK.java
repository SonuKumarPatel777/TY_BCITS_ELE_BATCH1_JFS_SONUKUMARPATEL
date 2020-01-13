package com.bcits.jpawithhibernateapp2.manytoone;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class EmolyeeAdressPK  implements Serializable{
	private int empId;
	private String Address_type;

}
