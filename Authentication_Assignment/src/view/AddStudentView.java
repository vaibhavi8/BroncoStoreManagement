package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

import java.util.*;
@SuppressWarnings("serial")
public class AddStudentView extends JFrame implements ActionListener{
	
	private JLabel lblName, lblDob, lblPhone, lblAddress, lblAddressLine1, lblCity, lblState, lblPostalCode, lblBroncoID, lblGradDate, lblMajor, lblMinor, test;
	
	private JPanel info, address, buttons;
	private JFormattedTextField txtName, txtDob,txtPhone, txtAddress, txtAddressLine, txtCity, txtState, txtPostalCode, txtBroncoID, txtGradDate, txtMajor, txtMinor;

	
	
	private JButton buttonSubmit;
	
	public AddStudentView() {
		
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
//		JFrame frame = new JFrame("Add Student");
		
		this.test = new JLabel("Add Student View Success!");
		this.lblName = new JLabel("Full Name");
		this.lblDob = new JLabel("Birth Date");
		this.lblPhone = new JLabel("Phone Number");
		
		this.lblAddress = new JLabel("Address");
		//this.space = new JLabel("");

		this.lblAddressLine1 = new JLabel("Address Line 1");
		this.lblCity = new JLabel("City");
		this.lblState = new JLabel("State");
		this.lblPostalCode= new JLabel("Postal Code");
		
		
		this.lblBroncoID = new JLabel("Bronco ID");
		this.lblGradDate= new JLabel("Graduation Date");
		this.lblMajor = new JLabel("Major");
		this.lblMinor = new JLabel("Minor");
		
		this.txtName = new JFormattedTextField();
		this.txtDob = new JFormattedTextField();
		this.txtPhone = new JFormattedTextField();	
		//this.txtAddress = new JFormattedTextField();	
		this.txtAddressLine = new JFormattedTextField();	
		this.txtCity = new JFormattedTextField();	
		this.txtState = new JFormattedTextField();	
		this.txtPostalCode = new JFormattedTextField();	
		this.txtBroncoID = new JFormattedTextField();	
		this.txtGradDate= new JFormattedTextField();	
		this.txtMajor =  new JFormattedTextField();	
		this.txtMinor = new JFormattedTextField();	
		
		
		this.buttonSubmit = new JButton("Submit");
		this.buttonSubmit.addActionListener(this);
		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.address = new JPanel();
		this.address.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}	
	private void buildUI() {

		this.info.setLayout(new GridLayout(12,2));
		
		this.info.add(this.lblName);
		this.info.add(this.txtName);
		
		this.info.add(this.lblDob);
		this.info.add(this.txtDob);
		
		this.info.add(this.lblPhone);
		this.info.add(this.txtPhone);
		
		
		//this.info.add(this.lblAddress);
		//this.info.add(this.txtPhone);
		
		
		this.info.add(this.lblAddressLine1);
		this.info.add(this.txtAddressLine);
		
		this.info.add(this.lblCity);
		this.info.add(this.txtCity);
		
		
		this.info.add(this.lblState);
		this.info.add(this.txtState);
		
		
		this.info.add(this.lblPostalCode);
		this.info.add(this.txtPostalCode);
		
		
		this.info.add(this.lblBroncoID);
		this.info.add(this.txtBroncoID);
		
				
		this.info.add(this.lblGradDate);
		this.info.add(this.txtGradDate);
		
		
		this.info.add(this.lblMajor);
		this.info.add(this.txtMajor);
		
		
		this.info.add(this.lblMinor);
		this.info.add(this.txtMinor);
		
		
		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonSubmit);
		
		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", info);

		this.setTitle("Add Student");
		this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new AddStudentView();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSubmit) {
			new ViewCustomer();
		}
	}

}
