//iteation 5
import java.sql.*;



public class MovieDriver {
	
	
	public static String insertRowSong(String titlesong) throws SQLException {
		int scount =0;
		 String p2 = "";
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt = myConn.createStatement();
        ResultSet myRss = myStmt.executeQuery("Select * from songs ");
        
       
      while (myRss.next()){
        	
    	  String song = myRss.getString("title");
				
			if (song.equals(titlesong)){  
				//System.out.println("Signored");
			 p2 = "Signored";
			scount = scount +1;}	
	}
				if (scount == 0) {
				
				
					String uStmt = "INSERT INTO songs (title) " + "VALUES ( '" + titlesong +"')";
					
	               	myStmt.executeUpdate(uStmt); 
	               
	               	//System.out.println("Screated");
	                 p2 = "Screated";
        	
				}
				return p2;
		
	}
	
	
public static String insertRowMovie(int movie_ID, String nName, String english_name, String yearmade) throws SQLException {
	Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
	Statement myStamt = myCon.createStatement();
	Statement myStmt1 = myCon.createStatement();
    ResultSet myRs1 = myStamt.executeQuery("Select * from movies ");
	int mcount = 0;
	 String p1 = "";
	
	
	while (myRs1.next()) {
	//Integer movieID = myRs1.getInt("movie_id");
	String movieName = myRs1.getString("native_name");
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


public static String MovieSong(String native_name, String year_made, String title) throws SQLException {
	int mscount =0;
	int songID =0;
    int movie_id =0;
    String p ="";
   
	Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
	Statement myStmt2 = Connection.createStatement();
    ResultSet myRss2 = myStmt2.executeQuery("Select * from movie_song ");
    Statement myStmt3 = Connection.createStatement();
    ResultSet myRss3 = myStmt3.executeQuery("Select * from songs ");
    Statement myStmt4 = Connection.createStatement();
    ResultSet myRss4 = myStmt4.executeQuery("Select * from movies ");
   
  
	  while (myRss3.next()){
		    songID = myRss3.getInt("song_id");
		    String stitle = myRss3.getString("title");
		   if (title.equals(stitle)){ break;}}
	  
	  while (myRss4.next()){
		    movie_id = myRss4.getInt("movie_id");
		    String moviename = myRss4.getString("native_name");
			String yearymd = myRss4.getString("year_made");
			String yearmade = yearymd.substring(0,4);
		   if (moviename.equals(native_name) && yearmade.equals(year_made )){ break;}}
	  
	  
	  
	  
	  while (myRss2.next()){
				  int movieid = myRss2.getInt("movie_id");
				  int songid = myRss2.getInt("song_id");
		if (songID == songid && movie_id == movieid){  
		//System.out.println("MSignored" ) ;
		p= "MSignored";
		mscount = mscount +1;
		
		
		}
		   }
	  
	  if (mscount == 0) {
			
			String uStmt = "INSERT INTO movie_song (movie_id, song_id)" + "VALUES ( '" + movie_id +"', '" + songID +"' )";
			
       //	
       
      // System.out.println("MScreated ");
        p = "MScreated ";
       	myStmt2.executeUpdate(uStmt); 
		}
	return p;
   }


	
	public static void main(String[] args) {
		
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			
			Statement myStmt = myConn.createStatement();
			Statement statement = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("Select * from ms_test_data ");
			
			while (myRs.next()) {
			
			String nName = myRs.getString("native_name");
			String yearymd = myRs.getString("year_made");
			String esong = myRs.getString("title");
			Integer movie_ID = 	myRs.getInt("id");
			String year_made = yearymd.substring(0,4);
		
		  String Output =  insertRowSong(esong) + " " + insertRowMovie(movie_ID, nName, nName, year_made) + " " +	MovieSong( nName, year_made, esong) ;
		  System.out.println(Output);
		
			String pupdate = "Update ms_test_data set execution_status= '" + Output + "' where id = '" + movie_ID +"'"  ;
			statement.executeUpdate(pupdate); 
			
			
		}
		}
	          
				 catch (Exception exc) {
					 System.err.println("Got an exception! "); 
			            System.err.println(exc.getMessage()); 
			            
					}
	            
	            }
	
	
	
	
	
	
	
	
}
