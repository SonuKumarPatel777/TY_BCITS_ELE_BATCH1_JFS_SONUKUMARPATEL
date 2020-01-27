package com.bcits.springmvc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Employee_primary_info")
public class EmployeeInfoBean implements Serializable{
	
	@Id
	@Column(name = "emp_id")
	private Integer empId;
	@Column
	private String name;
	@Column(name = "mobile")
	private Long mobileNum;
	@Column(name = "Offical_MailId")
	private String officalMailId;
	@Column(name = "dob")
	private Date dateOfBirth;
	@Column(name = "doj")
	private Date dateOfjoining;
	@Column
	private String designation;
	@Column(name = "blood_Group")
	private String bloodGroup;
	@Column
	private Double employeeSalary;
	@Column(name = "department_id")
	private Integer departmentId;
	@Column(name = "manager_id")
	private Integer managerId;
	@Column
	private String password;

}//End of class
