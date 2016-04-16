package search;

import search.Seats;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import search.DB_connection;
public class Seating implements Seats {
	
	DB_connection db = new DB_connection();
	
	@Override
	public void makeDepSeatFalse(List<Person> LOP) {
		Iterator<Person> iter = LOP.iterator();
		while(iter.hasNext()){
			Person per = iter.next();
			db.insert("UPDATE seats SET avilable = FALSE WHERE flightnumber = '"+per.getDepFlightNumber()+"'"
					+ " AND seatnumber = '"+per.getDepSeat()+"'");
		}
	}

	@Override
	public List<String> getAvailable(String flightnumber) {
		List<String> avaliable = new ArrayList<String>();
		
		try {
			ResultSet rs = db.find("SELECT * FROM seats WHERE flightnumber = '"+flightnumber+"' AND avilable = TRUE");
			while(rs.next()){
				String s = rs.getString("seatnumber");
				avaliable.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return avaliable;
	}

	@Override
	public void makeRetSeatFalse(List<Person> LOP) {
		Iterator<Person> iter = LOP.iterator();
		while(iter.hasNext()){
			Person per = iter.next();
			db.insert("UPDATE seats SET avilable = FALSE WHERE flightnumber = '"+per.getRetFlightNumber()+"'"
					+ " AND seatnumber = '"+per.getArSeat()+"'");
		}
		
	}




}
