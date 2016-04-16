package search;


public class Person {
	
	private String name;
	private String birthday;
	private String email;
	private String phoneNumber;
	private String depSeat;
	private String arSeat;
	private int orderNumber;
	private String retflightNumber;
	private String depflightNumber;
	
	public Person( String name, String birthday, String email, String phoneNumber, String depSeat, String arSeat, int orderNumber, String depflightNumber,String retflightNumber ){
		
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.depSeat = depSeat;
		this.arSeat = arSeat;
		this.orderNumber = orderNumber;
		this.retflightNumber = retflightNumber;
		this.depflightNumber = depflightNumber;
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
	public String getDepSeat(){
		
		return depSeat;
	}
	public String getArSeat(){
		
		return arSeat;
	}
	public int getOrderNumber(){
		
		return orderNumber;
	}
	public String getRetFlightNumber(){
		return retflightNumber;
	}
	public String getDepFlightNumber(){
		return depflightNumber;
	}
}
