package fetch_data_from_database;

import java.util.Scanner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FetchData {
	public static void main(String[] args) throws SQLException  {	
		Scanner sc = new Scanner(System.in);
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Programm is running successfully!!!!!!!!!");
			
			
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc	","root","root");
			
			
//--------------------------------Insert data into database using positional parameters-------------------------------------------------------------------------------------------------------		
			int op;
			do {
				
			
				System.out.print("ENter id:");
				int id=sc.nextInt();
				
				System.out.print("ENter name:");
				String name =sc.next();
				
				System.out.print("ENter course:");
				String course =sc.next();
				
				System.out.print("ENter college:");
				String college=sc.next();
				
				System.out.print("ENter city:");
				String city= sc.next();
				
				System.out.print("ENter phone:");
				long phone= sc.nextLong();
				
				System.out.print("ENter age:");
				int age = sc.nextInt();

				
				PreparedStatement ps  =c.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, course);
				ps.setString(4, college);
				ps.setString(5, city);
				ps.setLong(6, phone);
				ps.setInt(7, age);
				int a =ps.executeUpdate();

				if (a>0) {
					System.out.println("Data inserted successfully ");
					
				}
				else {
					System.out.println("Failed try again!!!" );
				}
				
				System.out.println("Press 1 : TO add more  \n  Press 0 : TO exit");
				op = sc.nextInt();
				
				
			} while (op==1); 
//----------------------------------------END HERE -----------------------------------------------------------------------------------------------------------------------------------------------------
	
			
//========================================FETCH DATA FROM DATABASE USING SQL QUERY====================
			
							/*PreparedStatement ps =c.prepareStatement("select * from student");
							
							ResultSet rs =ps.executeQuery();
							
							
							while(rs.next()) {
								int id1 = rs.getInt("id");
								System.out.print(id1+" ||");
							
								
								String name1 = rs.getString("name");
								System.out.print(name1+" ||");
								
								System.out.print(rs.getString("college") + " ||");
								
								System.out.print(rs.getString("coures")+" ||");
								
								System.out.print(rs.getString("city") + " ||");
								
								System.out.print(rs.getLong("phone") + " ||");
								
								System.out.println(rs.getInt("id"));
								
								System.out.println("======================================================================");
								
							}	*/		
			
			System.out.println("Thank uu");
			c.close();
//========================================END HERE ================================================
	
		} catch (ClassNotFoundException e) {
			
			System.out.println("Not running");
			e.printStackTrace();
		}
		
		
		
		
	}

}
