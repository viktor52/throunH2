package search;

public class MockSeating implements Seats {
	private boolean[][] seats;
	
	public MockSeating(int row, int col, String flightNO){

		seats = new boolean[row][col];
		/*
		int random;
		for(int i = 0; i < row; i++){
			for(int u = 0; u < col; u++){
				random = (int)(Math.random()*2);
				if(random == 0)
					seats[i][u] = true;
				else
					seats[i][u] = false;
			}
		}
		*/
		
		seats[0][0] = true;
		seats[1][0] = true;
		seats[0][1] = false;
		seats[1][1] = false;
	
	}

	
	public void getEmpty() {
		// TODO Auto-generated method stub
		
	}

	
	public boolean isAvailable(String seatString) {
		int [] x = stringToSeat(seatString);
		return seats[x[0]][x[1]];
	}


	
	public String seatToString(int row, int col) {
		String[] alphabet = {"A","B","C","D"};
		String rowString = Integer.toString(row+1); 
		String colString = alphabet[col];
		String seatString = rowString + "-" + colString;
		return seatString;
	}


	
	public int[] stringToSeat(String seatString) {
		String[] parts = seatString.split("-");
		System.out.println("helló");
		System.out.println(parts[0]+parts[1]);
		if(parts.length == 2){
		String part1 = parts[0];
		String part2 = parts[1];
		int col = 0;
		int row = Integer.parseInt(part1)-1;
		char[] ch = part2.toCharArray();
			for(char c : ch){
				int temp = (int)c;
				int temp_integer = 64;
				if(temp<=90 & temp>=65){
					col = temp-temp_integer-1;
				}
				    
			}
			int[] seatInt = {row,col};
			return seatInt;
		}

		if(parts.length == 3){
			String part1 = parts[0];
			String part2 = parts[1];
			String part3 = parts[2];
			int col = 0;
			String combine = part1+part2;
			int row = Integer.parseInt(combine);
			char[] ch = part2.toCharArray();
			for(char c : ch){
				int temp = (int)c;
				int temp_integer = 64;
				if(temp<=90 & temp>=65){
					col = temp-temp_integer;
				}
				    
			}
			int[] seatInt = {row,col};
			return seatInt;
		}
		return null;
	}

	
}
