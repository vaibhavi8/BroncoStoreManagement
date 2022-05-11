package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderReceiptView extends JFrame{
	
	
	
	JFrame frame;
	JPanel chart;
	JButton menuButton;
	
	
	JLabel lblCustomer = new JLabel("Customer Name: ");
	JLabel lblDateTime = new JLabel("Date/Time: ");
	
	
	
	JLabel label1 = new JLabel("Product(s)");
	JLabel label2 = new JLabel("Qt");
	JLabel label3 = new JLabel("Price");
	
	
	
	JLabel beforeDiscount = new JLabel("Total Price Before Discount: ");
	JLabel applyDiscount = new JLabel("Apply Discount: ");
	JLabel afterDiscount = new JLabel("After Discount: ");
	
	
	
//	JLabel label4 = new JLabel("$50");
//	JLabel label5 = new JLabel("$60");
//	JLabel label6 = new JLabel("$70");
	
	public OrderReceiptView()
	{
		initializeComponents();
		buildUI();
		
		
	}
	private void initializeComponents() {
//		JFrame frame = new JFrame("Add Student");
		
		this.frame = new JFrame();
		this.frame.setSize(1000, 600);
		this.chart = new JPanel();
		this.chart.setLayout(new GridBagLayout());
		this.menuButton = new JButton("Menu");
		
		
		this.lblCustomer.setFont(new Font("Serif", Font.BOLD, 20));
		this.lblDateTime.setFont(new Font("Serif", Font.BOLD, 20));
		
		this.beforeDiscount.setFont(new Font("Serif", Font.BOLD, 15));
		this.applyDiscount.setFont(new Font("Serif", Font.BOLD, 15));
		this.afterDiscount.setFont(new Font("Serif", Font.BOLD, 15));
		
	}	
	private void buildUI() {

		GridBagConstraints c = new GridBagConstraints();
		
		
		c.insets =  new Insets(15, 15, 15, 15);
		

		c.gridx = 1;
		c.gridy = 0;
		this.chart.add(this.lblCustomer, c);
		c.gridx = 2;
		c.gridy = 0;
		this.chart.add(this.lblDateTime, c);
		c.gridx = 0;
		c.gridy = 1;
		this.chart.add(this.label1, c);
		c.gridx = 2;
		c.gridy = 1;
		this.chart.add(this.label2, c);
		c.gridx = 4;
		c.gridy = 1;
		this.chart.add(this.label3, c);
		
		c.gridx = 2;
		c.gridy = 3;
		this.chart.add(this.beforeDiscount, c);
		
		c.gridx = 2;
		c.gridy = 4;
		this.chart.add(this.applyDiscount, c);
		
		c.gridx = 2;
		c.gridy = 5;
		this.chart.add(this.afterDiscount, c);
		
		
		c.gridx = 5;
		c.gridy = 6;
		this.chart.add(this.menuButton, c);
		
		

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.add(this.chart);
		//		frame.setLocationRelativeTo(null); 
		

		this.setTitle("Add Student");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new OrderReceiptView();
	}
}
