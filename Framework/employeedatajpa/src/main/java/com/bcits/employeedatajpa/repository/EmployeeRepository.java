package com.bcits.employeedatajpa.repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer>{
	
	@Query("from EmployeeInfoBean where empId =:id and password=:pwd")
	public EmployeeInfoBean findByIdAndPassword(int id,  String pwd);

}
