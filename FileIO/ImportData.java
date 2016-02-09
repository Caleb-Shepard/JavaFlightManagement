import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; //java .io is java's input output 

//class is complete!
public class ImportData
{
	public ArrayList<Passenger> passengers;
	public ArrayList<Flight> flights;
	public ImportData(ArrayList<Passenger> ps, ArrayList<Flight> fs)
	{
		passengers = ps;
		flights = fs;
	}
}
