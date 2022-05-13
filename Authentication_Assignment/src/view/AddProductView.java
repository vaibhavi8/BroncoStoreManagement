package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.dataccess.CreateProduct;
@SuppressWarnings("serial")
public class AddProductView extends JFrame implements ActionListener{
	
	private JLabel lblProductID, lblProductName, lblProductDesc, lblProductPrice, lblDate;
	private JPanel info, buttons;
	private JFormattedTextField txtProductID, txtProductName, txtProductDesc, txtProductPrice;
	private JButton buttonSubmit, buttonBack;
	///dates to be used in prompt
	private LocalDate dateNow = LocalDate.now();
	private Date date = Date.valueOf(dateNow); 
	
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	private int productID;

	
	
	public AddProductView() {
		
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
		this.setSize(1000, 600);
//		JFrame frame = new JFrame("Add Student");

		
		
		this.lblProductID = new JLabel("Product ID: ");
		this.lblProductName = new JLabel("Product Name: ");
		this.lblProductDesc = new JLabel("Product Description: ");
		this.lblProductPrice =  new JLabel("Product Price: ");
		this.lblDate =  new JLabel("Date: " + date);
		
		this.txtProductID = new JFormattedTextField();
		this.txtProductName = new JFormattedTextField();
		this.txtProductDesc = new JFormattedTextField();
		this.txtProductPrice =  new JFormattedTextField();
		
		this.buttonSubmit = new JButton("SUBMIT");
        this.buttonBack = new JButton("BACK");

		this.buttonSubmit.addActionListener(this);
        this.buttonBack.addActionListener(this);

		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

       // this.address = new JPanel();
		//this.address.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}	
    
	private void buildUI() {

		this.info.setLayout(new GridLayout(12,2));
		
		this.info.add(this.lblProductID);
		this.info.add(this.txtProductID);

		this.info.add(this.lblProductName);
		this.info.add(this.txtProductName);

		this.info.add(this.lblProductDesc);
		this.info.add(this.txtProductDesc);

		this.info.add(this.lblProductPrice);
		this.info.add(this.txtProductPrice);

		this.info.add(this.lblDate);
	
		
	
		
		//this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonBack);
        this.buttons.add(this.buttonSubmit);
		
		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", info);

		this.setTitle("Add Product");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new AddProductView();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSubmit) {
			//new ViewProduct();
		
			try {
				/*
				ProductDataAccess.createProduct(Integer.parseInt(txtProductID.getText()), txtProductName.getText(),
				date, txtProductDesc.getText(), Float.parseFloat(txtProductPrice.getText()));*/
				CreateProduct.ProductCreate(Integer.parseInt(txtProductID.getText()), txtProductName.getText(),
						date, txtProductDesc.getText(), Float.parseFloat(txtProductPrice.getText()));

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
		if (event.getSource() == this.buttonSubmit){
			JOptionPane.showMessageDialog(null, "Product Successfully Added", "Added Product", JOptionPane.PLAIN_MESSAGE);
		} 
		
		if (event.getSource() == this.buttonBack){
			dispose();
			new ProductMenuView();
		}

	}

}
