package search;
import java.util.Date;

//import search.FlightSearch;
public class Flight {
	
	private String flightNO;
	private Date DepartureTime;
	private Date ArrivalTime;
	private int Price;
	private String to;
	private String from;
	private int seatsAvailable;
	
	public Flight(String flightNO, Date DepartureTime, Date ArrivalTime, int Price, String to, String from, int seatsAvailable){
		this.flightNO = flightNO;
		this.DepartureTime = DepartureTime;
		this.ArrivalTime = ArrivalTime;
		this.Price = Price;
		this.to = to;
		this.from = from;
		this.seatsAvailable = seatsAvailable;
	}
	
	public Date getDepartureTime(){
		return DepartureTime;
	}
	public Date getArrivalTime(){
		return ArrivalTime;
	}
	public String getflightNO(){
		return flightNO;
	}
	public int getPrice(){
		return Price;
	}
	public String getto(){
		return to;
	}
	public String getfrom(){
		return from;
	}
	public int getSeatsAvailable(){
		return seatsAvailable;
	}
}
