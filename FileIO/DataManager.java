import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; //for input and output

//pardon my naming conventions :)
public class DataManager 
{
	public ArrayList<Passenger> passengers;
    public ArrayList<Flight> flights;
    
	public static void exportData(String filename, ArrayList<Passenger> passengers, ArrayList<Flight> flights) throws Exception
	{
		ArrayList<Passenger> p = passengers;
	    ArrayList<Flight> f = flights;
	    java.io.File file = new java.io.File(filename);
	    java.io.PrintWriter output = new java.io.PrintWriter(file);
	    
	    	output.println("#flightCount " + f.size());
	    	for(int codeeed = 0; codeeed < f.size(); codeeed++)
	    	{
	    		output.println("#newFlight");
	    		output.println(f.get(codeeed).getSourceAirport()+" , "+f.get(codeeed).getDestinationAirport()+" , "+f.get(codeeed).getTakeoffTime()+" , "+f.get(codeeed).getLandingTime());
	    		output.println(+f.get(codeeed).getCapacity());
	    	}
	    	output.println("#passCount " + p.size());
	    	for(int codid = 0; codid < p.size(); codid++)
	    	{
	    		output.println("#newPass");
	    		output.println(p.get(codid).getFirstName() + " , " + p.get(codid).getLastName());
	    		output.println(p.get(codid).getAlerts().size());
	    		for(int codeAlerts = 0; codeAlerts < p.get(codeAlerts).getAlerts().size(); ++codeAlerts)
	    		{
	    			for(int goats = 0; goats < p.get(codid).getAlerts().size(); ++goats)
	    				{
	    					output.println(p.get(codeAlerts).getAlerts().get(goats));
	    				}
	    		}
	    		output.println(p.get(codid).getBookedFlights().size());
	    		for(int twer = 0; twer < p.get(codid).getBookedFlights().size(); ++twer)
	    		{
	    			
	    					String one = p.get(codid).getBookedFlights().get(twer).getSourceAirport();
	    					String two = p.get(codid).getBookedFlights().get(twer).getDestinationAirport();
	    					int three = p.get(codid).getBookedFlights().get(twer).getTakeoffTime();
	    					int four = p.get(codid).getBookedFlights().get(twer).getLandingTime();
	    					output.println(one + " , " + two + " , " + three +" , " + four);
	    				
	    		}
	    		
	    		output.println(p.get(codid).getStandbyFlights().size());
	    		for(int rekttttt = 0; rekttttt < p.get(codid).getStandbyFlights().size(); ++rekttttt)
	    		{
	    			
	    					String one = p.get(codid).getStandbyFlights().get(rekttttt).getSourceAirport();
	    					String two = p.get(codid).getStandbyFlights().get(rekttttt).getDestinationAirport();
	    					int three = p.get(codid).getStandbyFlights().get(rekttttt).getTakeoffTime();
	    					int four = p.get(codid).getStandbyFlights().get(rekttttt).getLandingTime();
	    					if(codid == p.size()-1 && rekttttt == p.get(codid).getStandbyFlights().size()-1)
	    					{
	    						output.print(one + " , " + two + " , " + three +" , " + four);
	    					}
	    					else
	    					output.println(one + " , " + two + " , " + three +" , " + four);
	    			
	    		}	
	    	
	    	if(file.exists()) //replace with a try catch
		    {
		    	System.out.println("File already extsts!");
		    }
	    	
	    }
	output.close();	    
	}
	
