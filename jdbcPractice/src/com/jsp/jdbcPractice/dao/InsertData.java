package com.jsp.jdbcPractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.jdbcPractice.connection.CollegeConnection;
import com.jsp.jdbcPractice.dto.College;

public class InsertData {

	public static void insertData(int id, String name, String clgName, String email, String address, String type) {

		College clg = new College();

		Connection connection = CollegeConnection.getCollegeConnection();

		// Create SQL query(Create Statements)

		String query = "INSERT INTO college (id, name, email, address, type) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, type);

			ps.execute();
			System.out.println("Data inserted successfully........");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
