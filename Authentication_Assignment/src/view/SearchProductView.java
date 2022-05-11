
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class SearchProductView extends JFrame implements ActionListener{
	
	private JLabel lblProductID, lblProductName;
	private JPanel info, info2, buttons;
	private JFormattedTextField  txtProductID, txtProductName;
    private JButton buttonSubmit, buttonBack;
	
	public SearchProductView() {
		
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
		this.setSize(1000, 600);
		this.lblProductID = new JLabel("Product ID: ");
		this.lblProductName = new JLabel("Product Name: ");
		this.txtProductID = new JFormattedTextField();
        this.txtProductName = new JFormattedTextField();
	


		this.buttonSubmit = new JButton("SUBMIT");
		this.buttonSubmit.addActionListener(this);

		this.buttonBack = new JButton("BACK");
		this.buttonBack.addActionListener(this);
		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
	}

	private void buildUI() {
		this.info.setLayout(new GridLayout(12,2));
		
		
		this.info.add(this.lblProductID);
		this.info.add(this.txtProductID);
		

		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonBack);
		this.buttons.add(this.buttonSubmit);
		
		this.getContentPane().add(info, BorderLayout.CENTER);
		this.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		
		//this.setLayout(new BorderLayout());
		//add("South", buttons);
		//add("Center", info);

		this.setTitle("Search Product");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SearchProductView();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSubmit) {
			dispose();
			new ViewProduct();
		}
		if (event.getSource() == this.buttonBack) {
			dispose();
			new ProductMenuView();
		}
		
	}

}
