package com.bcits.jpawithhibernateapp2.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Employee_primary_info")
public class EmployeeInfo implements Serializable {
	@Id
	@Column(name="empId")
	 private int employee_id; 
	@Column(name="name")
	 private String employee_name;
	@Column(name="mobileno")
	 private Long employee_Mb_No ;
	@Column(name="offical_mailId")
	 private String employeeoffical_mailId;
	@Column(name="Date_Of_Birth")
	 private Date date_Of_Birth ;
	@Column(name="Date_Of_Joining")
	 private Date date_Of_joining ; 
	@Column(name="Designation")
	 private String Employee_Designation; 
	@Column(name="Blood_Group")
	 private String Employee_Blood_Group ;
	@Column(name="Salary")
	 private double employeeSalary ;
	@Column(name="DeptId")
	 private int employee_DeptId ;
	@Column(name="ManagerId")
	 private int employee_ManagerId ; 

	 
	 
	 public int getEmployeeId() {
		return employee_id;
	}
	 public void setEmployeeId(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployeeName() {
		return employee_name;
	}
	public void setEmployeeName(String employee_name) {
		this.employee_name = employee_name;
	}
	public Long getEmployeeMbNo() {
		return employee_Mb_No;
	}
	public void setEmployeeMbNo(Long employee_Mb_No) {
		this.employee_Mb_No = employee_Mb_No;
	}
	public String getEmployeeofficalMailId() {
		return employeeoffical_mailId;
	}
	public void setEmployeeofficalMailId(String employeeoffical_mailId) {
		this.employeeoffical_mailId = employeeoffical_mailId;
	}
	public Date getDateOfBirth() {
		return date_Of_Birth;
	}
	public void setDateOfBirth(Date date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}
	public Date getDateOfjoining() {
		return date_Of_joining;
	}
	public void setDateOfjoining(Date date_Of_joining) {
		this.date_Of_joining = date_Of_joining;
	}
	public String getEmployeeDesignation() {
		return Employee_Designation;
	}
	public void setEmployeeDesignation(String employee_Designation) {
		Employee_Designation = employee_Designation;
	}
	public String getEmployeeBloodGroup() {
		return Employee_Blood_Group;
	}
	public void setEmployeeBloodGroup(String employee_Blood_Group) {
		Employee_Blood_Group = employee_Blood_Group;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeDeptId() {
		return employee_DeptId;
	}
	public void setEmployeeDeptId(int employee_DeptId) {
		this.employee_DeptId = employee_DeptId;
	}
	public int getEmployeeManagerId() {
		return employee_ManagerId;
	}
	public void setEmployeeManagerId(int employee_ManagerId) {
		this.employee_ManagerId = employee_ManagerId;
	}
	 
}
