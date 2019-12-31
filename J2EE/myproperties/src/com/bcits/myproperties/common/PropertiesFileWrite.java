package com.bcits.myproperties.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileWrite {
	public static void main(String[] args) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("dbinfo.properties");
			Properties properties = new Properties();
			properties.setProperty("diveNm", "com.mysql.jdbc.Driver");
			properties.setProperty("dbURl", "jdbc:mysql://localhost:3306/Employee_managment_info?");
			properties.setProperty("user", "root");
			properties.setProperty("password", "root");
			try {
				properties.store(fileOutputStream, "DB detail");
				System.out.println("File Created");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}// End of the Method

}// End of Class
