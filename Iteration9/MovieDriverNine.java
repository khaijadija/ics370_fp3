

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;



class movie implements Comparable<movie>{
	private int movie_id = 0;
	private String name = " ";
	  private String year = " ";
	  movie(int movie_id, String name, String year) {
		  this.movie_id= movie_id;
			this.name = name;
			this.year = year;
		}
	  public int getmovieid(){
		  return movie_id;
	  }
	  public String getName(){
		  return name;
	  }
	  public String getYear(){
		  return year;
	  }
	  public String toString(){
		  return "movie Id " + movie_id+ " Name:" + name + "," + " Year:"+ year;
	  }
	 // @Override
    public int compareTo( movie o) {
	       
	  return toString().compareTo(o.toString());
	    }
	}
class movieCollection{
		 ArrayList<movie> movielist= new ArrayList<movie>();
		 ArrayList<movie> msprlist= new ArrayList<movie>();
		 ArrayList<movie> anagramlist= new ArrayList<movie>();
		 }
class People
{
	
	public int people_id;
	public String stage_name;

    public String first_name;

  
    public String  middle_name;
    public String  last_name;
    public String  gender;
    public String  image_name;
}

class PeopleCollection{
	 ArrayList<movie> peoplelist= new ArrayList<movie>();
	
	 }
class Anagram
{
	
	public int movie_id;
	public String anagram;

    
}

class Song{
	  
	private String title = "title";
	  private int song_id = 0;
	  
	  private int movie_id = 0;
	  Song(int movie_id, int song_id, String title) {
			this.movie_id = movie_id;
			this.song_id= song_id;
			this.title= title;
		}
	  public String getTitle(){
		  return title;
	  }
	  public int getmovie_id(){
		  return movie_id;
	  }
	  public int getSong_Id(){
		  return song_id;
	  }
	  
	  public String toString(){
		  return  "movie Id " + movie_id + " Title:" + title + "," + " Song Id:"+ song_id;
	  }
	  
	  
	}
class SongCollection{
		 ArrayList<Song> songlist= new ArrayList<Song>();
		
		 }

class MovieSong {
	private int movie_id;
	private int song_id;


}
class MoviePeople {
	private int movie_id;
	private int people_id;
	private String role = " ";
	private String screen_name ="";

}
class MsprTestData{
	
}
class msprCollection{
	 ArrayList<MsprTestData> msprlist= new ArrayList<MsprTestData>();
	
	 }




public class MovieDriverNine {
	//boolean found = false;
	
