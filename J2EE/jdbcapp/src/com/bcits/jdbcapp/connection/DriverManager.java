package com.bcits.jdbcapp.connection;

public class DriverManager {
	
	
	private DriverManager() { }
	
	public static Connection getConnection(String str) {
		// Some Business Logic
		Connection ref =null;
		if(str.equals("one")) {
			ref = new ClassA();
		}else {
			ref = new ClassB();
		}
		return ref;
	}//End of myMethod

}//End of Class
