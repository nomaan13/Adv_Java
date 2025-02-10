package com.jsp.jdbcPractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.jdbcPractice.connection.CollegeConnection;
import com.jsp.jdbcPractice.dto.College;

public class UpdateData {
	College clgCollege = new College();
	
	public static void updateData() {
		Connection connection = CollegeConnection.getCollegeConnection();
		final String query="UPDATE  COLLEGE SET NAME = ? WHERE ID = ?";
		
		try {
			PreparedStatement ps   = connection.prepareStatement(query);

			ps.setString(1,"a");
			ps.setInt(2, 123);
				
			ps.executeUpdate();
			System.out.println("Data updated successfully");
			connection.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}	}}