	public static void main(String[] args) {  
		
	        
	        int movie_id = 0;
	     String role= "";
	     String stage_name = "";
		
		movieCollection moviecollection = new movieCollection();
	   PeopleCollection mpcollection = new PeopleCollection();
		 
	   try{
			int count =0;
			int mpcount =0;
			
			 
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement myStmt = myConn.createStatement();
			Statement myStmt1 = myConn.createStatement();
	        ResultSet myRss = myStmt.executeQuery("Select * from movies where movie_id NOT IN (select  movie_id from movie_song)");
	        ResultSet myRss1 = myStmt1.executeQuery("Select * from movies where movie_id NOT IN (select  movie_id from movie_people)");
		//  System.out.println(" File "+ " ("+ fileName +")" + " is processed");
		  while (myRss.next()){
	           movie_id  = myRss.getInt("movie_id"); 
	           String native_name = myRss.getString("native_name"); 
	           String english_name = myRss.getString("english_name"); 
	           String yearymd= myRss.getString("year_made"); 
	           String year_made = yearymd.substring(0,4);
		    
		    
			
			movie current_movie= new movie(movie_id, native_name, year_made);
			moviecollection.movielist.add(current_movie);
		  }
			Collections.sort(moviecollection.movielist);
			for(movie y : moviecollection.movielist){
		   		
		   			
		   			System.out.println( y);
		   			count =count + 1;
		   	       }
			//Arrays.sort(moviecollection.movielist);
			
			    
			System.out.println(" total number of movies with no songs is: "+ count);
			//System.out.println(Arrays.asList(moviecollection.movielist));
		   		
			 while (myRss1.next()){
		           movie_id  = myRss1.getInt("movie_id"); 
		           String native_name = myRss1.getString("native_name"); 
		           String english_name = myRss1.getString("english_name"); 
		           String yearymd= myRss1.getString("year_made"); 
		           String year_made = yearymd.substring(0,4);
			    
			    
				
				movie current_pmovie= new movie(movie_id, native_name, year_made);
				mpcollection.peoplelist.add(current_pmovie);
			  }
				//Collections.sort(moviecollection.movielist);
				for(movie y : mpcollection.peoplelist){
			   		
			   			
			   			System.out.println( y);
			   			mpcount = mpcount + 1;
			   	       }
				//Arrays.sort(moviecollection.movielist);
				
				    
				System.out.println(" total number of movies with no people data is: "+ mpcount);
				//System.out.println(Arrays.asList(moviecollection.movielist));
				  try {
				Scanner input = new Scanner(System.in);
		        System.out.println("Enter the role:");
		        role = input.nextLine();
		       
		       Scanner input1 = new Scanner(System.in);
		       System.out.println("Enter the stage_name:");
		       stage_name = input1.nextLine();
		
			   MovieStageRole( role, stage_name);
			
			    Scanner input2 = new Scanner(System.in);
		       System.out.println("Enter the anagaram:");
		       String anagrams = input2.nextLine();
		       MovieAnagram(anagrams);
		       
				  }
				  catch (Exception exc) {
						 System.err.println("Got an exception! "); 
				         System.err.println(exc.getMessage()); 
				         
						}
				
	} 
	   catch (Exception exc) {
		 System.err.println("Got an exception! "); 
         System.err.println(exc.getMessage()); 
         
		}
	        }
	

public static String MovieStageRole(String roles, String stage) throws SQLException {
	int mscount =0;
	
    int movie_id =0;
   
   
    
   
	Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
	
    Statement myStmt4 = Connection.createStatement();
   ResultSet myRss4 = myStmt4.executeQuery("Select * from movies ");
   
    Statement myStmt6 = Connection.createStatement();
    
    ResultSet myRss6 = myStmt6.executeQuery("Select id from mspr_test_data where role = '"+roles+"' and stage_name = '"+stage+"'" );
	  
    movieCollection msprcollection = new movieCollection();
	 
	  
	  
	  while (myRss6.next()){
		  movie_id  = myRss6.getInt("id");
		  while (myRss4.next()){
			   int movieid = myRss4.getInt("movie_id");
			    String nativename = myRss4.getString("native_name");
			    nativename = nativename.replace("'", "\\'");
				String yearymd = myRss4.getString("year_made");
				String yearmade = yearymd.substring(0,4);
			   if (movie_id == movieid) {
				   movie current_movie= new movie(movie_id, nativename, yearmade);
				   
		  msprcollection.msprlist.add(current_movie);}
		




}
		 System.out.println("list of movie with role = "+ roles + "and stage_name ="+ stage + ":"); 
		 for(movie y : msprcollection.msprlist){
		   		
	   			
	   			System.out.println( y);
	   			mscount = mscount +1;
	   	       }
		 System.out.println( "Total = "  + mscount);
}
	return "done";
	  
	 
	  
   }


public static String MovieAnagram(String anagrams) throws SQLException {
	int acount =0;
	
   
    String anagra ="";
   
   
    
   
	Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
	
    //Statement myStmt4 = Connection.createStatement();
  // ResultSet myRss4 = myStmt4.executeQuery("Select * from movies ");
   
    Statement myStmt7 = Con.createStatement();
    
    ResultSet myRss7 = myStmt7.executeQuery("Select movie_id from movie_anagrams where anagram = '"+anagrams+"' " );
	  
    movieCollection anagramcollection = new movieCollection();
	 
	  
	  
	  while (myRss7.next()){
		 
		  int movieid = myRss7.getInt("movie_id");
		
		  Statement myStmt8 = Con.createStatement();
		    ResultSet myRss8 = myStmt8.executeQuery("Select * from movies where movie_id = '"+movieid+"' " );
		  while (myRss8.next()){
			   int moviesid = myRss8.getInt("movie_id");
			    String nativename = myRss8.getString("native_name");
			    nativename = nativename.replace("'", "\\'");
				String yearymd = myRss8.getString("year_made");
				String yearmade = yearymd.substring(0,4);
			  
				   movie current_movie= new movie(moviesid, nativename, yearmade);
				   
		  anagramcollection.anagramlist.add(current_movie);}}
		





		 System.out.println("list of movie with anagram =  '"+anagrams+"' "); 
		 for(movie y : anagramcollection.anagramlist){
		   		
	   			
	   			System.out.println( y);
	   			acount = acount +1;
	   	       }
		 System.out.println( "Total = "  + acount);

	return "done";
	  
}
	  
   


}




		
		
		
	   

	   
	   
		  		
	   
       

    

	
	
	        


	

  
         
        
         
       	
	    
	    
	  



