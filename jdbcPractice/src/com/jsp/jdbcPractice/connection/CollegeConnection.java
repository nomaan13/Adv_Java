package com.jsp.jdbcPractice.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CollegeConnection {
	
	public static Connection getCollegeConnection() {
		
		try {
			//Load and Register Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user ="root";
			String pass ="root";
			
			System.out.println("Connection created successfully.....");
			return DriverManager.getConnection(url,user,pass);
			
		} catch (SQLException e) {
			
			System.out.println("Connection not created.......");
			
			e.printStackTrace();
			
			return null;
		}
		
		
	}
	

}
