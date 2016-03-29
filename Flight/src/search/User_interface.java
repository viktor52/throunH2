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

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import search.FlightSearch;
import search.Flight;

public class User_interface {

	private JFrame frame;
	FlightSearch Fs = new FlightSearch();

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
		
		JDateChooser Returning = new JDateChooser();
		Returning.setBounds(174, 43, 123, 28);
		frame.getContentPane().add(Returning);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(19, 15, 86, 16);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setBounds(174, 15, 61, 16);
		frame.getContentPane().add(lblReturn);
		
		final JComboBox adult = new JComboBox();
		adult.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		adult.setBounds(19, 110, 61, 27);
		frame.getContentPane().add(adult);
		
		final JComboBox children = new JComboBox();
		children.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		children.setBounds(134, 110, 61, 27);
		frame.getContentPane().add(children);
		
		JLabel lblAdults = new JLabel("Adults");
		lblAdults.setBounds(29, 93, 61, 16);
		frame.getContentPane().add(lblAdults);
		
		JLabel lblChildren = new JLabel("Children");
		lblChildren.setBounds(134, 93, 61, 16);
		frame.getContentPane().add(lblChildren);
		
		final JComboBox infants = new JComboBox();
		infants.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		infants.setBounds(19, 164, 61, 27);
		frame.getContentPane().add(infants);
		
		JLabel lblInfants = new JLabel("Infants");
		lblInfants.setBounds(29, 149, 61, 16);
		frame.getContentPane().add(lblInfants);
		
		JCheckBox RountTrip = new JCheckBox("Rount trip");
		RountTrip.setBounds(322, 30, 104, 50);
		frame.getContentPane().add(RountTrip);
		
		JButton btnLeit = new JButton("Leita");
		btnLeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = adult.getSelectedIndex()+1;
				int b = children.getSelectedIndex()+1;
				int c = infants.getSelectedIndex()+1;
				Date f = Departure.getDate();
				List ad = new ArrayList();
				ad.add(Fs.searchDeparture(f, a, "", ""));
				System.out.println("fullo "+a+", born "+b+", infant"+c);
				System.out.println();
				
			}
		});
		btnLeit.setBounds(309, 230, 117, 29);
		frame.getContentPane().add(btnLeit);
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
