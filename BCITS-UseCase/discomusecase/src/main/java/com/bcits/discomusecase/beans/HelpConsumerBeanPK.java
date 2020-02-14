package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class HelpConsumerBeanPK implements Serializable{
	
	@Column(name="meter_number")
	private String meterNumber;
    
	@Column
	private String querie;

}//end of class
