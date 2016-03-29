package search;
import java.util.Date;

//import search.FlightSearch;
public class Flight {
	
	private String flightNO;
	private Date DepartureTime;
	private Date ArrivalTime;
	private String Price;
	private String to;
	private String from;
	private int seatsAvailable;
	
	public Flight(String flightNO,  String to, String from,  Date DepartureTime, String Price){
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
	public String getPrice(){
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
