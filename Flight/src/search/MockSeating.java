package search;

public class MockSeating implements Seats {
private int [] xs;


	/*
	public boolean isAvailable(int x) {
		return true;
	}
*/
	@Override
	public void getEmpty() {
		// TODO Auto-generated method stub
		
	}

	
	public int [] isAvailable() {
		xs = null;
		boolean []y = null;
		for(int i = 0; i<10; i++){
			xs[i] = i;
		}
		for(int e = 0; e<10; e++){
			y[e] = true;
		}
		System.out.print(xs);		
		return xs;
	}

}
