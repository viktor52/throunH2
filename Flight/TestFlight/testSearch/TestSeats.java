package testSearch;
import search.MockSeating;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSeats {
	MockSeating s;
	@Before
	public void setUp(){
		s = new MockSeating(2, 2, null);
	}
	@After
	public void tearDown(){
		s = null;
	}

	@Test
	public void testseatToString() {
		assertEquals("1-A", s.seatToString(0, 0));
	}
	
	@Test
	public void teststringToSeat(){
		int [] x = s.stringToSeat("1-A");
		int [] y = s.stringToSeat("10-B");
		if(x.length==2){
			assertEquals(0,x[1]);
		}
		if(y.length == 3){
			assertEquals(1,y[1]);
		}
	}
/*
	@Test
	public void testisAvailable(){
		assertEquals(true,s.isAvailable("1-A"));
	}
	@Test
	public void testisAvailable2(){
		assertEquals(true,s.isAvailable("2-A"));
	}
	@Test
	public void testisAvailable3(){
		assertEquals(false,s.isAvailable("1-B"));
	}
	@Test
	public void testisAvailable4(){
		assertEquals(false,s.isAvailable("2-B"));
	}
*/
	@Test
	public void testgetEmpty(){
		String[] array = s.getEmpty();
		System.out.println(array[0]);
		for(int i = 0; i<array.length-1; i++){
			assertTrue(s.isAvailable(array[i]));
		}
	}
	
	
	
}
