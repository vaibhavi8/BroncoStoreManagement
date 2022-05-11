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
@SuppressWarnings("serial")
public class ProfessorDeleteView extends JFrame implements ActionListener{
	
	private JLabel lblID; 
	private JPanel info, buttons;
	private JFormattedTextField txtID;
	
	private JButton buttonSubmit, buttonBack;
	
	public ProfessorDeleteView() {
		
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
		this.setSize(1000, 600);
		this.lblID = new JLabel("Professor ID");
        this.txtID = new JFormattedTextField();
		
		
		this.buttonSubmit = new JButton("SUBMIT");
		this.buttonSubmit.addActionListener(this);

		this.buttonBack = new JButton("BACK");
		this.buttonBack.addActionListener(this);
		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));  //CENTER
		
	}	
	private void buildUI() {

		this.info.setLayout(new GridLayout(12,2));
		this.info.add(this.lblID);
		this.info.add(this.txtID);

		
		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonBack);
		this.buttons.add(this.buttonSubmit);
		
		
		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", info);

		this.setTitle("Delete Professor");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ProfessorDeleteView();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	  if (event.getSource() == this.buttonSubmit) {
			try {
				int profID = Integer.parseInt(txtID.getText());
				ProfessorDataAccess.deleteProfessor(profID);
				JOptionPane.showMessageDialog(null, "Professor Successfully Deleted", "Professor Deleted", JOptionPane.PLAIN_MESSAGE);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Bronco ID Doesn't Exist!", "No Bronco ID", JOptionPane.ERROR_MESSAGE);
				//else e.printStackTrace();
			}
		}
   
   
   
   
   
    if (event.getSource() == this.buttonBack){
      dispose();
      new CustomerMenuView();
    }
  
  }

}
