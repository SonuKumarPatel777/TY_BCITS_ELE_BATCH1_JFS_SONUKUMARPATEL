package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="current_Bill")
public class CurrentBill implements Serializable{
	@Id
	@Column(name="meter_Number")
	private String meterNumber;
	
	@Column(name="previous_Reading")
	private int lastReading;
	
	@Column(name="current_Reading")
	private int currentReading;
	
	@Column
	private int consumption;
	
	@Column(name="bill_Amount")
	private double billAmount;
	
	@Column(name="due_Date")
	private Date dueDate;
	

}
