package search;

import java.util.Date;
import java.util.List;
//import java.util.ArrayList;

import search.DB_connection;

public class FlightSearch {
	static DB_connection db = new DB_connection();
	
	public static List<Flight> searchDeparture(Date Dtime, int ppltrav, String To, String From){
		return null;
	}
	public static List<Flight> searchReturn(Date Rtime, int ppltrav, String To, String From){
		return null;
	}

}
