package jdbcProject6.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarPicConnection {
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/car"; 
		String user="root";
		String pass="root";
		String img_path = "D:\\Car\\car3.jpg";
		String query = " INSERT INTO CARPIC (IMAGEDATA) 	VALUES (?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully..........");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not loaded ...................");
			e.printStackTrace();
		}
		
		try {
			Connection con =DriverManager.getConnection(url,user,pass);
			System.out.println("Connection established successfully............");
			FileInputStream f1 = new FileInputStream(img_path);
			byte[] img_data = new byte[f1.available()];
			f1.read(img_data);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setBytes(1, img_data);
			int n = ps.executeUpdate();
			if (n>0) {
				System.out.println("Photo inserted successfully.......");
				
			}
			else {
				System.out.println("Photo not inserted..................");
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
