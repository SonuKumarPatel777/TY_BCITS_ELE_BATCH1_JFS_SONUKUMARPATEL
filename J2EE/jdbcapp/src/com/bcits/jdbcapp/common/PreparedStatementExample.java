package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PreparedStatementExample {
	public static void main(String[] args) {
		Connection con= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			// 1.Load the Driver

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Get the DB Connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/Employee_managment_info";
			 con = DriverManager.getConnection(dbUrl, "root", "root");
			//3.Issue the Queries via Connection
			String query=" select * from Employee_Primary_info "
					     + "where empId=? ";
			 pstmt = con.prepareStatement(query);
			pstmt.setInt( 1, Integer.parseInt(args[0]));
		    rs = pstmt.executeQuery();
			
			// 4."Process the Results" returned by "SQL Queries"
			if (rs.next()) {
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
			}else {
				System.err.println(" Employee Data Not Found in DB !!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Close all the JDBC objects
			try {
				if (con != null) {
					con.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of inner try-catch block
	}// End of Main
}// End of Class
