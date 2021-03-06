package com.bcits.springrestjaxb.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name = "Employee-info")
@JsonPropertyOrder({"employee-id","name","department-id"})
@JsonRootName("Employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeInfoBean {

//	@XmlAttribute(name="employee-id")
	@XmlElement(name = "employee-id")
	@JsonProperty("employee-id")
	private Integer empId;
	@XmlElement
	private String name;
	@XmlElement
	private Long mobileNum;
	@XmlElement
	private String officalMailId;
	@XmlElement
	private Date dateOfBirth;
	@XmlElement
	private Date dateOfJoining;
	@XmlElement
	private String designation;
	@XmlElement
	private String bloodGroup;
	@XmlElement
	private Double employeeSalary;
	
	@JsonProperty("department-id")
	@XmlElement(name = "department-id")
	private Integer departmentId;
	
	@XmlElement(name = "manager-id")
	@JsonProperty("manager-id")
	private Integer managerId;
	
	
//	@XmlTransient //To avoid binding 
	@JsonIgnore
	@XmlElement
	private String password;

}// End of class
