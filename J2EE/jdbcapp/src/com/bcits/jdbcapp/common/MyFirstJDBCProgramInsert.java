package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBCProgramInsert {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			// Load the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// get the DB connection " via Driver"
			String str = "jdbc:mysql://localhost:3306/Employee_managment_info?" 
			             + "user=root&password=root";
			con = DriverManager.getConnection(str);
			String query = "insert into Employee_Primary_info values"
					+ "(114,'Subrat Pradhan',7752078542,'subratpradhan12@gmail.com',"
					+ "'1992-10-10','2017-12-12','developer','B+',25000,40,1004)";
			stmt = con.createStatement();
			int noRow = stmt.executeUpdate(query);
			// Process the result return by SQl Queris
			System.out.println("Number of row affected" + noRow);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // End of Finally block

	}// End the main method

}// End the Class
