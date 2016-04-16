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
			
			db.insert("INSERT INTO orders(name, birthday, email,phonenumber,seatnumber,ordernumber) VALUES('"+per.getName()+"', "
					+ "'"+per.getBirthday()+"', '"+per.getEmail()+"','"+per.getPhoneNumber()+"','"+per.getSeat()+"', '"+per.getOrderNumber()+"')");
					
			System.out.println(per.getName());
		}
		
	}
	
	
}


