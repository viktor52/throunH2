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
		    List<Flight> flight= new ArrayList<Flight>();
		    //flight = null;
		    try {
		    	ResultSet rs = db.find( "SELECT * FROM flight where arivalairport = '"+ To +"' "
		    			+ "AND departureairport = '"+ From +"'"+"AND depdate = '"+Ddate+"'"+"integer '9';" );
			      while ( rs.next() ) {
			            s = new Flight(rs.getString("number"), rs.getString("arivalairport"), rs.getString("departureairport"), 
			            		rs.getDate("depdate"),rs.getString("price"));
			            flight.add(s);
			         }
		    }
		    catch (Exception e) {
		       e.printStackTrace();
		       System.err.println(e.getClass().getName()+": "+e.getMessage());
		       System.exit(0);
		    }
		    System.out.println(flight);
		    return flight;
		    
	}
	public static List<Flight> searchReturn(Date Rtime, int ppltrav, String To, String From){
		Flight s = null;
	    List<Flight> flight= new ArrayList<Flight>();
	    //flight = null;
	    try {
	    	ResultSet rs = db.find( "SELECT * FROM flight;" );
		      while ( rs.next() ) {
		            s = new Flight(rs.getString("number"), rs.getString("arivalairport"), rs.getString("departureairport"), 
		            		rs.getDate("depdate"),rs.getString("price"));
		            flight.add(s);
		         }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	       System.err.println(e.getClass().getName()+": "+e.getMessage());
	       System.exit(0);
	    }
	    System.out.println(flight);
	    return flight;
	}

}
