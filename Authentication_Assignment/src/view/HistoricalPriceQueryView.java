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


public class HistoricalPriceQueryView {
	
	private JFrame frame;
	private JLabel lblProductID;
	private JButton button;
	private JTextField productIDField;
	private JPanel panel;
	
	
	
	
	public HistoricalPriceQueryView(){
	//top level container in java swing
	this.frame = new JFrame();
	
	
	
	panel = new JPanel();

	
	FlowLayout layout = new FlowLayout();
	layout.setAlignment(FlowLayout.LEFT);
	layout.setHgap(10);
	layout.setVgap(10);
	
	frame.setLayout(layout);
	
	
	lblProductID = new JLabel("Enter Product ID: ");

	
	productIDField = new JTextField(10);
	
	button = new JButton("Enter");
	
	this.panel.setLayout(layout);
	this.panel.add(this.lblProductID);
	this.panel.add(productIDField);
	this.panel.add(button);
	this.panel.setBorder(BorderFactory.createEmptyBorder(50, 600, 50, 50));
	
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//GetText returns the text from the single-line text field
			String pf = productIDField.getText();
			System.out.println("Password: " + pf);
		}
		
	});
	
	
	frame.setTitle("Historical Price Search");
	//setLocationRelativeTo(null) is commonly used to center the gui on the screen.
	frame.setLocationRelativeTo(null); 
	//setVisible(true) is a blocking operation and blocks until dialog is closed
	frame.getContentPane().add(panel, BorderLayout.CENTER);
	frame.setSize(1000, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	
	
	
	
	
	//jpanel is a container that can store a group of components

	
	
	}
	
	
	public static void main(String args[])
	{
		new HistoricalPriceQueryView();
	}
}
