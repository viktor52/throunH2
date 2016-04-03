package testSearch;
import search.MockSeating;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSeats {
	MockSeating s = new MockSeating();
	@Test
	public void test() {
		assertEquals(10,s.isAvailable(10));
	}

}
