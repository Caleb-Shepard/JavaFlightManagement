import java.util.ArrayList;

public class Flight
{
	private String s,d;
	private int t, l, c;
	private ArrayList<Passenger> bookedPassengers = new ArrayList<Passenger>();
	private ArrayList<Passenger> standbyPassengers = new ArrayList<Passenger>();
	
	public Flight(String src, String dest, int takeoffTime, int landingTime, int capacity)
	{
		this.s = (String)src;
		this.d = (String)dest;
		this.t = (Integer)takeoffTime;
		this.l = (Integer)landingTime;
		this.c = (Integer)capacity;
		
		if(src == null)
			throw new RuntimeException("Null value!");
		if(dest == null)
			throw new RuntimeException("Null value!");
		
		
		
		//c
		if(capacity <= 0)
		{
			throw new RuntimeException("The flight has an invalid capacity!");
		}
		try
		{
			int x;
			x = capacity;
		}catch(NumberFormatException e){
			 System.out.println( "Illegal capacity of this flight!" );
			 this.c = (Integer)capacity;
		}
		
		if (s == d)
		{
			throw new RuntimeException("The source airport and destination airport are the same!");
		}
		
		
	}
	
	public String getSourceAirport()
	{
		if(s!=null)
			return s;
		else
			throw new RuntimeException("Null value!");
	}
	
	public String getDestinationAirport()
	{
		if(d!=null)
			return d;
		else
			throw new RuntimeException("Null value!");
	}
	
	public int getCapacity()
	{
		if(c>0)
			return c;
		else if(c<0)
			throw new RuntimeException("Capacity of the flight must be greater than zero!");
		else if(c==0)
			throw new RuntimeException("The flight capacity is zero!");
		else
			throw new RuntimeException("Null value!");
	}
	
	public int getTakeoffTime()
	{	
		  if(t>l)
		  {
		        throw new RuntimeException("Landing time bust be after takeoff time!");
		  }else if(t==l){
			  throw new RuntimeException("Landing time bust be after takeoff time! Takeoff and landing times are equal!");
		  }else{
		        return t;
		  }  
	}
	
	public int getLandingTime()
	{
		  if(t>l)
		  {
		        throw new RuntimeException("Landing time bust be after takeoff time!");
		  }else if(t==l){
			  	throw new RuntimeException("Landing time bust be after takeoff time! Takeoff and landing times are equal!");
		  }else{
		        return l;
		  }
	}
	
	public ArrayList<Passenger> getBookedPassengers()
	{
		int n = bookedPassengers.size();
		if(n>=0)
			return bookedPassengers;
		else if(n<0)
			throw new RuntimeException("ArrayList size is negative!");
		else
			throw new RuntimeException("Array list size is null!");
	}
	
	public void cancel()
	{
		int n = bookedPassengers.size();
		if(n>=0)
		{	
			for(int i = 0; i <bookedPassengers.size(); i++)
			{
				Passenger temp = bookedPassengers.get(i);
				temp.addAlert("The flight has been cancelled.");
				removePassenger(temp);
			}
			for(int i = 0; i <standbyPassengers.size(); i++)
			{
				Passenger temp = standbyPassengers.get(i);
				temp.addAlert("The flight has been cancelled.");
				removePassenger(temp);
			}
		}
		
		standbyPassengers.clear();
		bookedPassengers.clear(); 
	}
	
	public ArrayList<Passenger> getStandbyPassengers()
	{
		return standbyPassengers;
	}
	
	public boolean addPassenger(Passenger p)
	{
		if(p!=null)
		{
			this.equals(false);
			if(bookedPassengers.size() < c)
			{
			bookedPassengers.add(p);
			return true;
			}
			return false;
		}
		else
		{
			throw new RuntimeException(); 
		}
	}
	
	public boolean addStandbyPassenger(Passenger p)
	{
		  if(!standbyPassengers.contains(p))
		  {
		   standbyPassengers.add(p);
		   p.addStandbyFlight(this);
		   return true;
		  }else{
		   throw new RuntimeException("Passenger already on standby list.");
		  }
	}
	
	
	public void removePassenger(Passenger p)
	{
		if(bookedPassengers.contains(p))
		{
		bookedPassengers.remove(p);
		p.cancelFlight(this);
		}
		else
			throw new RuntimeException("Passenger does not exist in booked passengers ArrayList.");
	}
	
	public void removeStandbyPassenger(Passenger p)
	{
		if(standbyPassengers.contains(p))
		{
		standbyPassengers.remove(p);
		p.cancelFlight(this);
		}
		else
			throw new RuntimeException("Passenger does not exist in standby passengers ArrayList.");
	}
	

	
	public int promotePassengers()
	{	
		int i=0;
		if(standbyPassengers.size()>0&&(bookedPassengers.size()<c))
		{
			while((standbyPassengers.size()>0)&&(bookedPassengers.size()<c))
			{
				Passenger asdf = standbyPassengers.get(0);
				asdf.addAlert("You have been promoted!");
				asdf.bookFlight(this);
				standbyPassengers.remove(0);
				bookedPassengers.add(asdf);
				++i;
			}
			return i;
		}
		else
		{
			return i;
		}
	}
	
}
