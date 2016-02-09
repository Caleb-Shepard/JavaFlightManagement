import java.util.ArrayList;

public class Passenger 
{
	private String f, l;
	private ArrayList<String> getAlerts = new ArrayList<String>();
	private ArrayList<Flight> bookedFlights = new ArrayList<Flight>();
	private ArrayList<Flight> standbyFlights = new ArrayList<Flight>();
	
	public Passenger(String first, String last)
	{
		this.f = first;
		this.l = last;
	}
	
	public String getFirstName()
	{
		return f;
	}
	
	public String getLastName()
	{
		return l;
	}
	
	public ArrayList<String> getAlerts()
	{
		return getAlerts;
	}
	
	public ArrayList<Flight> getBookedFlights()
	{
		return bookedFlights;
	}
	
	public ArrayList<Flight> getStandbyFlights()
	{
		return standbyFlights;
	}
	
	public boolean bookFlight(Flight f)
	{
			if(bookedFlights.size() < f.getCapacity())
			{
			   bookedFlights.add(f);
			   f.addPassenger(this);
			   return true;
				}else{
				try{}catch(RuntimeException e){System.out.println("The flight is full!");}
			   getAlerts.add("The flight is full!");
				return false;	
			 }		
	}
	
	public boolean addStandbyFlight(Flight f)
	{
		if((!standbyFlights.contains(f))&&(f.getBookedPassengers().size()<f.getCapacity()))
		{
				standbyFlights.add(f); 
			   f.addStandbyPassenger(this);
			   return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clearAlerts()
	{
			getAlerts.clear();
	}
	
	public void cancel()
	{
		getAlerts.add("The flight has been cancelled!");
		standbyFlights.clear();
		bookedFlights.clear();
	}
	
	public void cancelFlight(Flight f)
	{
		standbyFlights.remove(f);
		f.getStandbyPassengers().remove(f);
		bookedFlights.remove(f);
		f.getBookedPassengers().remove(f);
	}
	
	public void cancelAll()
	{
		bookedFlights.clear();
		standbyFlights.clear();
	}
	
	void addAlert(String s)
	{
		getAlerts.add(s);
	}
	
}
