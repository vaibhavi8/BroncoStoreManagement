package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoricalPriceView {

	JFrame frame;
	JPanel chart;
	JButton backButton;
	JButton homeScreenButton;
	
	JLabel label1 = new JLabel("Date #1");
	JLabel label2 = new JLabel("Date #2");
	JLabel label3 = new JLabel("Date #3");
	JLabel label4 = new JLabel("$50");
	JLabel label5 = new JLabel("$60");
	JLabel label6 = new JLabel("$70");
	
	public HistoricalPriceView()
	{
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
		chart.add(label1, c);
		c.gridx = 2;
		c.gridy = 0;
		chart.add(label2, c);
		c.gridx = 4;
		c.gridy = 0;
		chart.add(label3, c);
		c.gridx = 0;
		c.gridy = 1;
		chart.add(label4, c);
		c.gridx = 2;
		c.gridy = 1;
		chart.add(label5, c);
		c.gridx = 4;
		c.gridy = 1;
		chart.add(label6, c);
		
		c.gridx = 1;
		c.gridy = 3;
		chart.add(homeScreenButton, c);
		
		c.gridx= 3;
		c.gridy = 3;
		chart.add(backButton, c);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(chart);
		//		frame.setLocationRelativeTo(null); 
		
		
	}
	
	public static void main(String[] args)
	{
		new HistoricalPriceView();
	}
	
	
}
