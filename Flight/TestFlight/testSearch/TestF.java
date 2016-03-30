package testSearch;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import search.Flight;

public class TestF {
	Flight f;
	
	@Before
	public void setUp(){
		f = new Flight("ff", "kef", "ak", new Date(), "100K");
		
	}
	
	@After
	public void tearDown(){
		f = null;
		
	}

	@Test
	public void testFlightNumber() {
		assertEquals("ff",f.getflightNO());
	}
	
	@Test
	public void testFrom(){
		assertEquals("ak",f.getfrom());
	}
	
	@Test
	public void testTo() {
		assertEquals("kef",f.getTo());
	}
	
	@Test
	public void testPrice() {
		assertEquals("100K",f.getPrice());
	}

}
