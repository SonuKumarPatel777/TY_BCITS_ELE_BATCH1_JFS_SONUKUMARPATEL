package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
 
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tarrif_master")
public class TarrifMasterBean implements Serializable{
	 
	@EmbeddedId
	private TarrifMasterPK tarrifMasterPK;
	
	@Column(name="mulitplayer_amount")
	private int mulitplayerAmount;

}//end of class