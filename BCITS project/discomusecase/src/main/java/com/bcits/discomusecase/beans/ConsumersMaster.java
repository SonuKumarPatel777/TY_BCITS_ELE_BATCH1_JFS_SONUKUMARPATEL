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
@Table(name="Consumers_Master")
public class ConsumersMaster implements Serializable {
	@Id
	@Column(name="meter_Number")
	private String meterNumber;
	
	@Column 
	private String name;
	
	@Column
	private String email;
	
	@Column(name="phone_Number")
	private Long phoneNumber;
	
	@Column
	private String region;
	
	@Column(name="consumer_Type")
	private String consumerType;
	
	@Column(name="date_Of_Connection")
	private Date dateOfConnection;
	
	@Column(name="house_Number")
	private int houseNumber;
	
	@Column 
	private String address1;
	
	@Column 
	private String address2;
	
	@Column
	private String city;
	
	@Column
	private int zip;
	
	@Column
	private String password;

}// End of Class
