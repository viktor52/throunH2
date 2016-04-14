package search;


public class Person {
	
	private String name;
	private String birthday;
	private String email;
	private int phoneNumber;
	private String seat;
	private int orderNumber;
	
	public Person( String name, String birthday, String email, int phoneNumber, String seat, int orderNumber ){
		
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.seat = seat;
		this.orderNumber = orderNumber;
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
	public int getPhoneNumber(){
		
		return phoneNumber;
	}
	public String getSeat(){
		
		return seat;
	}
	public int getOrderNumber(){
		
		return orderNumber;
	}
}
