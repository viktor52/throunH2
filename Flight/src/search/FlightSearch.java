package search;

import search.DB_connection;

public class FlightSearch {
	static DB_connection db = new DB_connection();
	public static String searchReturn(){
		String s = db.findDep();
		return s;
	}

}
