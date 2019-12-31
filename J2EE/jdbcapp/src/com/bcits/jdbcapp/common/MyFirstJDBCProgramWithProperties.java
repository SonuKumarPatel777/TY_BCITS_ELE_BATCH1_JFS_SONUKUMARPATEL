package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProgramWithProperties {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			// 1. Load the "Driver"
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			// 2. Get the "DB connection" via "Driver"
			String dbUrl = "jdbc:mysql://localhost:3306/Employee_managment_info";
			
			FileInputStream fil = new FileInputStream("db.properties");
			Properties porp= new Properties();
			porp.load(fil);
			
			con = DriverManager.getConnection(dbUrl,porp);
			// 3.Issue "SQL Queries" via "Connection"
			String query = "select * from Employee_primary_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			// 4."Process the Results" returned by "SQL Quries"
			while (rs.next()) {
				int employeeID = rs.getInt("empId");
				String employeeNM = rs.getString("name");
				Long employeeMbNo = rs.getLong("mobileno");
				String employeeoffical_mailId = rs.getString("offical_mailId");
				Date Date_Of_Birth = rs.getDate("Date_Of_Birth");
				Date Date_Of_joining = rs.getDate("Date_Of_Joining");
				String Employee_Designation = rs.getString("Designation");
				String Employee_Blood_Group = rs.getString("Blood_Group");
				double employeeSalary = rs.getDouble("Salary");
				int employee_DeptId = rs.getInt("DeptId");
				int employee_ManagerId = rs.getInt("ManagerId");

				System.out.println("Employee ID====>" + employeeID);
				System.out.println("Employee name==>" + employeeNM);
				System.out.println("employeeMbNo====>" + employeeMbNo);
				System.out.println("employeeoffical_mailId====>" + employeeoffical_mailId);
				System.out.println("employee Date_Of_Birth====>" + Date_Of_Birth);
				System.out.println("Date_Of_joining===>" + Date_Of_joining);
				System.out.println("Employee_Designation===>" + Employee_Designation);
				System.out.println("Employee_Blood_Group===>" + Employee_Blood_Group);
				System.out.println("employeeSalary===>" + employeeSalary);
				System.out.println("employee_DeptId====>" + employee_DeptId);
				System.out.println("employee_ManagerId====>" + employee_ManagerId);
				System.out.println("******************************************");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5."Close All the JDBC Objects"
			try {
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} // end of inner try-catch block
		}

	}// End of main

}
