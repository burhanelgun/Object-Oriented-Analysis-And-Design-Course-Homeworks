import java.util.Scanner;

/**
 * Driver class
 * @author Burhan ELGUN
 *
 */
public class Driver {
	
	public static void main(String[] args) {
	
		//take input from user and run specific algorithm according to user input
		//1 = Version1
		//2 = Version2
		//3 = Version3
		
		Scanner scanner = new Scanner(System.in);  
	    System.out.println("Enter version type( 1 , 2 or 3) = ");

	    int versionType = scanner.nextInt(); 
	    
	    if(versionType==1) {
			Version1GA version1ga = new Version1GA();
			version1ga.run();

	    }
	    else if(versionType==2) {
			Version2GA version2ga = new Version2GA();
			version2ga.run();
	    }
	    else {
			Version3GA version3ga = new Version3GA();
			version3ga.run();
	    }
	    
	}

}
