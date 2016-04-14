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
    private static String url = "jdbc:postgresql://ec2-54-217-231-152.eu-west-1.compute.amazonaws.com:5432/d9mdb3cn2bs8sp?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private static String user = "kocjkdlgbbqvmc";
    private static String pass = "7qHn1_BmtTxtXwgR4PoxsIYqfh";
    static ResultSet rs;
	public ResultSet find(String Q){ 
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager.getConnection(url, user, pass);
       stmt = c.createStatement();
	       rs = stmt.executeQuery( Q );
    } catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    System.out.println("Opened database successfully");
    return rs;
	}

}
