
public class FullyDressedMovie {

	class Song {
		public int song_id;
		public String title;
	    public String lyrics;
	    public String theme;
	}

	class People {
		public int people_id;
		public String stage_name;
	    public String first_name;
	    public String middle_name;
	    public String last_name;
	    public String gender;
	    public String image_name;
	}

	class movie {
		public int movie_id;
		public String native_name;
	    public String english_name;
	    public String year_made;
 	}

	class MovieSong {
		public int movie_id;
		public int song_id;
	}

	class MoviePeople {
		public int movie_id;
		public int people_id;
		public String role;
		public String screen_name;	
	}

	class MovieAnagram {
		public int movie_id;
		public String anagram;
	}
	
	
}