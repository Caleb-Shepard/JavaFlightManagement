import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RandomItinerary 
{
	private static String[] codes = {"GNV", "BTR", "MCO", "MIA", "ATL", "IAH", "LAX", "JFK", "LGA", "ORD", "BOS", "ANC", "DEN", "SLC", "SFO", "IAD", "SEA", "OKC"};
	

	private static int getRandomInt(int min, int max) 	// Used internally.
	{
		int x;  // We're going to divide integers.
		// Don't allow y == 0!

		x = (int) (Math.random() * (max - min) + min);
		
		return x;
	}
	
	/**
	 * Gets a randomly-generated itinerary - a array of sequential airport code pairings. 
	 * @return
	 */
	
	public static String[] get()  //randomizes the codes and makes a flight sequence, returns an array of Strings
	{
		ArrayList<String> codeList = new ArrayList<String>(Arrays.asList(codes)); //makes the String array codes[] into a String arraylist named codeList
		
		Collections.shuffle(codeList); //shuffles the array list into random reorder
		
		int count = getRandomInt(1, 6); //count equals a random integer 1, 2, 3, 4, 5, or 6
		
		String[] itinerary = new String[count]; //itinerary is a new String array which contains 1, 2, 3, 4, 5, or 6 elements.
		
		for(int i=0; i < count; i++)
		{
			itinerary[i] = codeList.get(i) + "-" + codeList.get(i+1);
		}
		return itinerary;
	}
}