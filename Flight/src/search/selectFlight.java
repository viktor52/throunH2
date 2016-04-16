package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


import search.FlightSearch;
import search.Flight;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import search.Booking;

public class selectFlight extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	static FlightSearch fs = new FlightSearch();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	static Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	static Vector<Vector<Object>> retdata = new Vector<Vector<Object>>();
	static Vector<String> headers = new Vector<String>();
	/**
	 * Launch the application.
	 */
	static DB_connection db = new DB_connection();
	public static int orderNumber(){
		String o = "ordernumber";
		int a = 0;
		ResultSet rs = db.find("SELECT MAX(ordernumber) AS "+o+" FROM orders");
		try {
			while(rs.next()){
				a = rs.getInt(o);
				System.out.println(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	/**
	 * Create the frame.
	 */
	public selectFlight(Vector<Vector<Object>> data2,Vector<Vector<Object>> retdata2, Vector<String> headers2, 
			final boolean yes, final int a, final int b, final int c ) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//contentPane = new JPanel();
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().setLayout(null);
        //////////////////////////////////////////////////////
        JLabel lblNewLabel = new JLabel("Departing flights");
        lblNewLabel.setBounds(217, 3, 120, 15);
        frame.getContentPane().add(lblNewLabel);
        
      
        
        final JTable table = new JTable( data2, headers2 ){
        	  public boolean isCellEditable(int row, int column){
        		    return false;
        		  }
        };
        table.setSurrendersFocusOnKeystroke(true);
        table.setBounds(1, 1, 450, 0);
        frame.getContentPane().add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 30, 517, 200);
        frame.getContentPane().add(scrollPane);
        table.removeEditor();

		/////////////////////////////////////////////////////


		
		JLabel lblNewLabel_1 = new JLabel("Returning Flights");

		lblNewLabel_1.setBounds(224, 242, 113, 15);
		lblNewLabel_1.setVisible(yes);
		frame.getContentPane().add(lblNewLabel_1);
        
		final JTable table2 = new JTable( retdata2, headers2 ){
			  public boolean isCellEditable(int row, int column){
				    return false;
				  }
		};
        //table2.setBounds(1, 1, 450, 0);
		table2.setVisible(yes);
        frame.getContentPane().add(table2);

        JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(40, 280, 517, 184);
		scrollPane_1.setVisible(yes);
		frame.getContentPane().add(scrollPane_1);
		//////////////////////////////////////////////////////
		JButton nextStep = new JButton("Next");
		nextStep.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row =table.getSelectedRow();
				int column = table.getColumnCount();
				Object [] d = new Object[column];
				for(int i = 0; i<column;i++){
					d[i] = table.getValueAt(row, i);
				}
				System.out.println((String)d[0]);
				Date arDate = null;
				String flightNrFr = null;
				if(yes){
					int rerow =table2.getSelectedRow();
					int recolumn = table2.getColumnCount();
					Object [] re = new Object[recolumn];
					for(int i = 0; i<recolumn;i++){
						re[i] = table2.getValueAt(row, i);
					}
					System.out.println((String)re[0]);
					arDate = (Date) re[3];
					flightNrFr = (String) re[0];
					
				}
				Date deDate = (Date) d[3];
				int nrOfP = a+b;
				int nrOfIn = c;
				String flightNrTo = (String) d[0];
				Person per = null;
				List<Person> LOP = new ArrayList<Person>();
				int on = orderNumber()+1;
				Booking.getFlightInfo(flightNrTo, flightNrFr, nrOfP, nrOfIn, deDate, arDate, LOP, on, yes);
				frame.dispose();
			}
		});
		nextStep.setBounds(248, 476, 66, 25);
		frame.getContentPane().add(nextStep);
		
	}

	public static void getInfo(Date f,Date t,final int a,final int b, final int c, String til, String fra, final boolean yes){
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					selectFlight window = new selectFlight(data,retdata, headers, yes,a,b,c );
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		List<Flight> ad = fs.searchDeparture(f, a,b,c, til, fra);
		Iterator<Flight> itr = ad.iterator();
		
			while(itr.hasNext()){
				Flight k  = itr.next();
				System.out.println(k.getflightNO()+", fra:"+k.getfrom()+", til:"+k.getTo()+","+k.getPrice());
		        Vector<Object> row = new Vector<Object>();
		        row.add( k.getflightNO());
		        row.add( k.getfrom());
		        row.add( k.getTo());
		        row.add(k.getDepartureTime());
		        row.add(k.getPrice());
		        data.add(row);
			}
			
			if(yes){
				List<Flight> ret = fs.searchReturn(t, a,b,c, fra, til);
				Iterator<Flight> itre = ret.iterator();
				
				while(itre.hasNext()){
					Flight k  = itre.next();
					System.out.println(k.getflightNO()+", fra:"+k.getfrom()+", til:"+k.getTo()+","+k.getPrice());
				    Vector<Object> row = new Vector<Object>();
				    row.add( k.getflightNO());
				    row.add( k.getfrom());
				    row.add( k.getTo());
			        row.add(k.getDepartureTime());
			        row.add(k.getPrice());
			        retdata.add(row);
				}
			}
		
        
        
        headers.add("FlightNO");
        headers.add("FROM");
        headers.add( "TO");
        headers.add("Date");
        headers.add("price");
        

	}
}
