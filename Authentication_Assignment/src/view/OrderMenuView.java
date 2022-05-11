package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderMenuView extends JFrame implements ActionListener
{
private JLabel lblProductMenu;
	
	private JButton buttonSearch, buttonAdd, buttonHome;

	//private JTextField txtUserName, txtPassword;

	private JPanel panel1, panel2;
	public OrderMenuView() {

		this.initializeComponents();

		this.buildUI();
	}

	private void initializeComponents() {
		
		this.setSize(1000, 600);
		//this.lblProductMenu = new JLabel("Product Menu");
		//this.lblPassword = new JLabel("Password:   ");

		this.buttonSearch = new JButton("Search");
		this.buttonSearch.addActionListener(this);

		this.buttonAdd = new JButton("Add");
		this.buttonAdd.addActionListener(this);
		
		this.buttonHome = new JButton("HOME");		
		this.buttonHome.addActionListener(this);
		
		//this.buttonClean = new JButton("Clean");
		//this.buttonClean.addActionListener(this);

		//this.txtUserName = new JTextField(23);
		//this.txtPassword = new JTextField(23);

		this.panel1 = new JPanel();
		this.panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

	

	}

	private void buildUI() {

		//this.panel1.add(this.lblProductMenu);
		
		this.panel2.add(this.buttonSearch);
		this.panel2.add(this.buttonAdd);

		this.panel1.add(this.buttonHome);
		

		this.getContentPane().add(panel1, BorderLayout.SOUTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		//this.getContentPane().add(panel3, BorderLayout.CENTER);
		//this.getContentPane().add(panel4, BorderLayout.SOUTH);

		this.setTitle("Order Menu");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new OrderMenuView();
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSearch) {
			dispose();
			new SearchOrderView();
		}
		if (event.getSource() == this.buttonAdd){
			dispose();
			try {
				new AddOrderView();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (event.getSource() == this.buttonHome){
			dispose();
			new Homescreen();
		}
	}
}


