package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BillHistoryPK implements Serializable{
	
	@Column(name="meter_number")
	private String meterNumber;
	
	@Column(name="payment_date")
	private Date paymentDate;

}//end of class
