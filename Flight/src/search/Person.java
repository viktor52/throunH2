package search;


public class Person {
	
	private String name;
	private String birthday;
	private String email;
	private int phoneNumber;
	
	public Person( String name, String birthday, String email, int phoneNumber ){
		
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
}
