package com.hcl.jdbcPractice5.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeConnection {

	public static Connection getEmployeConnection() {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection established sucessfully....");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Connection not created....");
			e.printStackTrace();
			return null;

		}

	}

}
