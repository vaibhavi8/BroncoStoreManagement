package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderSearchView {
	
	private JFrame frame;
	private JLabel lblOrderID;
	private JButton submitButton;
	private JButton backButton;
	private JTextField orderIDField;
	private JPanel panel;
	
	
	
	
	public OrderSearchView(){
	//top level container in java swing
	this.frame = new JFrame();
	
	
	
	panel = new JPanel();

	
	FlowLayout layout = new FlowLayout();
	layout.setAlignment(FlowLayout.LEFT);
	layout.setHgap(10);
	layout.setVgap(10);
	
	frame.setLayout(layout);
	
	
	lblOrderID = new JLabel("Enter Order ID: ");

	
	orderIDField = new JTextField(10);
	
	submitButton = new JButton("Submit");
	backButton = new JButton("Back");
	
	this.panel.setLayout(layout);
	this.panel.add(this.lblOrderID);
	this.panel.add(orderIDField);
	this.panel.add(backButton);
	this.panel.add(submitButton);
	this.panel.setBorder(BorderFactory.createEmptyBorder(50, 600, 50, 50));
	
	submitButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//GetText returns the text from the single-line text field
			String pf = orderIDField.getText();
			System.out.println("Order ID: " + pf);
		}
		
	});
	
	
	frame.setTitle("Order Search");
	//setLocationRelativeTo(null) is commonly used to center the gui on the screen.
	frame.setLocationRelativeTo(null); 
	//setVisible(true) is a blocking operation and blocks until dialog is closed
	frame.getContentPane().add(panel, BorderLayout.CENTER);
	frame.setSize(1000, 1000);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	
    //jpanel is a container that can store a group of components

	
	
	}
	
	
	public static void main(String args[])
	{
		new OrderSearchView();
	}
}
