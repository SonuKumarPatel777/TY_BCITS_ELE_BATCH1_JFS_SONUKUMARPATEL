package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileReader {
	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("dbinfo.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			System.out.println("DriverName-----" + properties.getProperty("diveNm"));
			System.out.println("DBUrl----------" + properties.getProperty("dbURl"));
			System.out.println("User-----------" + properties.getProperty("user"));
			System.out.println("Password-------" + properties.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// End of Method

}// End of Class
