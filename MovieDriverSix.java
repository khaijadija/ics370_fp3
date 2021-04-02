//iteation 6
import java.sql.*;



public class MovieDriverSix {
	
	public static String insertRowPeople(String mprstage) throws SQLException {
		int scount =0;
		 String p2 = "";
		 int peopleID=0;
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt = myConn.createStatement();
        ResultSet myRss = myStmt.executeQuery("Select * from people ");
        
       
      while (myRss.next()){
        	
    	  String stage = myRss.getString("stage_name");
    	  stage = stage.replace("'", "\\'");
			if (stage.equals(mprstage)){  
				//System.out.println("Pignored");
			 p2 = "Pignored";
			scount = scount +1;
			}	
	}
				if (scount == 0) {
				
					Statement myStmt1 = myConn.createStatement();
			        ResultSet myRs2 =  myStmt1.executeQuery("SELECT * FROM people ORDER BY people_id DESC LIMIT 1");
			        while (myRs2.next()) {int peopleid = myRs2.getInt("people_id");
			        peopleID = peopleid +1;}
					String uStmt = "INSERT INTO people (people_id, stage_name) " + "VALUES ( '"+ peopleID +"' , '" + mprstage +"')";
					
	               	myStmt.executeUpdate(uStmt); 
	               
	               	//System.out.println("Pcreated");
	                 p2 = "Pcreated";
        	
				}
				return p2;
		
	}
	public static String Moviepeople(String native_name, String year_made, String mprrole,  String stage, String mprscreen) throws SQLException {
		int mscount =0;
		int peopleID =0;
	    int movie_id =0;
	    int movieid=0;
	    int peopleid =0;
	    String p ="";
	   
		Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt2 = Connection.createStatement();
	    ResultSet myRss2 = myStmt2.executeQuery("Select * from movie_people ");
	    Statement myStmt3 = Connection.createStatement();
	    ResultSet myRss3 = myStmt3.executeQuery("Select * from people ");
	    Statement myStmt4 = Connection.createStatement();
	    ResultSet myRss4 = myStmt4.executeQuery("Select * from movies ");
	    
	  
		  while (myRss3.next()){
			    peopleID = myRss3.getInt("people_id");
			    String pstage = myRss3.getString("stage_name");
			    pstage = pstage.replace("'", "\\'");
			   if (stage.equals(pstage)){ break;}}
		  
		  while (myRss4.next()){
			    movie_id = myRss4.getInt("movie_id");
			    String moviename = myRss4.getString("native_name");
			    moviename = moviename.replace("'", "\\'");
				String yearymd = myRss4.getString("year_made");
				String yearmade = yearymd.substring(0,4);
			   if (moviename.equals(native_name) && yearmade.equals(year_made )){ break;}}
		  
		  
		  
		  
		  while (myRss2.next()){
					   movieid = myRss2.getInt("movie_id");
					   peopleid = myRss2.getInt("people_id");
					 String role = myRss2.getString("role");
					 String screen = myRss2.getString("screen_name");
					 screen = screen.replace("'", "\\'");
					
			if ((peopleID == peopleid && movie_id == movieid) && (role.equals(mprrole) && screen.equals(mprscreen))){ 
			//System.out.println("MPignored") ;
			p= "MPignored";
			mscount = mscount +1;
			
			
			}
			   }
		  
		  if (mscount == 0) {
				
				String uStmt = "INSERT INTO movie_people (movie_id, people_id, role, screen_name)" + "VALUES ( '" + movie_id +"', '" + peopleID +"' ,  '" + mprrole +"', '" + mprscreen +"')";
				
	       //	
	       
	      // System.out.println("MPcreated ");
	        p = "MPcreated ";
	       	myStmt2.executeUpdate(uStmt); 
			}
		return p;
	   }

	

	
public static String insertRowMovie(int movie_ID, String nName, String english_name, String yearmade) throws SQLException {
	Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
	Statement myStamt = myCon.createStatement();
	
    ResultSet myRs1 = myStamt.executeQuery("Select * from movies ");
    
	int mcount = 0;
	 String p1 = "";
	
	
	while (myRs1.next()) {
	//Integer movieID = myRs1.getInt("movie_id");
	String movieName = myRs1.getString("native_name");
	movieName = movieName.replace("'", "\\'");
	String yearymd = myRs1.getString("year_made");
	String year_made = yearymd.substring(0,4);
	
	if (nName.equals(movieName) && yearmade.equals(year_made )) {
	//System.out.println("MIgnored");
		  p1 = "MIgnored";
		mcount= mcount +1 ;
      //    myStmt1.executeUpdate(fupdate); 
			}
	
				}
	if (mcount == 0){
	//String processed = "processed, movie created";
	String uStmt = "INSERT INTO movies (native_name, english_name, year_made) " + "VALUES ( '" + nName +"', '" + english_name+ "', "  + yearmade + ")";
  	myStamt.executeUpdate(uStmt); 
	//System.out.println("Mcreated");
	  p1 = "Mcreated";
	//  myStamt.executeUpdate(pupdate); 
	}
	return p1;
}



	
	public static void main(String[] args) {
		
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			
			Statement myStmt = myConn.createStatement();
			Statement statement = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("Select * from mpr_test_data");
			
			while (myRs.next()) {
			int movie_ID = 	myRs.getInt("id");
			String nName = myRs.getString("native_name");
			nName = nName.replace("'", "\\'");
			String yearymd = myRs.getString("year_made");
			String stage = myRs.getString("stage_name");
			stage = stage.replace("'", "\\'");
			String role = myRs.getString("role");
			String screen = myRs.getString("screen_name");
			screen = screen.replace("'", "\\'");
			String year_made = yearymd.substring(0,4);
			
		  String Output =  insertRowPeople(stage) + " " + insertRowMovie(movie_ID, nName, nName, year_made) + " " +Moviepeople( nName, year_made, stage, role, screen) ;
		
		  System.out.println(Output);
		
			String pupdate = "Update mpr_test_data set execution_status= '" + Output + "' where id = '" + movie_ID +"'"  ;
			statement.executeUpdate(pupdate); 
			
			
		}
		}
	          
				 catch (Exception exc) {
					 System.err.println("Got an exception! "); 
			            System.err.println(exc.getMessage()); 
			            
					}
	            
	            }
	
	
	
	
	
	
	
	
}
