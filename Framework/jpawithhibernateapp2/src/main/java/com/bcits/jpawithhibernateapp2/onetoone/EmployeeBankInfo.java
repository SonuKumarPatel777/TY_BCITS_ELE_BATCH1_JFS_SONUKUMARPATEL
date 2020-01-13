package com.bcits.jpawithhibernateapp2.onetoone;

import java.io.Serializable;

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
@Table(name="Employee_Bank_info")
public class EmployeeBankInfo implements Serializable  {
	@Id
	private int empId;
	@Column(name="Accountno")
	private Long accountno;
	@Column(name="Bank_name")
	private String bankName;
	@Column(name="Branchname")
	private String branchname;
	@Column(name="IFSC_Code")
	private String ifscCode;
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
	public Long getAccountno() {
		return accountno;
	}
	public void setAccountno(Long accountno) {
		this.accountno = accountno;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	

}
