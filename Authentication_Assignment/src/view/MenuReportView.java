package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuReportView {
	
	JFrame frame;
	JPanel chart;
	JButton backButton;
	JButton homeScreenButton;
	
	JLabel labelReport = new JLabel("Label Report:");
	JLabel label1 = new JLabel("Customer");
	JLabel label2 = new JLabel("Product");
	JLabel label3 = new JLabel("Product Price");
	JLabel label4 = new JLabel("Date Bought");
	
	public MenuReportView(){
		
		frame = new JFrame();
		frame.setSize(1000, 1000);
		chart = new JPanel();
		chart.setLayout(new GridBagLayout());
		homeScreenButton = new JButton("Home Screen");
		backButton = new JButton("Back");
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		//Image
		   
		
		
		
		c.insets =  new Insets(15, 15, 15, 15);
		
		
		c.gridx = 0;
		c.gridy = 0;
		chart.add(labelReport, c);
		c.gridx = 0;
		c.gridy = 1;
		chart.add(label1, c);
		c.gridx = 2;
		c.gridy = 1;
		chart.add(label2, c);
		c.gridx = 4;
		c.gridy = 1;
		chart.add(label3, c);
		c.gridx = 5;
		c.gridy = 1;
		chart.add(label4, c);
		
		c.gridx = 2;
		c.gridy = 5;
		chart.add(homeScreenButton, c);
		
		c.gridx= 4;
		c.gridy = 5;
		chart.add(backButton, c);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(chart);

	}
	
	public static void main (String[] args) {
		new MenuReportView();
	}
}
