package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
 

import lombok.Data;

@Data
@Embeddable
public class TarrifMasterPK implements Serializable{
	
 
	@Column(name="type_of_consumer")
	private String typeOfConsumer;
	
	@Column(name="units_range")
	private int unitsRange;

}//end of class