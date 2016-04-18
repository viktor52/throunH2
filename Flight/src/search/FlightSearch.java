package search;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import search.DB_connection;

public class FlightSearch {
	static DB_connection db = new DB_connection();
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	static Calendar cal = Calendar.getInstance();
	
	public static List<Flight> searchDeparture(Date Ddate, int adult,int children,int inf, String To, String From){
		String sDate = df.format(Ddate);
		Date leftDate = null;
		try {
			leftDate = df.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(leftDate);
		cal.add(Calendar.DATE, -3);
		sDate = df.format(cal.getTime());
		
		String eDate = df.format(Ddate);
		Date rightDate = null;
		try {
			rightDate = df.parse(eDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(rightDate);
		cal.add(Calendar.DATE, 3);
		eDate = df.format(cal.getTime());
			Flight s = null;
		    List<Flight> dflight= new ArrayList<Flight>();
		    int ppltraveling = adult+children;
		    try {
		    	ResultSet rs = db.find( "SELECT * FROM flight where arivalairport = '"+ To +"' "
		    			+ "AND departureairport = '"+ From +"'AND seats >= '"+ppltraveling+"'AND depdate BETWEEN '"+sDate+"' AND '"+eDate+"' ORDER BY depdate;" );
			      while ( rs.next() ) {
			            s = new Flight(rs.getString("number"), rs.getString("departureairport"), rs.getString("arivalairport"), 
			            		rs.getDate("depdate"),rs.getInt("price"));
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

	public static List<Flight> searchReturn(Date Rdate, int adult,int children,int inf, String To, String From){
		String sDate = df.format(Rdate);
		Date leftDate = null;
		try {
			leftDate = df.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(leftDate);
		cal.add(Calendar.DATE, -3);
		sDate = df.format(cal.getTime());
		
		String eDate = df.format(Rdate);
		Date rightDate = null;
		try {
			rightDate = df.parse(eDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(rightDate);
		cal.add(Calendar.DATE, 3);
		eDate = df.format(cal.getTime());
		System.out.println(eDate);
		
		Flight s = null;
	    List<Flight> rflight= new ArrayList<Flight>();
	    int ppltraveling = adult+children;
	    try {
	    	ResultSet rs = db.find( "SELECT * FROM flight where arivalairport = '"+ To +"' "
	    			+ "AND departureairport = '"+ From +"'AND seats >= '"+ppltraveling+"'AND depdate BETWEEN '"+sDate+"' AND '"+eDate+"' ORDER BY depdate;" );
		      while ( rs.next() ) {
		            s = new Flight(rs.getString("number"), rs.getString("departureairport"), rs.getString("arivalairport"), 
		            		rs.getDate("depdate"),rs.getInt("price"));
		            System.out.println(rs.getDate("depdate"));
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
