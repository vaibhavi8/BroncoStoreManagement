package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.entities.Professor;
@SuppressWarnings("serial")
public class ProfView extends JFrame implements ActionListener{
	
	private JLabel lblName, lblDob, lblPhone, lblAddress, lblCity, lblState, 
	lblPostalCode, lblBroncoID, lblDepartment, lblOffice, lblResearch, test;
	private Professor prof;
	private JPanel info, address, buttons;
	private JLabel txtName, txtDob,txtPhone, txtAddress, txtCity, txtState, 
	txtPostalCode, txtBroncoID, txtDepartment, txtOffice, txtResearch;
	private JButton customerMenuButton;
	public ProfView(Professor professor) {
		prof = professor;
		this.initializeComponents(prof);
		this.buildUI();
		
	}
	
	private void initializeComponents(Professor professor) {
		this.setSize(1000, 600);
        customerMenuButton = new JButton("Customer Menu");
		
		this.test = new JLabel("Add Professor View Success!");
		this.lblName = new JLabel("Full Name");
		this.lblDob = new JLabel("Birth Date");
		this.lblPhone = new JLabel("Phone Number");
		
		this.lblAddress = new JLabel("Address");
		//this.space = new JLabel("");
		this.lblCity = new JLabel("City");
		this.lblState = new JLabel("State");
		this.lblPostalCode= new JLabel("Postal Code");

		this.lblBroncoID = new JLabel("Bronco ID");
		this.lblDepartment = new JLabel("Department");
		this.lblOffice = new JLabel("Office");
		this.lblResearch = new JLabel("Research");
		
	    this.txtName = new JLabel(prof.getName());
	    this.txtDob = new JLabel(prof.getDOB());
        this.txtPhone = new JLabel(prof.getPhoneNum());		
	    this.txtAddress = new JLabel(prof.getAddress());	
	    this.txtCity = new JLabel(prof.getCity());
        this.txtState = new JLabel(prof.getState());	
	    this.txtPostalCode = new JLabel(prof.getPostalCode());	
	    this.txtBroncoID = new JLabel(String.valueOf(prof.getID()));
	    this.txtDepartment = new JLabel(prof.getDept());	
	    this.txtOffice = new JLabel(prof.getOffice());
		this.txtResearch = new JLabel(prof.getResearch());

		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.address = new JPanel();
		this.address.setLayout(new FlowLayout(FlowLayout.RIGHT)); //CENTER

		this.buttons = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
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
		
		
		this.info.add(this.lblAddress);
		this.info.add(this.txtAddress);
		
		this.info.add(this.lblCity);
		this.info.add(this.txtCity);
		
		
		this.info.add(this.lblState);
		this.info.add(this.txtState);
		
		
		this.info.add(this.lblPostalCode);
		this.info.add(this.txtPostalCode);
		
		this.info.add(this.lblBroncoID);
		this.info.add(this.txtBroncoID);
		
				
		this.info.add(this.lblDepartment);
		this.info.add(this.txtDepartment);
		
		
		this.info.add(this.lblOffice);
		this.info.add(this.txtOffice);

		this.info.add(this.lblResearch);
		this.info.add(this.txtResearch);


        this.buttons.add(this.customerMenuButton);

		this.setLayout(new BorderLayout());
		add("Center", info);
		add("South", buttons);

		this.setTitle("View Professor");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.customerMenuButton) {
			dispose();
			new CustomerMenuView();
		}
	}

}