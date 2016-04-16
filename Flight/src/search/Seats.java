package search;

import java.util.List;

public interface Seats {

	public void makeDepSeatFalse(List<Person> LOP);
	public void makeRetSeatFalse(List<Person> LOP);
	List<String> getAvailable(String flightnumber);
	
}
