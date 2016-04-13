package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import search.FlightSearch;
import search.Flight;

public class selectFlight extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

        
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					selectFlight frame = new selectFlight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public selectFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

	}
	/*
	public void tester(){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        Vector<Object> row = new Vector<Object>();
        row.add( "Marie");
        row.add( "Female");
        row.add( 33);
        data.add(row);
        
        Vector<String> headers = new Vector<String>();
        headers.add("Name");
        headers.add("Gender");
        headers.add( "Age");
        
        JTable table = new JTable( data, headers );

        JFrame frame = new JFrame();
        frame.add( new JScrollPane( table ));
        frame.pack();
        frame.setVisible( true ); 
	}*/

}
