package com.bcits.discomusecase.beans;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name ="bill_history")
public class BillHistoryBean {
	
	@EmbeddedId
	private BillHistoryPK biHistoryPK;
	@Column
	private Double amount;
	@Column
	private String status;

}//end of class
