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
public class ViewProduct extends JFrame implements ActionListener{
	
	private JLabel lblName, lblDob, lblPhone, lblAddress, lblCity, lblState, lblPostalCode, lblBroncoID, lblGradDate, lblMajor, lblMinor, test;
	private Student stud;
	private JPanel info, address, buttons;
	private JLabel txtID, txtName, txtDescription, txtPrice;
	private JButton productMenuButton;
	
    public ViewProduct(Product product) {
        prod = product
		this.initializeComponents(prod);
		this.buildUI();
	
	}
	
	private void initializeComponents(Student student) {
		this.setSize(1000, 600);
        this.productMenuButton = new JButton("Product Menu");

        this.lblProductID = new JLabel("Product ID: ");
		this.lblProductName = new JLabel("Product Name: ");
        this.lblProductDescription = new JLabel("Product Description: ");
        this.lblProductPrice = new JLabel("Product Price: ");
		
        this.txtID = new JLabel(String.valueOf(prod.getID()));
	    this.txtName = new JLabel(prod.getName());
        this.txtDescription = new JLabel(prod.getDescription());
        this.txtPrice = new JLabel(prod.getPrice());


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

		this.setTitle("View Product");
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

