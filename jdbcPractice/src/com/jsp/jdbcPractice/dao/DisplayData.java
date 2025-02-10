package com.jsp.jdbcPractice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jsp.jdbcPractice.connection.CollegeConnection;
import com.jsp.jdbcPractice.dto.College;

public class DisplayData {

	public static ArrayList<College> displayData() {
		
		ArrayList<College> clgDetails = new ArrayList<College>();
		Connection connection = CollegeConnection.getCollegeConnection();
		String query = "SELECT * FROM COLLEGE";
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				System.out.println("=====================================================================");

				System.out.println("College Id : " + rs.getInt("id"));

				System.out.println("College Name : " + rs.getString("name"));

				System.out.println("College Email : " + rs.getString("email"));

				System.out.println("College City : " + rs.getString("address"));

				System.out.println("College Type:  " + rs.getString("type"));

				College cg = new College(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				clgDetails.add((College) cg);
				
				
				System.out.println("\n=====================================================================");
			}

		
			connection.close();
			return clgDetails;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
}
