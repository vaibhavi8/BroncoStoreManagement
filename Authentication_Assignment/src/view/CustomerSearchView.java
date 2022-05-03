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
public class CustomerSearchView extends JFrame implements ActionListener{
	
	private JLabel lblBroncoID, test;
	private JPanel info, address, buttons;
	private JFormattedTextField  txtBroncoID;

	
	
	private JButton buttonSubmit;
	
	public CustomerSearchView() {
		
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
//		JFrame frame = new JFrame("Add Student");
		
		this.test = new JLabel("Search customer success!");
		this.lblBroncoID = new JLabel("Enter Bronco ID: ");
		this.txtBroncoID = new JFormattedTextField();
	
		
		
		this.buttonSubmit = new JButton("Submit");
		this.buttonSubmit.addActionListener(this);
		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));


		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}	
	private void buildUI() {

		this.info.setLayout(new GridLayout(3,3));
		
		this.info.add(this.lblBroncoID);
		this.info.add(this.txtBroncoID);
		
		
		
		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonSubmit);
		
		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", info);

		this.setTitle("Search Customer");
		this.setBounds(350, 140, 500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerSearchView();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSubmit) {
			new ViewCustomer();
		}
	}

}
