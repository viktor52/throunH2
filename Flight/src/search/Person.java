package search;


public class Person {
	
	private String name;
	private String birthday;
	private String email;
	private String phoneNumber;
	private String seat;
	private int orderNumber;
	private String flightNumber;
	
	public Person( String name, String birthday, String email, String phoneNumber, String seat, int orderNumber, String flightNumber ){
		
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.seat = seat;
		this.orderNumber = orderNumber;
		this.flightNumber = flightNumber;
	}
	
	public String getName(){
		
		return name;
	}
	public String getBirthday(){
		
		return birthday;
	}
	public String getEmail(){
		
		return email;
	}
	public String getPhoneNumber(){
		
		return phoneNumber;
	}
	public String getSeat(){
		
		return seat;
	}
	public int getOrderNumber(){
		
		return orderNumber;
	}
	public String getFlightNumber(){
		return flightNumber;
	}
}
