package com.bcits.jpawithhibernateapp2.test;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernateapp2.onetoone.EmployeeSecondaryInfo;

public class Test1OneToOne {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transation = null;
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		test.setEmpId(12);
		test.setEmployeeName("Sunil");
		test.setEmployeeofficalMailId("sunil141@gmail.com");
		test.setEmployeeMbNo(9064567342l);
		test.setDateOfBirth(Date.valueOf("1995-11-11"));
		test.setDateOfjoining(Date.valueOf("2018-11-10"));
		test.setEmployeeDesignation("HR");
		test.setEmployeeBloodGroup("O+");
		test.setEmployeeSalary(54000);
		test.setEmployeeDeptId(40);
		test.setEmployeeManagerId(1002);

		EmployeeSecondaryInfo secondaryInfo = new EmployeeSecondaryInfo();

		secondaryInfo.setPersonal_mailId("sunilbro@gmail.com");
		secondaryInfo.setGender("Male");
		secondaryInfo.setAge(24);
		secondaryInfo.setNationality("Indian");
		secondaryInfo.setIsmarried("No");
		secondaryInfo.setGov_ID("PANCard");
		secondaryInfo.setGurdian_name("deepa");
		secondaryInfo.setGurdian_contact_no(7845129875l);
		secondaryInfo.setJob_Location("Cuttack");
		secondaryInfo.setPrimaryInfo(test);
		test.setSecoInfo(secondaryInfo);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transation = manager.getTransaction();
			transation.begin();
			// manager.persist(secondaryInfo);
			EmployeeSecondaryInfo secondaryInfo2 = manager.find(EmployeeSecondaryInfo.class, 101);
			System.out.println(secondaryInfo2.getAge());
			System.out.println(secondaryInfo2.getPrimaryInfo().getEmployeeSalary());

			System.out.println("Record Retrive");
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transation.rollback();
		} finally {
			manager.close();

		} // End of Finally

	}

}
