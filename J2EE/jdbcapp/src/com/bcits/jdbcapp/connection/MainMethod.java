package com.bcits.jdbcapp.connection;

public class MainMethod {

	public static void main(String[] args) {
		String str="two";
		Connection ref = DriverManager.getConnection(str);
		ref.print();
		
	}//End of Main

}//End of Class
