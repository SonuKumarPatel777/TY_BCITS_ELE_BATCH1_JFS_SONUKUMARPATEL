package com.bcits.jpawithhibernateapp2.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;
@Entity
@Table(name="employee_secondary_info")
public class EmployeeSecondaryInfo {
	@Id
	private int empId;
	@Column(name="Personal_mailId")
	private String personal_mailId;
	@Column(name="Gender")
	private String gender;
	@Column(name="Age")
	private int age;
	@Column(name="Nationality")
	private String nationality;
	@Column(name="Ismarried")
	private String ismarried;
	@Column(name="Gov_ID")
	private String gov_ID;
	@Column(name="Gurdian_name ")
	private String gurdian_name;
	@Column(name="Gurdian_contact_no")
	private long gurdian_contact_no;
	@Column(name="Job_Location")
	private String job_Location;
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private EmployeePrimaryInfo primaryInfo;
	 
	 
	public EmployeePrimaryInfo getPrimaryInfo() {
		return primaryInfo;
	}
	public void setPrimaryInfo(EmployeePrimaryInfo primaryInfo) {
		this.primaryInfo = primaryInfo;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPersonal_mailId() {
		return personal_mailId;
	}
	public void setPersonal_mailId(String personal_mailId) {
		this.personal_mailId = personal_mailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIsmarried() {
		return ismarried;
	}
	public void setIsmarried(String ismarried) {
		this.ismarried = ismarried;
	}
	public String getGov_ID() {
		return gov_ID;
	}
	public void setGov_ID(String gov_ID) {
		this.gov_ID = gov_ID;
	}
	public String getGurdian_name() {
		return gurdian_name;
	}
	public void setGurdian_name(String gurdian_name) {
		this.gurdian_name = gurdian_name;
	}
	public long getGurdian_contact_no() {
		return gurdian_contact_no;
	}
	public void setGurdian_contact_no(long gurdian_contact_no) {
		this.gurdian_contact_no = gurdian_contact_no;
	}
	public String getJob_Location() {
		return job_Location;
	}
	public void setJob_Location(String job_Location) {
		this.job_Location = job_Location;
	}
	

}
