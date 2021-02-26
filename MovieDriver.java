//The code looks fine. Not necessary to change.
//This code looks good.
import java.sql.*;

public class MovieDriver {

	
	public static void main(String[] args) {
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		
			Statement myStmt = myConn.createStatement();
			
			//ResultSet myRs = myStmt.executeQuery("Select * from people");
			ResultSet myRs = myStmt.executeQuery("Select * from movies");
			
			while (myRs.next()) {
				//System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
				System.out.println(myRs.getString("english_name"));
			}
		
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}


}
