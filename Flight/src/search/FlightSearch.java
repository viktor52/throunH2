package search;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Statement;



import search.DB_connection;

public class FlightSearch {
	static DB_connection db = new DB_connection();
	
	public static List<Flight> searchDeparture(String Ddate , int ppltrav, String To, String From){
			Flight s = null;
		    List<Flight> dflight= new ArrayList<Flight>();
		    try {
		    	ResultSet rs = db.find( "SELECT * FROM flight where arivalairport = '"+ To +"' "
		    			+ "AND departureairport = '"+ From +"'"+"AND depdate = '"+Ddate+"';" );
			      while ( rs.next() ) {
			            s = new Flight(rs.getString("number"), rs.getString("departureairport"), rs.getString("arivalairport"), 
			            		rs.getDate("depdate"),rs.getString("price"));
			            dflight.add(s);
			         }
		    }
		    catch (Exception e) {
		       e.printStackTrace();
		       System.err.println(e.getClass().getName()+": "+e.getMessage());
		       System.exit(0);
		    }
		    System.out.println(dflight);
		    return dflight;
		    
	}
	public static List<Flight> searchReturn(String Rdate, int ppltrav, String From, String To){
		Flight s = null;
	    List<Flight> rflight= new ArrayList<Flight>();
	    try {
	    	ResultSet rs = db.find( "SELECT * FROM flight where arivalairport = '"+ To +"' "
	    			+ "AND departureairport = '"+ From +"'"+"AND depdate = '"+Rdate+"';" );
		      while ( rs.next() ) {
		            s = new Flight(rs.getString("number"), rs.getString("departureairport"), rs.getString("arivalairport"), 
		            		rs.getDate("depdate"),rs.getString("price"));
		            rflight.add(s);
		         }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	       System.err.println(e.getClass().getName()+": "+e.getMessage());
	       System.exit(0);
	    }
	    System.out.println(rflight);
	    return rflight;
	}

}
