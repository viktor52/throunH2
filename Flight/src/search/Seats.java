package search;

import java.util.List;

public interface Seats {

	public void makeSeatFalse(List LOP);
	List getAvailable(String flightnumber);
	
}
