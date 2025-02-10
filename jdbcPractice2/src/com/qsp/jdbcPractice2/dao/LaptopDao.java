package com.qsp.jdbcPractice2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qsp.jdbcPractice2.connection.LaptopConnection;
import com.qsp.jdbcPractice2.dto.LaptopDto;

public class LaptopDao {

	LaptopDto laptopDto = new LaptopDto();
	Connection conn = LaptopConnection.getConnection();

	private static final String INSERTQUERY = "INSERT INTO LAPTOP (id, company, ram, color, processor) VALUES(?,?,?,?,?)";
	private static final String DISPLAYDATA = "SELECT * FROM LAPTOP";
	private static final String UPDATEQUERY = "UPDATE LAPTOP SET RAM=?, PROCESSOR=? WHERE ID=?";
	private static final String UPDATEALLQUERY = "UPDATE LAPTOP SET COMPANY=? , RAM=? , COLOR=?,PROCESSOR=? WHERE ID =?";
	private static final String DELETEQUERY = "DELETE FROM LAPTOP WHERE ID =?";

//=================================== DISPLAY QUERY====================================================
	public void displayData() {
		try {
			PreparedStatement ps = conn.prepareStatement(DISPLAYDATA);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				System.out.println("ID :" + rs.getInt("id"));
				System.out.println("Company: " + rs.getString("company"));
				System.out.println("Ram: " + rs.getString("ram"));
				System.out.println("Color: " + rs.getString("color"));
				System.out.println("Processor: " + rs.getString("processor"));
				System.out.println("====================================================");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
//=================================== END DISPLAY QUERY================================================
//	==================================  Insert Data Query====================================================

	public void insertData(int id, String company, int ram, String color, String processor) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(INSERTQUERY);
			ps.setInt(1, id);
			ps.setString(2, company);
			ps.setInt(3, ram);
			ps.setString(4, color);
			ps.setString(5, processor);

			ps.execute();
			System.out.println("Data Inserted successfully");
		

		} catch (SQLException e) {
			System.out.println("Data Not Inserted ");
			e.printStackTrace();
		}

	}
//===================================END INSERT DATA QUERY============================================

//	==================================UPDATE DATA QUERY================================================	
	public void updateData(int ram, String processor, int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATEQUERY);
			ps.setInt(1, ram);
			ps.setString(2, processor);
			ps.setInt(3, id);

			int count = ps.executeUpdate();

			if (count != 0) {
				System.out.println("Data updated successfully..");

			} else {
				System.out.println("Data not updated ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//================================== END UPDATE DATA QUERY============================================
//================================== UPDATE ALL QUERY==================================================	

	public void updateAll(String comp, int ram, String color, String processor, int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATEALLQUERY);

			ps.setString(1, comp);
			ps.setInt(2, ram);
			ps.setString(3, color);
			ps.setString(4, processor);
			ps.setInt(5, id);

			int count = ps.executeUpdate();

			if (count > 0) {
				System.out.println("Data updated successfully..");

			} else {
				System.out.println("Data not updated..");
			}

			
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
//=============================END UPDATE ALL QUERY===============================================

//=============================DELETE QUERY=======================================================
	public void deleteData(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(DELETEQUERY);

			ps.setInt(1, id);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Data deleted successfully");

			} else {
				System.out.println("Unable to Delete Data");
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//==========================END DELETE QUERY======================================================	

	
	
//==============================CLOSE CONNECTIONS=================================================
	
}
