package com.jsp.jdbcPractice4.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FootballConnection {
	
	public static Connection getFootballConnection() {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =   DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Created successfully.................");
			return con;
			
		} catch (ClassNotFoundException  | SQLException e) {
			
			e.printStackTrace();
			System.out.println("Connection not created!!!!!!!!!!!!!!!");
			return null;
		}
}

}
