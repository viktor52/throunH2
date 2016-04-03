package testSearch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import search.Flight;
import search.FlightSearch;

public class testFlightSearch {
	
	FlightSearch fs;
	
	@Before
	public void setUp(){
		fs = new FlightSearch();
	}
	
	@After
	public void tearDown(){
		fs = null;
	}

	@Test                                                                                                            
	public void testsearchArrivalAirport() {
		List<Flight> s  = fs.searchDeparture("2016-09-09", 1, "KEF", "AEY");
		Iterator<Flight> itr = s.iterator();
		while(itr.hasNext()){
			Flight k  = itr.next();
			assertEquals("kef", k.getTo());
		}
		
	}
	
	@Test
	public void testsearchDepartureAirport(){
		List<Flight> s  = fs.searchDeparture("2016-09-09", 1, "KEF", "AEY");
		Iterator<Flight> itr = s.iterator();
		while(itr.hasNext()){
			Flight k  = itr.next();
			assertEquals("ak", k.getfrom());
		}
	}
	
	
	
	
	
	
}
