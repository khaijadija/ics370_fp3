// Java Program to illustrate reading from Text File
// using Scanner Class
import java.io.File;
import java.util.Scanner;
public class AnagramsProcessor {
	
	public static void main(String[] args) throws Exception  {
		int count = 0;
		// pass the path to the file as a parameter
	    File file =
	      new File("C:\\Users\\e54705\\eclipse-workspace\\AnagramsProcessor\\anagrams.txt");
	    Scanner sc = new Scanner(file);
	
	    while (sc.hasNextLine()) {
	    	System.out.println(sc.nextLine());
	    	count = count + 1;
	    }
	    System.out.println(count);
  }


}