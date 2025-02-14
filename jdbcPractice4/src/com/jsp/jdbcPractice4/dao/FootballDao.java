package com.jsp.jdbcPractice4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.jdbcPractice4.connection.FootballConnection;
import com.jsp.jdbcPractice4.dto.Football;

public class FootballDao {
	Connection connection = FootballConnection.getFootballConnection();

	private final String INSERTQUERY = "INSERT INTO FOOTBALL VALUES(?,?,?,?,?)";
	private final String DISPLAYQUERY = "SELECT * FROM FOOTBALL";

	public void insertData(int id, String name, String club, String nation, int jersy) {

		try {
			PreparedStatement ps = connection.prepareStatement(INSERTQUERY);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, club);
			ps.setString(4, nation);
			ps.setInt(5, jersy);

			ps.execute();

			System.out.println("Data Inserted successfully...........");
		} catch (SQLException e) {
			System.out.println("Unable to insert data...........");
			e.printStackTrace();
		}

	}

//================================================================================================
	public ArrayList<Football> displayData() {

		ArrayList<Football> a1 = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYQUERY);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String club = rs.getString("club");
				String nation = rs.getString("nation");
				int jersy = rs.getInt("jersy");

				Football f1 = new Football(id, name, club, nation, jersy);

				a1.add(f1);

				/**
				 * If we directly print f1 then it will print from toString method
				 */
//				 System.out.println(f1);
//				System.out.println("*********************************************************");

			}

			for (Football fb : a1) {
				System.out.print("ID : " + fb.getId());
				System.out.print("|Name  :" + fb.getName());
				System.out.print("|Club  : " + fb.getClub());
				System.out.print("|Nation: " + fb.getNation());
				System.out.print("|Jersy : " + fb.getJersy());
				System.out.println("\n_______________________________________________________________________");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a1;
	}
//================================================================================================

	public ArrayList<Football> getAllData() {

		ArrayList<Football> flist = new ArrayList<Football>();

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYQUERY);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String club = rs.getString("club");
				String nation = rs.getString("nation");
				int jersy = rs.getInt("jersy");

				Football f2 = new Football(id, name, club, nation, jersy);
				flist.add(f2);

			}
			return flist;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

}
