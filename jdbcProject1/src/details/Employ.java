package details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Employ {
	public static void main(String[] args) throws SQLException {		

//==========================Step1: 	Load and Register Driver============================================================
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			System.out.println("Run Successfully!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Does not executed");
			e.printStackTrace();

		}
//===========================STEP1: Ends here===========================================================================

//===========================STEP1:	Create Connection===================================================================
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employ", "root", "root");

//===========================STEP2:	Ends Here==========================================================================

//===========================STEP3:	Create Statement===================================================================	

//		PreparedStatement ps = con
//				.prepareStatement("insert into employdetail values('116','Lee','HR','HP','Kolkata','9124567891' )");
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYDETAIL");
//---------------------------UPDATE VALUE IN DATABASE------------------------------------------------------------------
		/*
		 * long contact = 1852360001; 
		 * int id = 107;
		 *  PreparedStatement ps =con.prepareStatement("update employdetail set contact=? where id =?");
		 * ps.setLong(1, contact); 
		 * ps.setInt(2, id);
		 * int i = ps.executeUpdate();
		 * //------------------------CHECK UPDATED VALUE------------------------------------------------------------------ 
		 * if (i>0) { System.out.println("Value updated");
		 * 
		 * } else { System.out.println("Value not updated"); }
		 */
		// --------------------------CHECK COMPLETE---------------------------------------------------------------------
       //---------------------------UPDATION COMPLETE HERE--------------------------------------------------------------------

//**********************Using Positional Parameters**************************************
		/*
		 * int id = 121; String name = "Donald"; String pos ="Fresher"; String
		 * company="Dell" ; String city="Banglore"; long contact= 1072580000;
		 * 
		 * PreparedStatement ps
		 * =con.prepareStatement("insert into employdetail values(?,?,?,?,?,?)");
		 * ps.setInt(1, id); ps.setString(2, name); ps.setString(3, pos);
		 * ps.setString(4, company); ps.setString(5, city); ps.setLong(6, contact);
		 */
//**********************Using Positional Parameters**************************************	

	/*	int a = ps.executeUpdate();
		if (a > 0) {
			System.out.println("Value inserted Successfully ");

		} else {
			System.out.println("Value not inserted ");
		}
*/
		
		  ResultSet rs= ps.executeQuery();
//===========================Step3:	End Here===========================================================================

		con.close();

	}
}
