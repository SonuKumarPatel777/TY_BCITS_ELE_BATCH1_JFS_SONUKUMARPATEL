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
@Table(name="project_info")
public class ProjectInfo implements Serializable{
	@Id
	@Column(name="ProjId")
	private int pid;
	@Column(name="proj_name") 
	private String projName;
	@Column(name="Technology") 
	private String technology;
	@Column(name="Startdate") 
	private Date startDate;
	@Column(name="enddate") 
	private Date endDate;
	@Column(name="location") 
	private String location;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name="employee_project_infoo", joinColumns =@JoinColumn(name="pid")
	,inverseJoinColumns =@JoinColumn(name="empId") )
	private List<EmployeePrimaryInfo> primaryInfoForProject;

}
