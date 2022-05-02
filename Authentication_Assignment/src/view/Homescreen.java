package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Homescreen extends JFrame implements ActionListener {

	private JLabel lblWelcome;
	
	private JButton buttonProductMenu, buttonOrderMenu,
	buttonGenerateReportMenu, buttonCustomerMenu, 
	buttonHistoricalPriceQuery, buttonSubmit;

	//private JTextField txtUserName, txtPassword;

	private JPanel panel1, panel2, panel3, panel4;
	
	public Homescreen() {

		this.initializeComponents();

		this.buildUI();
	}

	private void initializeComponents() {
		
		this.lblWelcome = new JLabel("Welcome!");
		//this.lblPassword = new JLabel("Password:   ");

		this.buttonProductMenu = new JButton("Product Menu");
		this.buttonProductMenu.addActionListener(this);

		this.buttonOrderMenu = new JButton("Order Menu");
		this.buttonOrderMenu.addActionListener(this);
		
		this.buttonGenerateReportMenu = new JButton("Generate Report Menu");
		this.buttonGenerateReportMenu.addActionListener(this);
		
		this.buttonCustomerMenu = new JButton("Customer Menu");
		this.buttonCustomerMenu.addActionListener(this);
		
		this.buttonHistoricalPriceQuery = new JButton("Historical Price Query");
		this.buttonHistoricalPriceQuery.addActionListener(this);
		
		
		//this.buttonClean = new JButton("Clean");
		//this.buttonClean.addActionListener(this);

		//this.txtUserName = new JTextField(23);
		//this.txtPassword = new JTextField(23);

		this.panel1 = new JPanel();
		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel3 = new JPanel();
		this.panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.panel4 = new JPanel();
		this.panel4.setLayout(new FlowLayout(FlowLayout.CENTER));

	}

	private void buildUI() {

		this.panel1.add(this.lblWelcome);
		
		this.panel2.add(this.buttonProductMenu);
		this.panel2.add(this.buttonOrderMenu);
		
		this.panel2.add(this.buttonGenerateReportMenu);
		this.panel2.add(this.buttonCustomerMenu);
	
		this.panel2.add(this.buttonHistoricalPriceQuery);
		

		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		//this.getContentPane().add(panel3, BorderLayout.CENTER);
		//this.getContentPane().add(panel4, BorderLayout.SOUTH);

		this.setTitle("BSM Homescreen");
		this.setBounds(365, 200, 365, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Homescreen();
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSubmit) {
			try {
		
				
				
				
			} 
			catch(Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			} 
		} else {
			
		}
	}
	
	
}

