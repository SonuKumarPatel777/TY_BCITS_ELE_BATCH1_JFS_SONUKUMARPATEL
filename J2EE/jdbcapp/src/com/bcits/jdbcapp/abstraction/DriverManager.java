package com.bcits.jdbcapp.abstraction;

public class DriverManager {
	
	private DriverManager() {}
	
	public static Connection getConnection(String str) {
		// Some Business Logic
		Connection con =null;
		if(str.equals("one")) {
			con = new ClassX();
		}else {
			con = new ClassY();
		}
		return con;
	}//End of  getConnection method

}//End of Class
