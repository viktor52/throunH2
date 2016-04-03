package search;

public interface Seats {
	public boolean isAvailable(String seatString);
	public void getEmpty();
	public String seatToString(int row, int col);
	public int[] stringToSeat(String seatString);
	
}
