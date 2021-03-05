//The code looks fine. Not necessary to change.
//This code looks good.
//There is no need to change the code and it looks good.
//Here is my comment - DS
import java.sql.*;

// Iteration3
import java.sql.*;
import java.util.Scanner;

public class MovieDriver {

	
	public static void main(String[] args) {
		int mID;
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement myStmt = myConn.createStatement();
			PreparedStatement p = null;
			
			/*
			*/
			//ResultSet myRs = myStmt.executeQuery("Select * from movies join movie_data  where movies.movie_id=movie_data.movie_id ");

			
			Scanner scan1 = new Scanner(System.in);
			Scanner scanR1 = new Scanner(System.in);
			boolean shouldContinue = true;
			while (shouldContinue == true) { 
				System.out.println();
				System.out.println("What procedure would you like to do?");
				System.out.println("Enter 0 if you want a list of the first 1000 movies.");
				System.out.println("Enter 1 if you would like to Add a Movie.");
				System.out.println("Enter 2 if you would like to Delete a Movie.");
				System.out.println("Enter 3 if you would like to list a movie's data.");
				System.out.println("Enter 4 if you would like to update the information of a movie.");
				System.out.println("Enter any other character if you would like to stop.");
	
				int iValue = scan1.nextInt();
				
	            switch (iValue) {
	            case 0:  
	            	ResultSet myRs = myStmt.executeQuery("Select * from movies limit 1000");
	            	while (myRs.next()) {
					System.out.println("[" + myRs.getString("movie_id") + "]" + myRs.getString("english_name"));
				};
	            	//Movie List with ID
	            	break;
	            case 1:  try {  //Add a Movie
	            	mID = 0;
	            	scanR1 = new Scanner(System.in);
	            	System.out.println("Enter the ID of the movie you would like to create:");
	            	mID = scanR1.nextInt();
	            	System.out.println("Enter the Native Name of the movie you would like to create:");
	            	scanR1.nextLine();
	            	String nName = scanR1.nextLine();
	            	System.out.println("Enter the English Name of the movie you would like to create:");
	            	String eName = scanR1.nextLine();
	            	System.out.println("Enter the year of the movie you would like to create:");
	            	int iYear = scanR1.nextInt();
		            String uStmt = "INSERT INTO movies " + "VALUES (" + mID +", '" + nName +"', '" + eName + "', " +iYear + ")";
		            //System.out.println(uStmt);
	            	myStmt.executeUpdate(uStmt); 
	            	
				 }
				 catch (Exception exc) {
					 System.err.println("Got an exception! "); 
			            System.err.println(exc.getMessage()); 
					}
	            	
	            	break;
	            case 2: System.out.println("Enter the ID of the movie you would like to delete:");  //DELETE Movie
				mID = 0;
	            scanR1 = new Scanner(System.in);
					mID = scanR1.nextInt();
	            	try {
						String remove="delete from movies where movie_id=" + mID; 
						p = myConn.prepareStatement(remove); 
						p.execute(); 
	            	}
					catch (Exception exc) {
						System.err.println("Got an exception! "); 
						System.err.println(exc.getMessage()); 
					 }
	            	
	        		break;
	            case 3:  
	            	
	            	myRs = myStmt.executeQuery("Select * from movies join movie_data  where movies.movie_id=movie_data.movie_id ");
	            	while (myRs.next()) {
						System.out.println("[" + myRs.getString("movie_id") + "]" + "\n" +
	            	"English Name: " + myRs.getString("english_name") + "\n" +
	            	"Native Name: " + myRs.getString("native_name") + "\n" +
	            	"Year Made: " + myRs.getString("year_made") + "\n" +
	            	"Tag Line: " + myRs.getString("tag_line") + "\n" +
	            	"Language: " + myRs.getString("language") + "\n" +
	            	"Country: " + myRs.getString("country")	+ "\n" +
	            	"Genre: " + myRs.getString("genre") + "\n" +
	            	"Plot: " + myRs.getString("plot") );}
	            	//View Movie Data
	        		break;
	            case 4: 
	            	scanR1 = new Scanner(System.in);
	            	System.out.println("Enter the ID of the movie you would like to Update:");
	            	mID = scanR1.nextInt();
	            	System.out.println("Enter the Native Name of the movie you would like to Update:");
	            	scanR1.nextLine();
	            	String nName = scanR1.nextLine();
	            	System.out.println("Enter the English Name of the movie you would like to Update:");
	            	String eName = scanR1.nextLine();
	            	System.out.println("Enter the year of the movie you would like to Update:");
	            	int iYear = scanR1.nextInt();
		            String uStmt = "Update movies set native_name='" + nName + "', english_name='" + eName + "', year_made=" + iYear + " where movie_id=" + mID ;
		            try {
						p = myConn.prepareStatement(uStmt); 
						p.execute(); }
					catch (Exception exc) {
						System.err.println("Got an exception! "); 
						System.err.println(exc.getMessage()); 
						}
	            	//Update Movie Data
		            
	        		break;
	
	        		
	            default: shouldContinue = false;
	                break;
	            }
			}
			
		}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		
	}

//	The code looks good.  No necessary changes.
	//This looks good.
}

