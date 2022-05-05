package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderReceiptView {
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
		frame = new JFrame();
		frame.setSize(1000, 1000);
		chart = new JPanel();
		chart.setLayout(new GridBagLayout());
		menuButton = new JButton("Menu");
		backButton = new JButton("Back");
		
		
		lblCustomer.setFont(new Font("Serif", Font.BOLD, 20));
		lblDateTime.setFont(new Font("Serif", Font.BOLD, 20));
		
		beforeDiscount.setFont(new Font("Serif", Font.BOLD, 15));
		applyDiscount.setFont(new Font("Serif", Font.BOLD, 15));
		afterDiscount.setFont(new Font("Serif", Font.BOLD, 15));
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		//Image
		   
		
		
		
		c.insets =  new Insets(15, 15, 15, 15);
		
		

	
		c.gridx = 1;
		c.gridy = 0;
		chart.add(lblCustomer, c);
		c.gridx = 2;
		c.gridy = 0;
		chart.add(lblDateTime, c);
		c.gridx = 0;
		c.gridy = 1;
		chart.add(label1, c);
		c.gridx = 2;
		c.gridy = 1;
		chart.add(label2, c);
		c.gridx = 4;
		c.gridy = 1;
		chart.add(label3, c);
		
		c.gridx = 2;
		c.gridy = 3;
		chart.add(beforeDiscount, c);
		
		c.gridx = 2;
		c.gridy = 4;
		chart.add(applyDiscount, c);
		
		c.gridx = 2;
		c.gridy = 5;
		chart.add(afterDiscount, c);
		
		
		c.gridx = 5;
		c.gridy = 6;
		chart.add(menuButton, c);
		
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(chart);
		//		frame.setLocationRelativeTo(null); 
		
		
	}
	
	public static void main(String[] args)
	{
		new OrderAddView();
	}
}
