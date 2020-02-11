package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="current_bill")
public class CurrentBillBean implements Serializable{
	@Id
	@Column(name="meter_number")
	private String meterNumber;
	
	@Column(name="previous_reading")
	private int previousReading;
	
	@Column(name="current_reading")
	private int currentReading;
	
	@Column
	private int consumption;
	
	@Column(name="bill_amount")
	private Double billAmount;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="consumer_type")
	private String consumerType;
	
	@Column
	private String status;
	
	@Column(name="billing_date")
	private Date billingDate;

}//end of class

