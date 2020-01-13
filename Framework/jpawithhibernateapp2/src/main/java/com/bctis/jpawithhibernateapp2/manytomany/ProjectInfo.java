package com.bctis.jpawithhibernateapp2.manytomany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table
public class ProjectInfo implements Serializable{
	@Id
	@Column 
	private int pid;
	@Column 
	private String projName;
	@Column 
	private String technology;
	@Column 
	private Date startDate;
	@Column 
	private Date endDate;
	@Column 
	private String location;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name="employee_project_info", joinColumns =@JoinColumn(name="pid")
	,inverseJoinColumns =@JoinColumn(name="emoId") )
	private List<EmployeePrimaryInfo> primaryInfo;

}
