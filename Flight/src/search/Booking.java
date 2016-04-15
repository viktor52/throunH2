package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
	public Booking( int nrOfP, String flightNrTo, String flightNrFr, String depDate, String arDate ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking form");
		lblNewLabel.setBounds(187, 6, 108, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPersonNr = new JLabel("Person Nr:");
		lblPersonNr.setBounds(31, 57, 77, 16);
		contentPane.add(lblPersonNr);
		
		JLabel lblName = new JLabel("Name");
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
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(31, 347, 117, 29);
		contentPane.add(btnNext);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(295, 347, 117, 29);
		contentPane.add(btnSubmit);
		
		JLabel lblSeat = new JLabel("Seat Number");
		lblSeat.setBounds(31, 303, 92, 16);
		contentPane.add(lblSeat);
		
		JComboBox seatNumber = new JComboBox();
		seatNumber.setBounds(154, 299, 130, 27);
		contentPane.add(seatNumber);
	}
	public static void getFlightInfo( final String flightNrTo, final String flightNrFr, final int nrOfP,
			final int nrOfIn, final String deDate, final String arDate ){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking( nrOfP, flightNrTo, flightNrFr, deDate, arDate );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
