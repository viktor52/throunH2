package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import search.Person;
public class Booking extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField birthday;
	private JTextField phoneNumber;
	private JTextField email;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Booking( final int nrOfP, final String flightNrTo, final String flightNrFr,final Date deDate, final Date arDate, final int nrOfIn
			, final List LOP) {
		
		final int counter = nrOfP -1;
		boolean isVisible = false;
		boolean vis = true;
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking form");
		lblNewLabel.setBounds(187, 6, 108, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPersonNr = new JLabel("Person Nr:"+String.valueOf(nrOfP));
		lblPersonNr.setBounds(31, 57, 223, 16);
		contentPane.add(lblPersonNr);
		
		final JLabel lblName = new JLabel("Name");
		lblName.setBounds(31, 113, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(31, 157, 61, 16);
		contentPane.add(lblBirthday);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(31, 203, 92, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 252, 61, 16);
		contentPane.add(lblEmail);
		
		name = new JTextField();
		name.setBounds(154, 108, 258, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		birthday = new JTextField();
		birthday.setBounds(154, 152, 130, 26);
		contentPane.add(birthday);
		birthday.setColumns(10);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(154, 198, 130, 26);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);
		
		email = new JTextField();
		email.setBounds(154, 247, 130, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();
				String Birthday = birthday.getText();
				String PhoneNumber = phoneNumber.getText();
				String Email = email.getText();
				String Seat = "1-A";
				int ordernr = 1;
				Person pers;
				pers = new Person(Name, Birthday, PhoneNumber, Email, Seat, ordernr);
				LOP.add(pers);
			}
		});
		btnSubmit.setBounds(295, 347, 117, 29);
		contentPane.add(btnSubmit);
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
				String Seat = "1-A";
				int ordernr = 1;
				Person per;
				per = new Person(Name, Birthday, PhoneNumber, Email, Seat, ordernr);
				LOP.add(per);
				getFlightInfo(flightNrTo, flightNrFr,counter,nrOfIn,deDate,arDate, LOP);
			}
		});
		btnNext.setBounds(31, 347, 117, 29);
		contentPane.add(btnNext);
		if(nrOfP == 1) vis = false;
		btnNext.setVisible(vis);
		

		
		JLabel lblSeat = new JLabel("Seat Number");
		lblSeat.setBounds(31, 303, 92, 16);
		contentPane.add(lblSeat);
		
		JComboBox seatNumber = new JComboBox();
		seatNumber.setBounds(154, 299, 130, 27);
		contentPane.add(seatNumber);
	}
	public static void getFlightInfo( final String flightNrTo, final String flightNrFr, final int nrOfP,
			final int nrOfIn, final Date deDate, final Date arDate, final List LOP){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking( nrOfP, flightNrTo, flightNrFr, deDate, arDate, nrOfIn, LOP );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
