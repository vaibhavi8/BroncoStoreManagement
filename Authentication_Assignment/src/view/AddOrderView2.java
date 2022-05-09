package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.table.TableModel;

import model.dataccess.ProductDataAccess;

public class AddOrderView2 extends JFrame implements ActionListener {
	
	//JPanel chart;
	JButton buttonBack, buttonSubmit, buttonAdd;

    GridBagConstraints c;
	
	JFormattedTextField txtCustomerID;

	String columns[] = {" ", " ", " "};
	String rows [][] = {{"Products(s)", "Quantity", "Price"}};
	JTable table;
	TableModel model;

	JPanel panel;

	JComboBox<String> cb;

	JLabel lblCustomer, lblDateTime, lblProduct, lblQuantity, lblProductPrice, 
	lblPriceBeforeDiscount, lblApplyDiscount, lblPriceAfterDiscount;
	 
	LocalDate dateNow = LocalDate.now();
	LocalTime timeNow = LocalTime.now();  
	String dt = dateNow.toString() + " " + timeNow.toString();
	int yProduct;

	public AddOrderView2() throws ClassNotFoundException{
		this.initializeComponents();
		this.buildDropDown();
		this.buildUI();

	}

	private void initializeComponents() {
		yProduct = 1;
		panel = new JPanel();
		
		this.setSize(1000, 1000);
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
		
		panel.setLayout(new GridBagLayout());
        c =  new GridBagConstraints();
        c.insets =  new Insets(15, 15, 15, 15);

		  		
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

/*	private void createTable(String[][] rows, String[] columns){
		model = new DefaultTableModel(rows, columns);
		table = new JTable(model);
		this.add(table, BorderLayout.CENTER);
		table.setVisible(true);
	} */

	private void buildUI() throws ClassNotFoundException {
	
		c.gridx = 0;
		c.gridy = 0;
		this.panel.add(lblDateTime, c);
    	c.gridx = 4;
		c.gridy = 0;
		this.panel.add(lblCustomer, c);
		c.gridx = 1;
		c.gridy = 1;
		this.panel.add(lblProduct, c);
    	c.gridx = 2;
		c.gridy = 1;
		this.panel.add(lblQuantity, c);
		c.gridx = 3;
		c.gridy = 1;
		this.panel.add(lblProductPrice, c);
		c.gridx = 2;
		c.gridy = 10;
		this.panel.add(lblPriceBeforeDiscount, c);
    	c.gridx = 2;
		c.gridy = 11;
		this.panel.add(lblApplyDiscount, c);
		c.gridx = 2;
		c.gridy = 12;
		this.panel.add(lblPriceAfterDiscount, c);
		c.gridx = 1;
		c.gridy = 13;
		this.panel.add(buttonBack, c);
		c.gridx = 3;
		c.gridy = 13;
		this.panel.add(buttonSubmit, c);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(panel);
		
		
		
		//this.info.setLayout(new GridLayout(12,2));
		
	
		//Point p = cb.getLocationOnScreen();
		//this.buttonAdd.setLocation(((int)p.getX()+100 (int)p.getY()));


		
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

		
	

	

	}
	
	//public String getSelectedItem(){
	//	cb.getSelectedItem().toString();
	//}

	public static void main(String[] args) {
		try {
			new AddOrderView2();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonAdd){
		yProduct++;
			//System.out.println("1");
		String selectedProduct = cb.getSelectedItem().toString();
		JLabel selectedProductlbl = new JLabel(selectedProduct);
		c.gridx = 1;
		c.gridy = yProduct;
		this.panel.add( selectedProductlbl, c);	
			
			
			
			
			//JLabel lblSelectedProduct = new JLabel(selectedProduct);
			//lblSelectedProduct.setVisible(true);
			//this.buttons.add(lblSelectedProduct);
			//this.getContentPane().repaint();

		    //System.out.println(selectedProduct); 
			
			//repaint();
			//this.getContentPane().validate();
			//add(panel1, BorderLayout.NORTH);
			//getSelectedItem();



			
		}
		if (event.getSource() == this.buttonSubmit) {
			//new ViewProduct();
		}
		if (event.getSource() == this.buttonBack){
			//new 
		}
	}

}

