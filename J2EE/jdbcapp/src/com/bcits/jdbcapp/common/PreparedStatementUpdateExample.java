package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUpdateExample {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// Load the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// get the connection via Driver
			String str = "jdbc:mysql://localhost:3306/Employee_managment_info?"
			+ "user=root&password=root";
			con = DriverManager.getConnection(str);
			String query = " update Employee_primary_info set name= "
					+ " 'Sambrant Nayak' where empId=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt( 1, Integer.parseInt(args[0]));
			int noRow = pstmt.executeUpdate();
			System.out.println(noRow + " row update");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 5."Close All the JDBC Objects"
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}//End of Finally

	}// End of Method


}//End of Class
