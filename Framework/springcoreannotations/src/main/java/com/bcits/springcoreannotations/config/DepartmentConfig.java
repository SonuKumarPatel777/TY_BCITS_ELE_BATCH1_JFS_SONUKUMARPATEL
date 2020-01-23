package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.DepartmentBean;

@Configuration
public class DepartmentConfig {
	@Bean(name="dev")
	public DepartmentBean getDeptDev() {
		DepartmentBean departmentBean =new DepartmentBean();
		departmentBean.setDepId(10111);
		departmentBean.setDeptName("Dev");
		
		return departmentBean;
		
	}//End of getDeptDev()
	
	@Bean(name="hr")
//	@Primary
	public DepartmentBean getDeptHR() {
		DepartmentBean departmentBean =new DepartmentBean();
		departmentBean.setDepId(10222);
		departmentBean.setDeptName("HR");
		
		return departmentBean;
		
	}//End of getDeptHR()
	
	@Bean(name="acc")
	public DepartmentBean getDeptAccount() {
		DepartmentBean departmentBean =new DepartmentBean();
		departmentBean.setDepId(10333);
		departmentBean.setDeptName("Account");
		
		return departmentBean;
		
	}//End of getDeptAccount()

}//End of class
