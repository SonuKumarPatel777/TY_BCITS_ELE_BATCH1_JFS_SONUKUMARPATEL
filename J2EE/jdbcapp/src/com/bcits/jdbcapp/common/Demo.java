package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			// Load the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// get the connection via Driver
			String str = "jdbc:mysql://localhost:3306/Demo?"
			+ "user=root&password=root";
			con = DriverManager.getConnection(str);
			String qu =  "alter table demo_table add address1 varchar(300)";
			stmt = con.createStatement();
			int noRow = stmt.executeUpdate(qu);
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
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}//End of Finally

	}// End of Method

}
