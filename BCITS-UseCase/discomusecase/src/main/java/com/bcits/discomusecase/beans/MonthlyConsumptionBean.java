package com.bcits.discomusecase.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="monthly_consumption")
public class MonthlyConsumptionBean {
	@EmbeddedId
	private MonthlyConsumptionPK consumptionPk;
	
	@Column(name="previous_reading")
	private int previousReading;
	
	@Column
	private String region;
	
	@Column(name="current_reading")
	private int currentReading;
	
	@Column(name="bill_amount")
	private Double billAmount;
	
	@Column
	private int consumption;
	
	@Column
	private String status;
}//end of class
