package com.bcits.discomusecase.beans;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="help_consumer")
public class HelpConsumerBean {
	
	@EmbeddedId
	private HelpConsumerBeanPK helpConsumerBeanPK;

	@Column
	private String responce;
	
	@Column
	private String region;

}//end of Class
