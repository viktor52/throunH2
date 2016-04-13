package search;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;

import static org.junit.Assert.assertEquals;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import search.FlightSearch;
import search.Flight;
import search.selectFlight;

public class User_interface {

	private JFrame frame;
	FlightSearch fs = new FlightSearch();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	static selectFlight SF = new selectFlight();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_interface window = new User_interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User_interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Result = new JLabel("");
		Result.setBounds(309, 202, 104, 16);
		frame.getContentPane().add(Result);
		
		final JDateChooser Departure = new JDateChooser();
		Departure.setBounds(19, 43, 123, 28);
		frame.getContentPane().add(Departure);
		
		final JDateChooser Returning = new JDateChooser();
		Returning.setBounds(174, 43, 123, 28);
		frame.getContentPane().add(Returning);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(19, 15, 86, 16);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setBounds(174, 15, 61, 16);
		frame.getContentPane().add(lblReturn);
		
		final JComboBox adult = new JComboBox();
		adult.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		adult.setBounds(19, 110, 61, 27);
		frame.getContentPane().add(adult);
		
		final JComboBox children = new JComboBox();
		children.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		children.setBounds(134, 110, 61, 27);
		frame.getContentPane().add(children);
		
		JLabel lblAdults = new JLabel("Adults");
		lblAdults.setBounds(29, 93, 61, 16);
		frame.getContentPane().add(lblAdults);
		
		JLabel lblChildren = new JLabel("Children");
		lblChildren.setBounds(134, 93, 61, 16);
		frame.getContentPane().add(lblChildren);
		
		final JComboBox infants = new JComboBox();
		infants.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		infants.setBounds(19, 164, 61, 27);
		frame.getContentPane().add(infants);
		
		JLabel lblInfants = new JLabel("Infants");
		lblInfants.setBounds(29, 149, 61, 16);
		frame.getContentPane().add(lblInfants);
		
		JCheckBox RountTrip = new JCheckBox("Round trip");
		RountTrip.setBounds(322, 30, 104, 50);
		frame.getContentPane().add(RountTrip);
		
		final JComboBox from = new JComboBox();
		from.setModel(new DefaultComboBoxModel(new String[] {"KEF", "EGS", "AEY", "RKV", "IFJ", "GRY", "THO", "VPN"}));
		from.setBounds(319, 110, 74, 27);
		frame.getContentPane().add(from);
		
		final JComboBox todest = new JComboBox();
		todest.setModel(new DefaultComboBoxModel(new String[] {"KEF", "EGS", "AEY", "RKV", "IFJ", "GRY", "THO", "VPN"}));
		todest.setBounds(319, 164, 74, 27);
		frame.getContentPane().add(todest);
		
		JButton btnLeit = new JButton("Search");
		btnLeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = adult.getSelectedIndex()+1;
				int b = children.getSelectedIndex()+1;
				int c = infants.getSelectedIndex()+1;
				String fra = from.getSelectedItem().toString();
				String til = todest.getSelectedItem().toString();
				Date f = Departure.getDate();
				Date t = Returning.getDate();
				List<Flight> ad = fs.searchDeparture(f, a,b,c, til, fra);
				Iterator<Flight> itr = ad.iterator();
				Vector<Vector<Object>> data = new Vector<Vector<Object>>();
					while(itr.hasNext()){
						Flight k  = itr.next();
						System.out.println(k.getflightNO()+", fra:"+k.getfrom()+", til:"+k.getTo()+","+k.getPrice());
				        Vector<Object> row = new Vector<Object>();
				        row.add( k.getflightNO());
				        row.add( k.getfrom());
				        row.add( k.getTo());
				        row.add(k.getPrice());
				        data.add(row);
					}
				
				List<Flight> re = fs.searchReturn(t, a,b,c, til, fra);
				Iterator<Flight> iter = re.iterator();
				while(iter.hasNext()){
					Flight k  = iter.next();
					System.out.println(k.getflightNO()+", fra:"+k.getfrom()+", til:"+k.getTo()+","+k.getPrice());
				}
				//SF.tester();
		        
		        Vector<String> headers = new Vector<String>();
		        headers.add("FlightNO");
		        headers.add("FROM");
		        headers.add( "TO");
		        headers.add("price");
		        
		        JTable table = new JTable( data, headers );
		        table.removeEditor();

		        JFrame frame1 = new JFrame();
		        frame1.add( new JScrollPane( table ));
		        frame1.pack();
		        frame1.setVisible( true ); 
		        frame.dispose();
			}
		});
		btnLeit.setBounds(309, 230, 117, 29);
		frame.getContentPane().add(btnLeit);
		
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(322, 93, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(322, 149, 61, 16);
		frame.getContentPane().add(lblTo);
	}

	protected int getInt(JTextField tala12) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected int getInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
