package search;

import java.awt.BorderLayout;
import search.DB_connection;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import search.Person;
import search.InsertInDB;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import search.Seating;
import search.InsertInDB;
public class Booking extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField name;
	private JTextField birthday;
	private JTextField phoneNumber;
	private JTextField email;
	Seating seat = new Seating();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Booking( final int nrOfP, final String flightNrTo, final String flightNrFr,final Date deDate, final Date arDate, final int nrOfIn
			, final List<Person> LOP, final int on, final boolean yes) {
		frame = new JFrame();
		final int counter = nrOfP -1;
		
		boolean isVisible = false;
		boolean vis = true;
		Vector<String> headers = new Vector<String>(5);
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		headers.add("Name");
		headers.add("Depart Seatnumber");
		headers.add("Depart flight");
		headers.add("Return Seatnumber");
		headers.add("Return flight");
		
		List<Person> ad = LOP;
		Iterator<Person> itr = ad.iterator();
		
		while(itr.hasNext()){
			Person k  = itr.next();
	        Vector<Object> row = new Vector<Object>();
	        row.add(k.getName() );
	        row.add(k.getDepSeat());
	        row.add(k.getDepFlightNumber() );
	        row.add(k.getArSeat());
	        row.add(k.getRetFlightNumber());
	        data.add(row);
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 750);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking form");
		lblNewLabel.setBounds(187, 6, 108, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPersonNr = new JLabel("Person Nr:"+String.valueOf(nrOfP));
		lblPersonNr.setBounds(31, 57, 223, 16);
		frame.getContentPane().add(lblPersonNr);
		
		final JLabel lblName = new JLabel("Name");
		lblName.setBounds(31, 113, 61, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(31, 157, 61, 16);
		frame.getContentPane().add(lblBirthday);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(31, 203, 92, 16);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 252, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		name = new JTextField();
		name.setBounds(154, 108, 258, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		birthday = new JTextField();
		birthday.setBounds(154, 152, 130, 26);
		frame.getContentPane().add(birthday);
		birthday.setColumns(10);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(154, 198, 130, 26);
		frame.getContentPane().add(phoneNumber);
		phoneNumber.setColumns(10);
		
		email = new JTextField();
		email.setBounds(154, 247, 130, 26);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblSeat = new JLabel("Seat Number Departing");
		lblSeat.setBounds(31, 303, 171, 16);
		frame.getContentPane().add(lblSeat);
		
		List<String> dep = seat.getAvailable(flightNrFr);
		final JComboBox seatNumberDep = new JComboBox();
		seatNumberDep.setBounds(282, 299, 130, 27);
		seatNumberDep.setModel(new DefaultComboBoxModel(dep.toArray()));
		frame.getContentPane().add(seatNumberDep);

		JLabel lblSeatNumberArri = new JLabel("Seat Number Returning");
		lblSeatNumberArri.setBounds(31, 346, 160, 16);
		frame.getContentPane().add(lblSeatNumberArri);
		lblSeatNumberArri.setVisible(yes);
		
		List<String> ret = seat.getAvailable(flightNrTo);
		final JComboBox seatNumberRet = new JComboBox();
		seatNumberRet.setBounds(282, 342, 130, 27);
		seatNumberRet.setModel(new DefaultComboBoxModel(ret.toArray()));
		frame.getContentPane().add(seatNumberRet);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();
				String Birthday = birthday.getText();
				String PhoneNumber = phoneNumber.getText();
				String Email = email.getText();
				String depSeat = (String)seatNumberDep.getSelectedItem();
				String retSeat = (String)seatNumberRet.getSelectedItem();
				List<Person> count = LOP;
				Iterator<Person> itr = count.iterator();
				int counting = 1;
				while(itr.hasNext()){
					itr.next();
					counting++;
				}
				int ordernr = on;
				Person pers;
				pers = new Person(Name, Birthday, PhoneNumber, Email, depSeat,retSeat ,ordernr,flightNrFr,flightNrTo);
				LOP.add(pers);
				InsertInDB.insertOrder(LOP);
				seat.makeDepSeatFalse(LOP);
				seat.makeRetSeatFalse(LOP);
				InsertInDB.updateSeats(flightNrFr, counting);
				InsertInDB.updateSeats(flightNrTo, counting);
				frame.dispose();
				
			}
		});
		btnSubmit.setBounds(295, 413, 117, 29);
		frame.getContentPane().add(btnSubmit);
		if(nrOfP == 1) isVisible = true;
		btnSubmit.setVisible(isVisible);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();
				String Birthday = birthday.getText();
				String PhoneNumber = phoneNumber.getText();
				String Email = email.getText();
				String depSeat = (String)seatNumberDep.getSelectedItem();
				String retSeat = (String)seatNumberRet.getSelectedItem();
				int ordernr = on;
				Person per;
				per = new Person(Name, Birthday, PhoneNumber, Email, depSeat,retSeat ,ordernr,flightNrFr,flightNrTo);
				LOP.add(per);
				getFlightInfo(flightNrTo, flightNrFr,counter,nrOfIn,deDate,arDate, LOP, on, yes);
				frame.dispose();
			}
		});
		btnNext.setBounds(31, 413, 117, 29);
		frame.getContentPane().add(btnNext);
		if(nrOfP == 1) vis = false;
		btnNext.setVisible(vis);
		
		
		
		
		final JTable table = new JTable( data, headers ){
			  public boolean isCellEditable(int row, int column){
				    return false;
				  }
		};
		table.setVisible(true);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 476, 381, 154);
		frame.getContentPane().add(scrollPane);
		seatNumberRet.setVisible(yes);
		
	}
	public static void getFlightInfo( final String flightNrTo, final String flightNrFr, final int nrOfP,
			final int nrOfIn, final Date deDate, final Date arDate, final List<Person> LOP, final int on, final boolean yes){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking Window = new Booking( nrOfP, flightNrTo, flightNrFr, deDate, arDate, nrOfIn, LOP, on, yes );
					Window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
