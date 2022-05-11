package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.dataccess.ProductDataAccess;

public class AddOrderView extends JFrame implements ActionListener {
	
	//JPanel chart;
	JButton buttonBack, buttonSubmit, buttonAdd;
	
	JPanel info, buttons, productinfo;
	
	JFormattedTextField txtCustomerID;

	String columns[] = {" ", " ", " "};
	String rows [][] = {{"Products(s)", "Quantity", "Price"}};
	JTable table;
	TableModel model;

	JComboBox<String> cb;

	JLabel lblCustomer, lblDateTime, lblProduct, lblQuantity, lblProductPrice, 
	lblPriceBeforeDiscount, lblApplyDiscount, lblPriceAfterDiscount;
	 
	LocalDate dateNow = LocalDate.now();
	LocalTime timeNow = LocalTime.now();  
	String dt = dateNow.toString() + " " + timeNow.toString();

	public AddOrderView() throws ClassNotFoundException{
		this.initializeComponents();
		this.buildDropDown();
		this.createTable(rows, columns);
		this.buildUI();

	}

	private void initializeComponents() {
		this.setSize(1000, 600);
		this.lblCustomer = new JLabel("Customer ID: ");
		this.txtCustomerID = new JFormattedTextField();

		this.lblDateTime = new JLabel("Date/Time: " + dt);
		this.lblProduct = new JLabel("Product(s): ");
		this.lblQuantity = new JLabel("Qt");
		this.lblProductPrice = new JLabel("Price");
		this.lblPriceBeforeDiscount = new JLabel("Total Price Before Discount: ");
		this.lblApplyDiscount = new JLabel("Apply Discount: ");
		this.lblPriceAfterDiscount = new JLabel("Total Price After Discount: ");

		this.buttonAdd = new JButton("Add");
		this.buttonAdd.addActionListener(this);
		this.buttonAdd.setPreferredSize(new Dimension(30, 10));

		//button.setPreferredSize(new Dimension(buttonSize, buttonSize));
		
		this.buttonSubmit = new JButton("SUBMIT");
		this.buttonSubmit.addActionListener(this);

        this.buttonBack = new JButton("BACK");
        this.buttonBack.addActionListener(this);
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.productinfo = new JPanel();
		this.productinfo.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));

		  		
	}
	
	private void buildDropDown() throws ClassNotFoundException {
		ArrayList <String> dropDownChoices =  ProductDataAccess.getAllProducts();
		int len_choices = dropDownChoices.size();
		String [] choices = new String [len_choices];
		
		for (int i = 0; i <len_choices; i++ )
		{
			choices[i] = dropDownChoices.get(i);
		}
		Arrays.sort(choices);
		this.cb = new JComboBox<String>(choices);
		cb.setSize(30,10);
		this.cb.setVisible(true);
	}

	private void createTable(String[][] rows, String[] columns){
		model = new DefaultTableModel(rows, columns);
		table = new JTable(model);
		this.add(table, BorderLayout.CENTER);
		table.setVisible(true);
	}

	private void buildUI() throws ClassNotFoundException {
		/*

		c.insets =  new Insets(15, 15, 15, 15);
		c.gridx = 0;
		c.gridy = 0;
		this.panel.add(buttonAStudent, c);
    	c.gridx = 1;
		c.gridy = 0;
		this.panel.add(buttonSearchStudent, c);
		c.gridx = 2;
		c.gridy = 0;
		this.panel.add(buttonDeleteStudent, c);
		c.gridx = 0;
		c.gridy = 1;
		this.panel.add(buttonAProfessor, c);
		c.gridx = 1;
		c.gridy = 1;
		this.panel.add(buttonSearchProfessor, c);
		c.gridx = 2;
		c.gridy = 1;
		this.panel.add(buttonDeleteProfessor, c);
		c.gridx = 2;
		c.gridy = 2;
		this.panel.add(buttonHome, c);
*/
		//this.info.setLayout(new GridLayout(12,2));
		
		this.info.add(this.lblDateTime);
		this.info.add(this.lblCustomer);
		this.info.add(this.txtCustomerID);
		//Point p = cb.getLocationOnScreen();
		//this.buttonAdd.setLocation(((int)p.getX()+100 (int)p.getY()));
		this.info.add(this.buttonAdd);

		
/*
		ArrayList <String> dropDownChoices =  ProductDataAccess.getAllProducts();
		int len_choices = dropDownChoices.size();
		String [] choices = new String [len_choices];
		
		for (int i = 0; i <len_choices; i++ )
		{
			choices[i] = dropDownChoices.get(i);
		}
		Arrays.sort(choices);

		JComboBox<String> cb = new JComboBox<String>(choices);
		cb.setVisible(true);
		*/

    	this.info.add(this.cb);
		
		this.productinfo.add(this.lblProduct);
		this.productinfo.add(this.lblQuantity);
		this.productinfo.add(this.lblProductPrice);
		this.productinfo.add(this.lblPriceBeforeDiscount);
		this.productinfo.add(this.lblApplyDiscount);
		this.productinfo.add(this.lblPriceAfterDiscount);

		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonBack);
        this.buttons.add(this.buttonSubmit);

		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", productinfo);
		add("North", info);

		this.setTitle("Add Product");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}
	
	//public String getSelectedItem(){
	//	cb.getSelectedItem().toString();
	//}

	public static void main(String[] args) {
		try {
			new AddOrderView();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonAdd){
			
			//System.out.println("1");
		String selectedProduct = cb.getSelectedItem().toString();
			

			//JLabel lblSelectedProduct = new JLabel(selectedProduct);
			//lblSelectedProduct.setVisible(true);
			//this.buttons.add(lblSelectedProduct);
			//this.getContentPane().repaint();

		System.out.println(selectedProduct); 
			
			//repaint();
			//this.getContentPane().validate();
			//add(panel1, BorderLayout.NORTH);
			//getSelectedItem();

		GridBagConstraints c = new GridBagConstraints();

			
		}
		if (event.getSource() == this.buttonSubmit) {
			//new ViewProduct();
		}
		if (event.getSource() == this.buttonBack){
			//new 
		}
	}

}
