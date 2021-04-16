//iteation 6
import java.io.File;
import java.sql.*;
import java.util.Scanner;



public class MovieDriver8 {
	//**************************************SONG*********************************************
	public static String insertRowSong(String titlesong) throws SQLException {
		int scount =0;
		 String p2 = "";
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt = myConn.createStatement();
        ResultSet myRss = myStmt.executeQuery("Select * from songs ");
        
       
      while (myRss.next()){
           int song_id  = myRss.getInt("song_id");
    	  String song = myRss.getString("title");
				
			if (song.equals(titlesong)){  
				//System.out.println("Signored");
			 p2 = "Signored ";
			scount = scount +1;}	
	}
				if (scount == 0) {
				
				
					String uStmt = "INSERT INTO songs (title) " + "VALUES ( '" + titlesong +"')";
					
	               	myStmt.executeUpdate(uStmt); 
	               
	               	//System.out.println("Screated");
	                 p2 = "Screated ";
        	
				}
				return p2;
		
	}
	
	//**************************************ANAGRAM*********************************************
	public static String insertAnagram(String movieID, String anagram) throws SQLException {
		int acount =0;
		String p2 = "";
		Connection myConn3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt3 = myConn3.createStatement();
        ResultSet myRSA = myStmt3.executeQuery("Select * from movie_anagrams");
        
       
      while (myRSA.next()){
           int am_movieID  = myRSA.getInt("movie_id");
           String sam_movie_ID = Integer.toString(am_movieID);
           String am_anagram = myRSA.getString("anagram");
           if (anagram.equals(am_anagram)) {
        	   if (movieID.equals(sam_movie_ID)) {
        	   acount = acount + 1;
        	   break;
        	   }
        	   
           }
           
      }

		if (acount == 0) {
			String uStmt = "INSERT INTO movie_anagrams (movie_id, anagram) VALUES ( '" + movieID + "', '" + anagram +"')";
           	//System.out.println(uStmt);
           	myStmt3.executeUpdate(uStmt); 
           	//System.out.println("Screated");
           	//System.out.println(uStmt);
            p2 = "ACreated ";
		}
		else {
			p2 = "AIgnored";
		}
		return p2;
		
	}
	
	
	
