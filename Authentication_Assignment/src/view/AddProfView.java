package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddProfView {
	
	private JLabel lblUserName;
	
	private JPanel panel1;
	
	public AddProfView () {
		JFrame frame = new JFrame("Add Professor");
		this.lblUserName = new JLabel("Add Professor View Success!");
		this.panel1 = new JPanel();
		this.lblUserName.setFont(new Font("Arial",Font.PLAIN,25));
		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.panel1.add(this.lblUserName);
		
		frame.getContentPane().add(panel1, BorderLayout.CENTER);
		frame.setBounds(280,120,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	

}
