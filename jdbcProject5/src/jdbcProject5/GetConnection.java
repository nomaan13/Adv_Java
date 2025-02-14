package jdbcProject5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetConnection {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("RUN!!!!!!!!!!");
			
			String url= "jdbc:mysql://localhost:3306/costumer";
			String user = "root";
			String pass ="root";
			Connection con =  DriverManager.getConnection("url", "user", "pass");
			
			
			PreparedStatement ps= con.prepareStatement("");
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
	}

}
