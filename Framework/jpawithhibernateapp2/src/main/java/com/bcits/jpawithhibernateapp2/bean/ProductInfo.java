package com.bcits.jpawithhibernateapp2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ProductInfo")
public class ProductInfo implements Serializable {
	@Id
	@Column
	private int ide;
	@Column
	private String name;
	public int getIde() {
		return ide;
	}
	public void setIde(int ide) {
		this.ide = ide;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
