package com.bcits.jpawithhibernateapp2.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="employee_address_info")
public class EmployeeAdressInfo implements Serializable {
	@EmbeddedId
	private EmolyeeAdressPK addressPK;
	@Column
	private int Houseno;
	@Column
	private String Address1;
	@Column
	private String Address2;
	@Column
	private String Landmark;
	@Column
	private String City;
	@Column
	private long Pincode;
	@MapsId("empId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private EmployeePrimaryInfo primaryInfo1;

}
