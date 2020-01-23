package com.bcits.springcore.beans;

import lombok.Data;

@Data
public class EmployeeBean {

	private String name;
	private int age;
	private DepartmentBean departmentBean;

	/*
	 * public EmployeeBean(String name, int age, DepartmentBean departmentBean) {
	 * super(); this.name = name; this.age = age; this.departmentBean =
	 * departmentBean; }
	 */

	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public int getAge() { return age; } public void
	 * setAge(int age) { this.age = age; }
	 * 
	 */

}// End of Class