	//**************************************PEOPLE*********************************************
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
			 p2 = "Pignored ";
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
	                 p2 = "Pcreated ";
				}
				return p2;	
	}
	
	//**************************************MOVIE PEOPLE*********************************************
	public static String Moviepeoplesong(String native_name, String year_made, String title,  String stage, String mprrole) throws SQLException {
		int mscount =0;
		int mpcount =0;
		int peopleID =0;
	    int movie_id =0;
	    int movieid=0;
	    int peopleid =0;
	    int song_id =0;
	   
	    String p ="";
	    String MS="";
	   
		Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt2 = Connection.createStatement();
	    ResultSet myRss2 = myStmt2.executeQuery("Select * from song_people ");
	    Statement myStmt3 = Connection.createStatement();
	    ResultSet myRss3 = myStmt3.executeQuery("Select * from people ");
	    Statement myStmt4 = Connection.createStatement();
	    ResultSet myRss4 = myStmt4.executeQuery("Select * from movies ");
	    Statement myStmt5 = Connection.createStatement();
	    Statement myStmt6 = Connection.createStatement();
	    ResultSet myRss5 = myStmt5.executeQuery("Select * from songs ");
	    ResultSet myRss6 = myStmt6.executeQuery("Select * from movie_song ");
		  while (myRss3.next()){
			    peopleID = myRss3.getInt("people_id");
			    String pstage = myRss3.getString("stage_name");
			    pstage = pstage.replace("'", "\\'");
			   if (stage.equals(pstage)){ break;}}
		  while (myRss5.next()){
			    song_id = myRss5.getInt("song_id");
			    String songtitle = myRss5.getString("title");
			   songtitle = songtitle.replace("'", "\\'");
			   if (title.equals(songtitle)){ break;}}
		  while (myRss4.next()){
			    movie_id = myRss4.getInt("movie_id");
			    String moviename = myRss4.getString("native_name");
			    moviename = moviename.replace("'", "\\'");
				String yearymd = myRss4.getString("year_made");
				String yearmade = yearymd.substring(0,4);
			   if (moviename.equals(native_name) && yearmade.equals(year_made )){ break;}}
		  
		  
		  while (myRss6.next()){
			  int moviesid = myRss6.getInt("movie_id");
			  int  songid = myRss6.getInt("song_id");
			
			
			if ((moviesid == movie_id && songid == song_id) ){ 
			//System.out.println("MPignored") ;
			MS= "MSignored ";
			mscount = mscount +1;
			
			
			}
	  	}
		  
		  if (mscount == 0) {
				
				String uStmt = "INSERT INTO movie_song (movie_id, song_id)" + "VALUES ( '" + movie_id +"', '" + song_id +"' )";
				
	       //	
	       
	      // System.out.println("MPcreated ");
	        MS = "Mscreated ";
	       	myStmt6.executeUpdate(uStmt); 
			}
		  
		  while (myRss2.next()){
					  int songsid = myRss2.getInt("song_id");
					   peopleid = myRss2.getInt("people_id");
					 String role = myRss2.getString("role");
				//	 String screen = myRss2.getString("screen_name");
				//	 screen = screen.replace("'", "\\'");
					
			if ((peopleID == peopleid && song_id == songsid && role.equals(mprrole))){ 
			//System.out.println("MPignored") ;
			p= "SPignored ";
			mpcount = mpcount +1;
			
			
			}
			   }
		  
		  if (mpcount == 0) {
				
				String uStmt = "INSERT INTO song_people (song_id, people_id, role)" + "VALUES ( '" + song_id +"', '" + peopleID +"' ,  '" + mprrole +"')";
				
	       //	
	       
	      // System.out.println("MPcreated ");
	        p = "SPcreated ";
	       	myStmt2.executeUpdate(uStmt); 
			}
		return p + MS;
	   }

	

	//**************************************MOVIE*********************************************	
	//public static String insertRowMovie(int movie_ID, String nName, String english_name, String yearmade) throws SQLException {
	public static String[] insertRowMovie(String nName, String english_name, String yearmade) throws SQLException {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStamt7 = myCon.createStatement();
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
		Statement myStmt = myConn.createStatement();
		
	    ResultSet myRs1 = myStamt7.executeQuery("Select * from movies ");
	    
		int mcount = 0;
		int movieID = 0;
		 String p1 = "";
		
		
		while (myRs1.next()) {
		//Integer movieID = myRs1.getInt("movie_id");
		String movieName = myRs1.getString("native_name");
		movieName = movieName.replace("'", "\\'");
		String yearymd = myRs1.getString("year_made");
		String year_made = yearymd.substring(0,4);
		
			if (nName.equals(movieName) && yearmade.equals(year_made )) {
			//System.out.println("MIgnored");
			  p1 = "MIgnored ";
			  movieID = myRs1.getInt("movie_id");
			  mcount= mcount +1;
			  break;
		      //    myStmt1.executeUpdate(fupdate); 
			}
		
		}
		if (mcount == 0){
		//String processed = "processed, movie created";
		String uStmt = "INSERT INTO movies (native_name, english_name, year_made) " + "VALUES ( '" + nName +"', '" + english_name+ "', "  + yearmade + ")";
	  	myStamt7.executeUpdate(uStmt); 
		//System.out.println("Mcreated");
	  	p1 = "Mcreated";
	  	ResultSet myRs2 =  myStmt.executeQuery("SELECT * FROM movies ORDER BY movie_id DESC LIMIT 1");
		myRs2.next();
	  	movieID = myRs2.getInt("movie_id");
	    //myStamt.executeUpdate(pupdate); 
		}
		//return p1;
		String[] data1 = new String[2]; 
		data1[0] = p1;
		data1[1] = Integer.toString(movieID);
		return data1;
	}



	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% MAIN %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public static void main(String[] args) {
		
		
		
		try {
		/*
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			
			Statement myStmt = myConn.createStatement();
			Statement statement = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("Select * from mspr_test_data");
			
			while (myRs.next()) {
			int movie_ID = 	myRs.getInt("id");
			String nName = myRs.getString("native_name");
			nName = nName.replace("'", "\\'");
			String yearymd = myRs.getString("year_made");
			String title = myRs.getString("title");
			String stage = myRs.getString("stage_name");
			stage = stage.replace("'", "\\'");
			String role = myRs.getString("role");
			String year_made = yearymd.substring(0,4);
			*/
			
			//Internal console log display
			//String Output = insertRowSong(title)+ "" + insertRowPeople(stage) + " " + insertRowMovie(movie_ID, nName, nName, year_made) + " " +Moviepeoplesong( nName, year_made, title, stage, role) ;
			//System.out.println(Output);
		
			//Update external table
			//String pupdate = "Update mspr_test_data set execution_status= '" + Output + "' where id = '" + movie_ID +"'"  ;
			//statement.executeUpdate(pupdate); 
			//}		
			
			
			//Internal console log display for Anagrams
			int count = 0;
			String anagramRaw = "";
			String anaYear_made ="";
			String anaMovie_name="";
			String anagram  ="";
			String anaResult = "";
			// pass the path to the file as a parameter
		    File file =
	    		new File("Anagrams.txt");
		    Scanner sc = new Scanner(file);
		
		    	
		    	while (sc.hasNextLine()) {
		    	    anagramRaw = sc.nextLine();
		    	    String[] aParts = anagramRaw.split(", ");
	    		    anaYear_made = (aParts[1]);
	    			anaMovie_name= (aParts[0]);
	    			anagram = aParts[2];
	    			//System.out.println(anagram);
		    	    count = count  +1;
		    	    String[] insertMovie = insertRowMovie(anaMovie_name, anaMovie_name, anaYear_made);
		    	    String insertMovieStatus = insertMovie[0];
		    	    String insertMovieID = insertMovie[1];
		    	    String insertAnagramStatus = insertAnagram(insertMovieID, anagram);
		    	    anaResult = insertMovieStatus + " " + insertAnagramStatus;
		    	    //System.out.println(insertMovieID + " " + insertAnagramStatus);
		    	    System.out.println(anagramRaw + ":    "+ anaResult);
		    	  }
		    
		    System.out.println(count);
		}
	          
				 catch (Exception exc) {
					 System.err.println("Got an exception! "); 
			            System.err.println(exc.getMessage()); 
					}
	            
	            }
	
	
	
	
	
	
	
	
}
