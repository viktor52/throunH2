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
	public void makeSeatFalse(List LOP) {
		Iterator<Person> iter = LOP.iterator();
		while(iter.hasNext()){
			Person per = iter.next();
			db.insert("UPDATE seats SET avilable = FALSE WHERE flightnumber = '"+per.getFlightNumber()+"' AND seatnumber = '"+per.getSeat()+"'");
		}
	}

	@Override
	public List getAvailable(String flightnumber) {
		List avaliable = new ArrayList();
		
		try {
			ResultSet rs = db.find("SELECT * FROM avilable WHERE flightnumber = '"+flightnumber+"' AND avilable = TRUE");
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



}
