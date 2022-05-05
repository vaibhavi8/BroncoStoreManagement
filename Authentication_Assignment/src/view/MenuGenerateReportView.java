package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuGenerateReportView implements ActionListener {

	
	JFrame frame;
	JPanel panel;
	JLabel lblCustomer;
	JLabel lblProduct;
	JLabel lblPeriod;
	JLabel period;
	JTextField productCustomerField;
	JTextField productField;
	JTextField periodField;
	JButton back;
	JButton submit;
	
	
	public MenuGenerateReportView(){
	
	this.frame = new JFrame();
	frame.setSize(1000, 1000);
	panel = new JPanel();
	panel.setLayout(new GridBagLayout());
	
	
	GridBagConstraints c = new GridBagConstraints();
	c.insets =  new Insets(15, 15, 15, 15);
	
	
	lblCustomer = new JLabel("Enter Customer: ");
	lblProduct = new JLabel("Enter Product: ");
	lblPeriod = new JLabel("Enter Period:");
	

//	productCustomerField = new JTextField(10);
	String[] customers = {"Joel", "Rida", "Vaihavi", "Professor Marin"};
	JComboBox customerDropDown = new JComboBox(customers);
	customerDropDown.setSelectedIndex(0);
	customerDropDown.addActionListener(this);

	productField = new JTextField(10);
	periodField = new JTextField(10);
	
	back = new JButton("Back");
	submit = new JButton("Submit");

	c.gridx = 0;
	c.gridy = 0;
	panel.add(lblCustomer, c);
	
	c.gridx = 1;
	c.gridy = 0;
	panel.add(customerDropDown, c);
	
	c.gridx = 2;
	c.gridy = 0;
	panel.add(lblProduct, c);
	
	c.gridx = 3;
	c.gridy = 0;
	panel.add(productField, c);
	
	
	c.gridx = 4;
	c.gridy = 0;
	panel.add(lblPeriod, c);
	
	c.gridx = 5;
	c.gridy = 0;
	panel.add(periodField, c);
	
	
	c.gridx = 1;
	c.gridy = 3;
	panel.add(submit, c);
	
	c.gridx = 4;
	c.gridy = 3;
	panel.add(back, c);
	
	

	
	back.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//GetText returns the text from the single-line text field
			
		}
		
	});
	

	submit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//GetText returns the text from the single-line text field
			
		}
		
	});
	
	
	
	//setLocationRelativeTo(null) is commonly used to center the gui on the screen.
	//setVisible(true) is a blocking operation and blocks until dialog is closed
	frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	
}

	public static void main(String []args)
	{
		new MenuGenerateReportView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox cb = (JComboBox)e.getSource();
		String msg = (String)cb.getSelectedItem();
		System.out.println(msg + " was selected");
	}
		
	
	
}
