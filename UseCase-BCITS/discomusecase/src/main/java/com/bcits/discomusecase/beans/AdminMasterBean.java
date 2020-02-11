package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="admin_master")
public class AdminMasterBean implements Serializable{

	@Column(name="admin_id")
	private int adminId;
	
	@Column
	private String name;
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column
	private String password;
	
	@Column
	private String email;
	

}//End of Class
