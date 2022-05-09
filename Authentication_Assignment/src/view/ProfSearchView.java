package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.dataccess.ProfessorDataAccess;
import model.entities.Professor;
@SuppressWarnings("serial")
public class ProfSearchView extends JFrame implements ActionListener{
	
	private JLabel lblBroncoID, test;
	private JPanel info, address, buttons;
	private JFormattedTextField  txtBroncoID;

	
	
	private JButton buttonSubmit, buttonBack;
	
	public ProfSearchView() {
		
		this.initializeComponents();
		this.buildUI();
	}
	
	private void initializeComponents() {
//		JFrame frame = new JFrame("Add Student");
		this.setSize(1000, 600);
		this.test = new JLabel("Search customer success!");
		this.lblBroncoID = new JLabel("Enter Bronco ID: ");
		this.txtBroncoID = new JFormattedTextField();
	
		
		
		this.buttonSubmit = new JButton("SUBMIT");
		this.buttonSubmit.addActionListener(this);

		this.buttonBack = new JButton("BACK");
		this.buttonSubmit.addActionListener(this);
		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));


		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}	
	private void buildUI() {

		this.info.setLayout(new GridLayout(3,3));
		
		this.info.add(this.lblBroncoID);
		this.info.add(this.txtBroncoID);
		
		
		
		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonBack);
		this.buttons.add(this.buttonSubmit);
		
		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", info);

		this.setTitle("Search Professor");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ProfSearchView();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSubmit) {
			int bID = Integer.parseInt(txtBroncoID.getText());
			Professor prof = null;
			try {
				System.out.println(bID);
				prof = ProfessorDataAccess.queryProfessor(bID);
				new ProfView(prof);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Bronco ID Doesn't Exist!", "No Bronco ID", JOptionPane.ERROR_MESSAGE);
			}
			
	       

	}
	}

	public void search()
	{
		
	}

}