	public static ImportData importData(String filename) throws Exception
	{
		java.io.File file = new java.io.File(filename);
		Scanner input = new Scanner(file);
		String firstLine = input.nextLine();
		String trashLine = input.nextLine();
		String secondLine = input.nextLine();
		String thirdLine = input.nextLine();
	    int flyCount = Integer.parseInt(firstLine.substring(firstLine.length()-1));
	    ArrayList<Flight> f = new  ArrayList<Flight>(flyCount);
	    for (int i = 0; i < flyCount; i++) 
	    {
			String src = secondLine.substring(0,3);
		    String dest = secondLine.substring(6,9);
		    String string = secondLine.substring(12,secondLine.length()); 
		    String[] parts = string.split(",");
		    String takeoff = parts[0];
		    String landing = parts[1];  
		    int flightCapacity = Integer.parseInt(thirdLine);
		    takeoff = takeoff.substring(0,takeoff.length()-1);
		    landing = landing.substring(1, landing.length());
		    int takeoffTime, landingTime;
		    takeoffTime = Integer.parseInt(takeoff);
		    landingTime = Integer.parseInt(landing);
		    Flight z = new Flight(src, dest, takeoffTime, landingTime, flightCapacity);
	        f.add(z);
			if(i<flyCount-1)
			{
			    trashLine = input.nextLine();
		    	secondLine = input.nextLine();
				thirdLine = input.nextLine();
			}
	    }
		input.next();
		int ppassengerCount = input.nextInt();				
		ArrayList<Passenger> p = new  ArrayList<Passenger>(ppassengerCount);
		for(int x = 0; x < ppassengerCount; ++x)
		{
			input.next();
			String ffirstName = input.next();
			input.next();
			String llastName = input.next();
			Passenger ttemp = new Passenger(ffirstName, llastName);
			p.add(ttemp);
			int aalertsCount = input.nextInt();					
			for(int xwert = 0; xwert < aalertsCount; ++xwert)
			{
				input.nextLine();
				String aaalert = input.nextLine();
				ttemp.addAlert(aaalert);
			}
			int fflightsCount = input.nextInt();					
			input.nextLine();
			for(int xqwert = 0; xqwert < fflightsCount; ++xqwert)
			{
				String fflight = input.nextLine();
				String zsrc = fflight.substring(0,3);
			    String zdest = fflight.substring(6,9);
			    String sstring = fflight.substring(12,fflight.length()); 
			    String[] zparts = sstring.split(",");
			    String ztakeoff = zparts[0];
			    String zlanding = zparts[1];
			    ztakeoff = ztakeoff.substring(0,ztakeoff.length()-1);
			    zlanding = zlanding.substring(1, zlanding.length());
			    int ztakeoffTime, zlandingTime;
			    ztakeoffTime = Integer.parseInt(ztakeoff);
			    zlandingTime = Integer.parseInt(zlanding);
			    for(int weythsadfgf = 0; weythsadfgf < f.size() ; ++weythsadfgf)
			    {
			    	if(f.get(weythsadfgf).getSourceAirport().equals(zsrc) && f.get(weythsadfgf).getDestinationAirport().equals(zdest)  && f.get(weythsadfgf).getTakeoffTime() == ztakeoffTime  && f.get(weythsadfgf).getLandingTime() == zlandingTime )
			    	{
			    		p.get(x).bookFlight(f.get(weythsadfgf));
			    		break;
			    	}
			    }
			}
			int sstandbyFlights = Integer.parseInt(input.next());
			input.nextLine();
			for(int xqwerqwert = 0; xqwerqwert < sstandbyFlights; ++xqwerqwert)
			{
				String sfflight = input.nextLine();
				String szsrc = sfflight.substring(0,3);
			    String szdest = sfflight.substring(6,9);
			    String ssstring = sfflight.substring(12,sfflight.length());
			    String[] szparts = ssstring.split(",");
			    String sztakeoff = szparts[0];
			    String szlanding = szparts[1];
			    sztakeoff = sztakeoff.substring(0,sztakeoff.length()-1);
			    szlanding = szlanding.substring(1, szlanding.length());
			    int sztakeoffTime, szlandingTime;
			    sztakeoffTime = Integer.parseInt(sztakeoff);
			    szlandingTime = Integer.parseInt(szlanding);	    
			    for(int sweythsadfgf = 0; sweythsadfgf < f.size() ; ++sweythsadfgf)
			    {
			    	if(f.get(sweythsadfgf).getSourceAirport().equals(szsrc) && f.get(sweythsadfgf).getDestinationAirport().equals(szdest)  && f.get(sweythsadfgf).getTakeoffTime() == sztakeoffTime  && f.get(sweythsadfgf).getLandingTime() == szlandingTime )
			    	{
			    		p.get(x).addStandbyFlight(f.get(sweythsadfgf));
			    	}
			    }
			}
		}
		input.close();
		ImportData allNightInTheDungeon = new ImportData(p,f);
		return allNightInTheDungeon;
	}
}
