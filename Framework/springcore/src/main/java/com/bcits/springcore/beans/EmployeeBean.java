package com.bcits.springcore.beans;

import lombok.Data;

@Data
public class EmployeeBean {

	private String name;
	private int age;
	private DepartmentBean departmentBean;

	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public int getAge() { return age; } public void
	 * setAge(int age) { this.age = age; }
	 * 
	 */

}// End of Class
