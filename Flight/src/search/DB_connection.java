package search;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_connection {
	private static Connection c = null;
    private static Statement stmt = null;
    private static String url = "jdbc:postgresql://localhost:5432/planes";
    private static String user = "viktor";
    private static String pass = "";
	public static List find(String Q){ 
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager.getConnection(url, user, pass);
       stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( Q );
    } catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    System.out.println("Opened database successfully");
    return flug;
	}

}
