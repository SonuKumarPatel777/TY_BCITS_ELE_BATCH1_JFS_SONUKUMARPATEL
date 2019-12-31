package com.bcits.jdbcapp.abstraction;

 
public class MainMethod {
	
	public static void main(String[] args) {
		String dbUrl="one";
		Connection con = DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement();
		stmt.method();
		
		
		
	}//End of main Method

}//End of Class
