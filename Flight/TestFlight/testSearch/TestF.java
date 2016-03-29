package testSearch;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import search.Flight;

public class TestF {
	String number;
	String from;
	String to;
	Date deb; 
	String price;
	Flight f = new Flight("ff", "kef", "ak", new Date(), "100K");
	
	@Before
	public void setUp(){
		number = f.getflightNO();
		from = f.getfrom();
		to = f.getto();
		deb = f.getDepartureTime();
		price = f.getPrice();
		
	}
	
	@After
	public void tearDown(){
		number = null;
		from = null;
		to = null;
		deb = null;
		price = null;
		
	}

	@Test
	public void test() {
		assertEquals("ff",number);
	}

}
