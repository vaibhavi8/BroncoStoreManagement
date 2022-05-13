package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.entities.Order;

public class OrderDisplayView extends JFrame {

	JFrame frame;
	JPanel chart;
	JButton backButton, menuButton, updateButton, deleteButton;

	
	
	JLabel lblOrderID, lblCustomer, lblDateTime, label1, label2, label3;
	
	this.setSize(1000, 600);
	this.label1 = new JLabel("Product(s): ");
	this.label2 = new JLabel("Qt: ");
	this.label3 = new JLabel("Price: ");
	
	JLabel totalPrice = new JLabel("Total Price: ");
//	JLabel label4 = new JLabel("$50");
//	JLabel label5 = new JLabel("$60");
//	JLabel label6 = new JLabel("$70");
	
	public OrderDisplayView(Order order)
	{
		this.setSize(1000, 600);
		this.chart = new JPanel();
		this.chart.setLayout(new GridBagLayout());
		menuButton = new JButton("Menu");
		backButton = new JButton("Back");
	    updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");
		
		lblOrderID.setFont(new Font("Serif", Font.BOLD, 20));
		lblCustomer.setFont(new Font("Serif", Font.BOLD, 20));
		lblDateTime.setFont(new Font("Serif", Font.BOLD, 20));
		
		totalPrice.setFont(new Font("Serif", Font.BOLD, 30));
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		//Image
		   
		c.insets =  new Insets(15, 15, 15, 15);
		
		

		c.gridx = 0;
		c.gridy = 0;
		chart.add(lblOrderID, c);
		c.gridx = 2;
		c.gridy = 0;
		chart.add(lblCustomer, c);
		c.gridx = 4;
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
		chart.add(totalPrice, c);
		
		
		c.gridx = 6;
		c.gridy = 10;
		chart.add(menuButton, c);
		
		c.gridx = 7;
		c.gridy = 10;
		chart.add(updateButton, c);
		
		c.gridx = 8;
		c.gridy = 10;
		chart.add(deleteButton, c);
		
		c.gridx= 9;
		c.gridy = 10;
		chart.add(backButton, c);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(chart);
		
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this order", "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.CANCEL_OPTION)
				{
					System.out.println("User selected Cancel");
				}
				else if(response == JOptionPane.OK_OPTION)
				{
					System.out.println("User selected Ok");
				}
				else if(response == JOptionPane.CLOSED_OPTION)
				{
					System.out.println("Closed Dialog Box");
				}
			
			}
			
		});
		//		frame.setLocationRelativeTo(null); 
		
		
	}
	
	public static void main(String[] args)
	{
		new OrderDisplayView(Order order);
	}
}
