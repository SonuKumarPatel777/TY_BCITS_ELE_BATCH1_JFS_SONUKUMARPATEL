package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class InsertProgramProperty {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream("dbinfo.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			String drive = properties.getProperty("diveNm");
			// 1. Load the "Driver"
			/*
			 * Driver driverRef = new Driver(); DriverManager.registerDriver(driverRef);
			 */
			Class.forName(drive).newInstance();
			// 2. Get the "DB connection" via "Driver"
			// String dbUrl =
			// "jdbc:mysql://localhost:3306/Employee_managment_info?user=root&password=root";
			// String dbUrl = "jdbc:mysql://localhost:3306/Employee_managment_info?";
			// con = DriverManager.getConnection(dbUrl);
			con = DriverManager.getConnection(properties.getProperty("dbURl"), properties.getProperty("user"),
					properties.getProperty("password"));
			
			// 3.Issue "SQL Queries" via "Connection"
			String query = " select * from Employee_primary_info" + " where empId=101 ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			// 4."Process the Results" returned by "SQL Quries"
			while (rs.next()) {
				int employee_id = rs.getInt("empId");
				String employee_name = rs.getString("name");
				Long employee_Mb_No = rs.getLong("mobileno");
				String employeeoffical_mailId = rs.getString("offical_mailId");
				Date date_Of_Birth = rs.getDate("Date_Of_Birth");
				Date date_Of_joining = rs.getDate("Date_Of_Joining");
				String Employee_Designation = rs.getString("Designation");
				String Employee_Blood_Group = rs.getString("Blood_Group");
				double employeeSalary = rs.getDouble("Salary");
				int employee_DeptId = rs.getInt("DeptId");
				int employee_ManagerId = rs.getInt("ManagerId");

				System.out.println("employee_id======>" + employee_id);
				System.out.println("employee_name=====>" + employee_name);
				System.out.println("employee_mobile_no====>" + employee_Mb_No);
				System.out.println("employeeoffical_mailId====>" + employeeoffical_mailId);
				System.out.println("employee_Date_Of_Birth===>" + date_Of_Birth);
				System.out.println("employee_Date_Of_joining====>" + date_Of_joining);
				System.out.println("Employee_Designation====>" + Employee_Designation);
				System.out.println("Employee_Blood_Group====>" + Employee_Blood_Group);
				System.out.println("employeeSalary=====>" + employeeSalary);
				System.out.println("employee_DeptId=====>" + employee_DeptId);
				System.out.println("employee_ManagerId====>" + employee_ManagerId);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close all the JDBC objects
			try {
				if (con != null) {
					con.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} // End of inner try-catch block
		} // End of finally
	}// End of main

}
