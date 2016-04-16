package search;

import java.util.Iterator;
import java.util.List;
import search.Person;
import search.DB_connection;
public class InsertInDB {
	static DB_connection db = new DB_connection();
	
	public static void insertOrder(List<Person> LOP){
		
		Iterator<Person> iter = LOP.iterator();
		
		while(iter.hasNext()){
			Person per = iter.next();
			
			db.insert("INSERT INTO orders(name, birthday, email,phonenumber,depseatnumber,depflight,arseatnumber,arflight,ordernumber) VALUES('"+per.getName()+"', "
					+ "'"+per.getBirthday()+"', '"+per.getEmail()+"','"+per.getPhoneNumber()+"','"+per.getDepSeat()+"', '"+per.getDepFlightNumber()+"','"+per.getArSeat()+"',"
							+ "'"+per.getRetFlightNumber()+"','"+per.getOrderNumber()+"')");
					
			System.out.println(per.getName());
		}
		
	}
	
	public static void updateSeats(String flightNumber, int NumOfP){
		db.insert("UPDATE flight SET seats = seats -"+NumOfP+" WHERE number = '"+flightNumber+"' ");
	}
	
	
}


