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

import model.entities.Student;
@SuppressWarnings("serial")
public class StudentView extends JFrame implements ActionListener{
	
	private JLabel lblName, lblDob, lblPhone, lblAddress, lblCity, lblState, lblPostalCode, lblBroncoID, lblGradDate, lblMajor, lblMinor, test;
	private Student stud;
	private JPanel info, address, buttons;
	private JLabel txtName, txtDob,txtPhone, txtAddress, txtCity, txtState, txtPostalCode, txtBroncoID, txtGradDate, txtMajor, txtMinor;
	private JButton customerMenuButton;
	public StudentView(Student student) {
		stud = student;
		this.initializeComponents(stud);
		this.buildUI();
	
	}
	
	private void initializeComponents(Student student) {
		this.setSize(1000, 600);
        customerMenuButton = new JButton("Customer Menu");

		this.test = new JLabel("Add Student View Success!");
		this.lblName = new JLabel("Full Name");
		this.lblDob = new JLabel("Birth Date");
		this.lblPhone = new JLabel("Phone Number");
		
		this.lblAddress = new JLabel("Address");
		//this.space = new JLabel("");
		this.lblCity = new JLabel("City");
		this.lblState = new JLabel("State");
		this.lblPostalCode= new JLabel("Postal Code");
		
		this.lblBroncoID = new JLabel("Bronco ID");
		this.lblGradDate= new JLabel("Graduation Date");
		this.lblMajor = new JLabel("Major");
	    this.lblMinor = new JLabel("Minor");
		
	    this.txtName = new JLabel(stud.getName());
	    this.txtDob = new JLabel(stud.getDOB());
        this.txtPhone = new JLabel(stud.getPhoneNum());		
	    this.txtAddress = new JLabel(stud.getAddress());	
	    this.txtCity = new JLabel(stud.getCity());
        this.txtState = new JLabel(stud.getState());	
	    this.txtPostalCode = new JLabel(stud.getPostalCode());	
	    this.txtBroncoID = new JLabel(String.valueOf(stud.getID()));
	    this.txtGradDate= new JLabel(stud.getGradDate());	
	    this.txtMajor =  new JLabel(stud.getMajor());	
	    this.txtMinor = new JLabel(stud.getMinor());	

		
		
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
		
				
		this.info.add(this.lblGradDate);
		this.info.add(this.txtGradDate);
		
		
		this.info.add(this.lblMajor);
		this.info.add(this.txtMajor);

        this.buttons.add(this.customerMenuButton);
		
		this.setLayout(new BorderLayout());
		add("Center", info);
		add("South", buttons);

		this.setTitle("View Student");
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

