package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Consumers_master")
public class ConsumersMasterBean implements Serializable {
	@Id
	@Column(name="meter_number")
	private String meterNumber;
	
	@Column 
	private String name;
	
	@Column
	private String email;
	
	@Column(name="phone_number")
	private Long phoneNumber;
	
	@Column
	private String region;
	
	@Column(name="consumer_type")
	private String consumerType;
	
	@Column(name="date_of_connection")
	private Date dateOfConnection;
	
	@Column(name="house_number")
	private Integer houseNumber;
	
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

