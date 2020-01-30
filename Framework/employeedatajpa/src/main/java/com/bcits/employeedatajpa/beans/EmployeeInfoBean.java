package com.bcits.employeedatajpa.beans;

 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@XmlRootElement(name = "Employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("employeeInfoBean")
@JsonPropertyOrder({"empid","name"})
@Data
@Entity
@Table(name = "Employee_primary_info")
public class EmployeeInfoBean {
	
	@Id
	@Column(name = "emp_id")
	@JsonProperty("empid")
	private Integer empId;
	
	@Column
	@JsonProperty("name")
	private String name;
	
	@Column(name = "mobile")
	private Long mobileNum;
	
	@Column(name = "Offical_Mail_Id")
	private String officalMailId;
	
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@Column(name = "doj")
	private Date dateOfjoining;
	
	@Column
	private String designation;
	
	@Column(name = "blood_Group")
	private String bloodGroup;
	
	@Column(name = "employee_Salary")
	private Double employeeSalary;
	
	@Column(name = "department_id")
	private Integer departmentId;
	
	@Column(name = "manager_id")
	private Integer managerId;
	
	@Column
//	@JsonIgnore
	private String password;

}//End of class
