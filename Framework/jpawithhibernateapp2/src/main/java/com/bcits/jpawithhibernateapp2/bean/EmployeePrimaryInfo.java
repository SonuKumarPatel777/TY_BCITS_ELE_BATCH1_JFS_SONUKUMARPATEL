package com.bcits.jpawithhibernateapp2.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp2.manytoone.EmployeeAdressInfo;
import com.bcits.jpawithhibernateapp2.onetoone.EmployeeSecondaryInfo;
import com.bctis.jpawithhibernateapp2.manytomany.ProjectInfo;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
	@Id
	@Column(name="empId") 
	private int empId;
	@Column(name="name")
	private String employeeName;
	@Column(name="mobileno") 
	private Long employeeMbNo;
	@Column(name="offical_mailId") 
	private String employeeofficalMailId;
	@Column(name="Date_Of_Birth") 
	private Date dateOfBirth;
	@Column(name="Date_Of_Joining") 
	private Date dateOfjoining;
	@Column(name="Designation") 
	private String EmployeeDesignation;
	@Column(name="Blood_Group") 
	private String EmployeeBloodGroup;
	@Column(name="Salary") 
	private double employeeSalary;
	@Column(name="DeptId") 
	private int employeeDeptId;
	@Column(name="ManagerId") 
	private int employeeManagerId;
	@Exclude
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
	private EmployeeSecondaryInfo secoInfo;
	@Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryInfo1")
	private List<EmployeeAdressInfo> adressInfos;
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "primaryInfoForProject")
	private  List<ProjectInfo> prInfos;

	 

	 
	
//	public EmployeeSecondaryInfo getSecoInfo() {
//		return secoInfo;
//	}
//
//	public void setSecoInfo(EmployeeSecondaryInfo secoInfo) {
//		this.secoInfo = secoInfo;
//	}
//
//	public int getEmployeeId() {
//		return employee_id;
//	}
//
//	public void setEmployeeId(int employee_id) {
//		this.employee_id = employee_id;
//	}
//
//	public String getEmployeeName() {
//		return employee_name;
//	}
//
//	public void setEmployeeName(String employee_name) {
//		this.employee_name = employee_name;
//	}
//
//	public Long getEmployeeMbNo() {
//		return employee_Mb_No;
//	}
//
//	public void setEmployeeMbNo(Long employee_Mb_No) {
//		this.employee_Mb_No = employee_Mb_No;
//	}
//
//	public String getEmployeeofficalMailId() {
//		return employeeoffical_mailId;
//	}
//
//	public void setEmployeeofficalMailId(String employeeoffical_mailId) {
//		this.employeeoffical_mailId = employeeoffical_mailId;
//	}
//
//	public Date getDateOfBirth() {
//		return date_Of_Birth;
//	}
//
//	public void setDateOfBirth(Date date_Of_Birth) {
//		this.date_Of_Birth = date_Of_Birth;
//	}
//
//	public Date getDateOfjoining() {
//		return date_Of_joining;
//	}
//
//	public void setDateOfjoining(Date date_Of_joining) {
//		this.date_Of_joining = date_Of_joining;
//	}
//
//	public String getEmployeeDesignation() {
//		return Employee_Designation;
//	}
//
//	public void setEmployeeDesignation(String employee_Designation) {
//		Employee_Designation = employee_Designation;
//	}
//
//	public String getEmployeeBloodGroup() {
//		return Employee_Blood_Group;
//	}
//
//	public void setEmployeeBloodGroup(String employee_Blood_Group) {
//		Employee_Blood_Group = employee_Blood_Group;
//	}
//
//	public double getEmployeeSalary() {
//		return employeeSalary;
//	}
//
//	public void setEmployeeSalary(double employeeSalary) {
//		this.employeeSalary = employeeSalary;
//	}
//
//	public int getEmployeeDeptId() {
//		return employee_DeptId;
//	}
//
//	public void setEmployeeDeptId(int employee_DeptId) {
//		this.employee_DeptId = employee_DeptId;
//	}
//
//	public int getEmployeeManagerId() {
//		return employee_ManagerId;
//	}
//
//	public void setEmployeeManagerId(int employee_ManagerId) {
//		this.employee_ManagerId = employee_ManagerId;
//	}

}
