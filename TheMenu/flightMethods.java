import java.util.*;
/**
 * Caleb Shepard
 * */
public class flightMethods
//Create any methods that you feel may be necessary, and then delete them after you finish.
{
/* 		codes is the name of the array that contains your list of Strings which has the names of all of the Airports.
	public boolean validateCode(String inputAirCode)
	{
		for (int i = 0; i < codes.length(); i++) //be sure to go through all codes to see whether or not they are valid codes.
		{
			if(codes[i]!=inputAirCode)
			{
				break;		
			}
		}
	}
*/		
RandomItinerary rItinerary = new RandomItinerary();	
Scanner w = new Scanner(System.in);
	
	//insert array here to store passenger names, first and last.
		
RandomItinerary randItin = new RandomItinerary();
		public void menuTwo()
		{
			int menu2option = 0;
			
			System.out.println();
			System.out.println("Menu 2 will have four options; option one will allow you to search for a flight");
			System.out.println("or flight sequence, option two will allow you to cancel one flight on the existing itinerary.");
			System.out.println("option three will allow you to cancel all flights on the itinerary,  ");
			System.out.println("four will allow you to go back to the menu, and any other number will exit the program. ");
			
			System.out.println("");
			System.out.println("You are currently using Menu 2.");
			System.out.println("Select an option! Type 1 for one, 2 for two, 3 for three, and 4 for four.");
			
			menu2option = w.nextInt();
			
			if (menu2option == 1)
			{
				System.out.println("You chose option one, which flight would you like to search for?");
				flightSearch();
			}
			else if (menu2option == 2)
			{
				System.out.println("You chose option two, you may cancel a flight on the existing itinerary.");
				cancelFlight();
			}
			else if (menu2option == 3)
			{
				System.out.println("You chose option three, all flights will be cancelled.");
				cancelAll();
			}
			else if (menu2option == 4)
			{
				System.out.println("Option four was selected! The program will now restart (return to option one)."); 
				menuOne();
			}
			else if((menu2option != 1)&&(menu2option != 2)&&(menu2option != 3)&&(menu2option != 4))
			{
				System.out.println("No valid option was selected! The program will now be terminated.");
			}
		}
		public void menuOne()
		{
				int menu1option = 0;
				
				System.out.println("Choose an option! ");
				System.out.println("Menu 1 will have two options; option one will allow you to create a new itinerary,");
				System.out.println("option two will allow you to manage an existing itinerary.");
				System.out.println("Menu 2 will only come after Menu 1 is accessed, and option 1 or 2 is selected on menu 1.");
				
				System.out.println("");
				System.out.println("You are currently using menu 1.");
				System.out.println("Select an option! Type 1 for one, and 2 for two.");
		
				menu1option = w.nextInt();
				
				boolean one, two;
				one = false; 
				two = false;
				
				System.out.println();
				
				if(menu1option == 1 )
				{
					one = true;
				}
				if(menu1option == 2)
				{
					two = true;
				}
				else if(menu1option == 3)
				{
					System.out.println("Program terminated. ---------------------------------------------------------------------");
				}	
				else if((menu1option != 1)&&(menu1option != 2)&&(menu1option != 3))
				{
					System.out.println("No valid option was selected; program terminated. ----------------------------------------------------------");
				}
					
				if(one)
				{
				createItinerary();
				System.out.println("Option one completed! Moving on to menu 2.");
				}
				if(two)
				{
				manageItinerary();	
				System.out.println("Option two completed! Moving on to menu 2.");
				}
				menuTwo();
		}

		public void createItinerary()
		{
			System.out.println("We are creating an itinerary; please give us the name of the passenger ");
			System.out.println("which we are creating an itinerary for. ");
			passengerName();
			System.out.println("newPassenger: " + PFirst+ " " + PLast);
		}
	
	
			public void passengerName()
			{
				passengerFirstName();
				passengerLastName();
			}
				private String PFirst;
				private String PLast;
				//you might want to make PFirst and PLast placeholders, then immediately move the string to an array which won't be overwritten on accident, just to prevent bugs. Give every String a slot on this array so that we can have multiple passengers. You may not have to do this.
				public void passengerFirstName()
				{
					System.out.println("Passenger first name: ");
					PFirst = w.next();
				}
				
				public void passengerLastName()
				{
					System.out.println("Passenger last name: ");
					PLast = w.next();
				}
				
		public void manageItinerary()
		{
			System.out.println("You chose to manage an itinerary; which passenger are we trying to find? ");
			passengerName();
			System.out.println("findPassenger: " + PFirst + " " + PLast);
		}
		
		
		public void flightSearch()
		{
			String fsOrigin, fsDestination;
			//for stage one, we will not input validate any of these strings.
			System.out.println("Enter your originating airport: ");
			fsOrigin = w.next();
			System.out.println("Enter your destination: ");
			fsDestination = w.next();
			System.out.println("findAvailableFlightPlans: " + fsOrigin + " " + fsDestination);
		}
				
	
		/*
		 
		 * */
		 public void cancelFlight()
		 {
		  
			 System.out.println("You chose to cancel a single flight. ");
		  
		  String cLs1[] = RandomItinerary.get();
		  String cLs2[] = RandomItinerary.get();
		  String cLs3[] = RandomItinerary.get();
		  String cLs4[] = RandomItinerary.get();
		  String cLs5[] = RandomItinerary.get();
		  
		  System.out.println("Which flight would you like to cancel?");

		  System.out.println("1: " + Arrays.toString(cLs1));
		  System.out.println("2: " + Arrays.toString(cLs2));
		  System.out.println("3: " + Arrays.toString(cLs3));
		  System.out.println("4: " + Arrays.toString(cLs4));
		  System.out.println("5: " + Arrays.toString(cLs5));
		  System.out.println("6: cancel");
		  
		  System.out.println("");
		  System.out.println("Please enter an integer value.");
		  
		  int choice;
		  choice = w.nextInt();
		  
		  if(choice == 1)
		  {
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs1));
		  }
		  else if(choice == 2)
		  {
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs2));
		  }
		  else if(choice == 3)
		  {
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs3));
		  }
		  else if(choice == 4)
		  {
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs4));
		  }
		  else if(choice == 5)
		  {
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs5));
		  }
		  if (choice == 6)
		  System.out.println("Program terminated; we will not cancel anything.");
		  
		   }
		  
		  
		public void cancelAll()
		{
			 
			System.out.println("You chose to cancel all flights. ");
		  
		  String cLs1[] = RandomItinerary.get();
		  String cLs2[] = RandomItinerary.get();
		  String cLs3[] = RandomItinerary.get();
		  String cLs4[] = RandomItinerary.get();
		  String cLs5[] = RandomItinerary.get();
		  

		  
	

			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs1));
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs2));
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs3));
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs4));
			  System.out.println("We are cancelling flight 1: " + Arrays.toString(cLs5));
			  System.out.println("We have cancelled all flights.");
		  
		}
		
	/**--------------------------------------------Stage II, ignore and do not use for now. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void findAvailableFlightPlans(String originating, String destination)
	{
		flightMethods yew = new flightMethods();
		Scanner reader = new Scanner(System.in);
		
		int dest = destination.length(); 
		int orig = originating.length();
		
		if(((dest!=3)||(orig!=3))/*||(airport code dne)*/)
		{
			do
			{
				System.out.println("Enter a valid airport code."); 
				//findAvailableFlightPlans();
				
				yew.findAvailableFlightPlans(reader.next(),reader.next());
				
				dest = 3; orig = 3; //this is to prevent an infinite loop.
			}
			while(((destination.length()!=3)||(originating.length()!=3))/*||(airport code dne)*/);
		}
		else
			System.out.println("findAvailableFlightPlans: " + originating + " " + destination);
	}
	
	public void seat(int x, int y)
	{
		//x should a, b, c, d, e, or f,
	}
	
	public void passenger()
	{
		//use this to store information about the passenger.
	}
	
	public static List<Integer> getList()				//I don't understand what this does; it's example code.
	{
		List<Integer> a = new ArrayList<Integer>();
		return a;
	}
	
	public void planeSize(int seatRows, int seatCols)
	{
		//determine the size of your arrays which hold seats by using this method.
		int [] sr;
		int [] sc;
		
		sr = new int[seatRows];
		sc = new int[seatCols];
	}
	
}

