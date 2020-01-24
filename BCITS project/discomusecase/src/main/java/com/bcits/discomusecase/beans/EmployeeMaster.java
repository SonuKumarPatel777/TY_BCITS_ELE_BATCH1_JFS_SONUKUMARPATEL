package com.bcits.discomusecase.beans;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Employee_Master")
public class EmployeeMaster implements Serializable{
	@Id
	@Column(name="emp_Id")
	private int empId;
	
	@Column
	private String name;
	
	@Column
	private String region;
	
	@Column
	private String designation;
	

}//End of Class
