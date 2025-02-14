package jdbcProject3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.cj.protocol.Resultset;

public class First {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int id=17;
		String name= "Henery";
		String course="MTech";
		String	college="Amity";
		long phone = 451230003;
		int age=25;
		
		Class.forName("com.mysql.jdbc.cj.Driver");
		
		Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
		
		PreparedStatement ps = c.prepareStatement("insert into student(?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, course);
		ps.setString(4, college);
		ps.setLong(5, phone);
		ps.setInt(6, age);
		
		
		
		int a = ps.executeUpdate();
		
		if (a>0) {
			System.out.println("INserted successfully");
			
		}
		else {
			System.out.println("Please enter again!!!!!");
		}
		
		
		
		
		ResultSet rs = ps.executeQuery();

	
}
	}