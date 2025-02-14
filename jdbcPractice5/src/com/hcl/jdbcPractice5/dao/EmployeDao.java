package com.hcl.jdbcPractice5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hcl.jdbcPractice5.connection.EmployeConnection;
import com.hcl.jdbcPractice5.dto.Employe;

public class EmployeDao {
	Connection connection = EmployeConnection.getEmployeConnection();
	Employe e1 = new Employe();

	private final String INSERTQURY = "INSERT INTO EMPLOYE (ID, NAME, PROFILE, SAL, DOJ, COMPANY) VALUES (?,?,?,?,?,?)";
	private final String UPDATEQUERY = "UPDATE EMPLOYE  SET NAME=?, PROFILE =?,SAL=?,DOJ=?,COMPANY=? WHERE ID = ? ";
	private final String DELETEQUERY = "DELETE FROM EMPLOYE WHERE ID =?";
	private final String DISPLAYDATAQUERY = "SELECT * FROM EMPLOYE";

//=================================INSERT DATA METHOD==========================================	
	public void insertData(int id, String name, String profile, Double sal, LocalDate doj, String company) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERTQURY);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, profile);
			ps.setDouble(4, sal);
			ps.setDate(5, Date.valueOf(doj));
			ps.setString(6, company);

			int n = ps.executeUpdate();

			if (n > 0) {
				System.out.println("**********************Data inserted successfully***************** ");
			} else {
				System.out.println("Unable to insert data!!!!");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

//=================================INSERT DATA METHOD END======================================
//=================================UPDATE DATA METHOD==========================================	
	public void updateData(int id, String name, String profile, double sal, LocalDate doj, String company) {
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATEQUERY);
			
			ps.setString(1, name);
			ps.setString(2, profile);
			ps.setDouble(3, sal);
			ps.setDate(4, Date.valueOf(doj));
			ps.setString(5, company);
			ps.setInt(6, id);

			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Data updated successfully.......");
			} else {
				System.out.println("Unable to update data.........");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

//=================================UPDATE DATA METHOD END=====================================
//=================================DELETE DATA METHOD==========================================	
	public void deleteData(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(DELETEQUERY);
			ps.setInt(1, id);

			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Data Deleted successfully......");
			} else {
				System.out.println("Unable to delete data.....");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

//=================================DELETE DATA METHOD END=====================================
//=================================DISPLAY DATA METHOD  ========================================
	public void displayData() {

		List<Employe> employes = new ArrayList<Employe>();

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYDATAQUERY);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String profile = rs.getString("profile");
				Double sal = rs.getDouble("sal");
				LocalDate date = rs.getDate("doj").toLocalDate();
				String company = rs.getString("company");

				Employe emp = new Employe();
				emp.setId(id);
				emp.setName(name);
				emp.setProfile(profile);
				emp.setSal(sal);
				emp.setDoj(date);
				emp.setCompany(company);

				employes.add(emp);

			}
			for (Employe emp1 : employes) {
				System.out.println("ID : " + emp1.getId());
				System.out.println("Name : " + emp1.getName());
				System.out.println("Profile : " + emp1.getProfile());
				System.out.println("Salary : " + emp1.getSal());
				System.out.println("Date of Joining : " + emp1.getDoj());
				System.out.println("Company  : " + emp1.getCompany());
				System.out.println("______________________________________________________________________");

			}
//			System.out.println(employes);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//=================================DISPLAY DATA METHOD END=====================================
//=================================GET ALL DATA=====================================
	public ArrayList<Employe> getAllData() {
		ArrayList<Employe> employes = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYDATAQUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String profile = rs.getString("profile");
				Double sal = rs.getDouble("sal");
				LocalDate date = rs.getDate("doj").toLocalDate();
				String company = rs.getString("company");

				Employe e2 = new Employe();
				e2.setName(name);
				e2.setId(id);
				e2.setProfile(profile);
				e2.setSal(sal);
				e2.setDoj(date);
				e2.setCompany(company);

				employes.add(e2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employes;

	}
//=================================GET ALL DATA END=====================================
//=================================sortByName METHOD============================================

	public void sortByName() {
	}
//=================================sortByName METHOD END========================================	

//=================================sortBySalary METHOD============================================	

	public void sortBySalary() {
	}
//=================================sortBySalary END================================================	
//=================================sortByDateOfJoining METHOD======================================

	public void sortByDateOfJoining() {
	}
//=================================sortByDateOfJoining END==========================================	
//================================= sortByCompany METHOD==========================================	

	public void sortByCompany() {
	}
//================================= sortByCompany END==============================================

}
