package testSearch;
import search.MockSeating;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSeats {
	MockSeating s = new MockSeating();
	int[] x = s.isAvailable();
	boolean[] y;
/*	@Before
	public void setUp(){
		for(int i = 0; i<10; i++){
			x[i] = i;
		}
		for(int e = 0; e<10; e++){
			y[e] = true;
		}
		System.out.print(x);
	}
	@After
	public void tearDown(){
		s = null;
	}
*/	
	@Test
	public void test() {
		y[0] = true;
		assertEquals(x[1],s.isAvailable()[1]);
	}

}
