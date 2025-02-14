package com.jsp.jdbcPractice3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbcPractice3.connection.CreateConnection;
import com.jsp.jdbcPractice3.dto.Cricketers;

public class CricketerDao {

	Connection connection = CreateConnection.getConnection();

	private final String INSERTDATA = "INSERT INTO CRICKET (id,name, age,profile,team) VALUES(?,?,?,?,?)";

	private final String DISPLAYDATA = "SELECT * FROM CRICKET";

	private final String UPDATEDATA = "UPDATE CRICKET SET NAME=?,AGE=?,PROFILE=?,TEAM=? WHERE ID =?";

	private final String DELETESTRING = "DELETE FROM CRICKET WHERE ID =?";

//====================================Insert Query============================================	
	public void insertData(int id, String name, int age, String profile, String team) {

		try {
			PreparedStatement ps = connection.prepareStatement(INSERTDATA);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, profile);
			ps.setString(5, team);

			ps.execute();
			System.out.println("Data inserted successfully");

		} catch (SQLException e) {

			System.out.println("Data not inserted");
			e.printStackTrace();
		}

	}
//====================================Insert Query End=========================================	

//====================================Display Query============================================

	public void displayData() {
		List<Cricketers> myCricketer = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYDATA);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String profile = rs.getString("profile");
				String team = rs.getString("team");

				Cricketers cri = new Cricketers(id, name, age, profile, team);

				myCricketer.add(cri);
			}
			for (Cricketers ck : myCricketer) {

				System.out.println("Id : " + ck.getId());
				System.out.println("Name : " + ck.getName());
				System.out.println("Age : " + ck.getAge());
				System.out.println("Profile : " + ck.getProfile());
				System.out.println("Team : " + ck.getTeam());
				System.out.println(
						"---------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
//====================================Display Query End============================================	

//====================================Update Query================================================
	public void updateData(String name, int age, String profile, String team, int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATEDATA);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, profile);
			ps.setString(4, team);
			ps.setInt(5, id);

			int count = ps.executeUpdate();

			if (count > 0) {
				System.out.println("Data Updated successfully");

			} else {
				System.out.println("Data not updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//====================================Update Query End============================================

//====================================Delete Query ================================================
	public void deleteData(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(DELETESTRING);
			ps.setInt(1, id);

			int count = ps.executeUpdate();

			if (count > 0) {
				System.out.println("Data deleted successfully");
			} else {
				System.out.println("Data not deleted.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
//====================================Delete Query End============================================	
	
}
