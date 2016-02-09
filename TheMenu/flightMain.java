import java.util.Scanner;

public class flightMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/*execute methods in other classes, this is the runner*
		 * 
		 * 
		 * 	1. Create a new itinerary.    Each passenger has a single itinerary. 
		  	 For creation, we just need a <first> and <last> name. 
		   	 Once the first and last name are obtained, your program should output (as a String) 
		   	 the following before continuing, as a single line:  
			newPassenger: <first> <last>  
			
			2. Manage existing itinerary.  
			Obtain a <first> and <last> name. 
			It will be fairly identical to option 1 for now; this is fine.  
			Simply word things differently. 
 			Once obtained, your program should output (as a String) the following before continuing, as a single line:  
			findPassenger: <first> <last>  
			
			3. Exit the program.  
			Once either option 1 or 2 is complete, control should pass to the next menu
		 * 
		 * /
		
		
		
		/**testing*/

		flightMethods asd = new flightMethods();
		Scanner asdf = new Scanner(System.in);
		RandomItinerary randItin = new RandomItinerary();
		
		asd.menuOne();
		
		/*============================Menu Two=========================================================================================*/
		asd.menuTwo();
		
	}

}
