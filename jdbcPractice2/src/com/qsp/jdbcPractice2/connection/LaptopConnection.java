package com.qsp.jdbcPractice2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaptopConnection {

	public static Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";

//			driver = new Driver();
//			DriverManager.registerDriver(driver);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection created successfully");
			return con;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Connection not created ");
			return null;
		}

	}
}
