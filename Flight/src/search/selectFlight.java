package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import search.FlightSearch;
import search.Flight;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class selectFlight extends JFrame {

	private JPanel contentPane;
	static FlightSearch fs = new FlightSearch();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	static Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	static Vector<Vector<Object>> retdata = new Vector<Vector<Object>>();
	static Vector<String> headers = new Vector<String>();
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {

        

	}

	/**
	 * Create the frame.
	 */
	public selectFlight(Vector<Vector<Object>> data2,Vector<Vector<Object>> retdata2, Vector<String> headers2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
        //////////////////////////////////////////////////////
        JLabel lblNewLabel = new JLabel("Departing flights");
        lblNewLabel.setBounds(217, 3, 120, 15);
        contentPane.add(lblNewLabel);
        
        final JTable table = new JTable( data2, headers2 );
        table.setSurrendersFocusOnKeystroke(true);
        table.setBounds(1, 1, 450, 0);
        contentPane.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 30, 517, 200);
        contentPane.add(scrollPane);
        table.removeEditor();
		/////////////////////////////////////////////////////
		JLabel lblNewLabel_1 = new JLabel("Returnig Flights");
		lblNewLabel_1.setBounds(224, 242, 113, 15);
		contentPane.add(lblNewLabel_1);
        
		JTable table2 = new JTable( retdata2, headers2 );
        //table2.setBounds(1, 1, 450, 0);
        contentPane.add(table2);

        JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(40, 280, 517, 184);
		contentPane.add(scrollPane_1);
		//////////////////////////////////////////////////////
		JButton nextStep = new JButton("Next");
		nextStep.setBounds(248, 476, 66, 25);
		contentPane.add(nextStep);
		
	}
	public boolean isCellEditable(int row, int column){
		return false;
	}
	public static void getInfo(Date f,Date t, int a, int b, int c, String til, String fra, boolean yes){
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					selectFlight frame1 = new selectFlight(data,retdata, headers);
					frame1.setVisible(true);
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
		
        
        
        headers.add("FlightNO");
        headers.add("FROM");
        headers.add( "TO");
        headers.add("Date");
        headers.add("price");
        

	}
}
