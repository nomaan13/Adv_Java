package com.jsp.jdbcPractice3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CreateConnection {

	public static Connection getConnection() {

		/*try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pass = "root";

			System.out.println("Connection created successfully");
			return DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			System.out.println("Connection not created");
			e.printStackTrace();
			return null;
		}*/
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Created successfully");
			
			
			
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String pass="root";
			
			Connection con =DriverManager.getConnection(url, user, pass);
			
			return con;
			
		} catch (ClassNotFoundException |SQLException e) {
			System.out.println("Connection not created");
			e.printStackTrace();
			return null;
		}

	}
}
