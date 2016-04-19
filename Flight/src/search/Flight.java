package search;
import java.util.Date;

public class Flight {
	
	private String flightNO;
	private Date DepartureDate;
	private String ArrivalTime;
	private String DepartureTime;
	private String [] CompanyInfo;
	private int Price;
	private String to;
	private String from;
	private int seatsAvailable;
	
	public Flight(String flightNO,  String from, String to,  Date DepartureDate, int Price, String DepartureTime, String ArrivalTime, String [] CompanyInfo){
		this.flightNO = flightNO;
		this.DepartureDate = DepartureDate;
		this.DepartureTime = DepartureTime;
		this.ArrivalTime = ArrivalTime;
		this.CompanyInfo = CompanyInfo;
		this.Price = Price;
		this.to = to;
		this.from = from;
		this.seatsAvailable = seatsAvailable;
	}
	
	public Date getDepartureDate(){
		return DepartureDate;
	}
	public String getDepartureTime(){
		return DepartureTime;
	}
	public String getArrivalTime(){
		return ArrivalTime;
	}
	public String getflightNO(){
		return flightNO;
	}
	public int getPrice(){
		return Price;
	}
	public String getTo(){
		return to;
	}
	public String getfrom(){
		return from;
	}
	public int getSeatsAvailable(){
		return seatsAvailable;
	}
	public String [] getCompanyInfo(){
		return CompanyInfo;
	}
}
