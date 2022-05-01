

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

@SuppressWarnings("serial")
public class CustomerMenuView extends JFrame implements ActionListener {
	
	private JButton buttonSearch, buttonAStudent, buttonAProfessor;
	private JFrame frame;

	//private JTextField txtUserName, txtPassword;

	private JPanel panel1, panel2, panel3;
	
	public CustomerMenuView() {

		this.initializeComponents();

		this.buildUI();
	}

	private void initializeComponents() {
		
//		this.lblUserName = new JLabel("Username:   ");
//		this.lblPassword = new JLabel("Password:   ");
		

		

		this.buttonSearch = new JButton("Search");
		this.buttonSearch.addActionListener(this);

		this.buttonAStudent = new JButton("Add Student");
		this.buttonAStudent.addActionListener(this);

		this.buttonAProfessor = new JButton("Add Professor");
		this.buttonAProfessor.addActionListener(this);

//		this.txtUserName = new JTextField(23);
//		this.txtPassword = new JTextField(23);

		this.panel1 = new JPanel();
		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

	}

	private void buildUI() {

		this.panel1.add(this.buttonSearch);
	
		this.panel2.add(this.buttonAStudent);
		this.panel2.add(this.buttonAProfessor);


		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel2, BorderLayout.CENTER);

		this.setTitle("CustomerMenu");
		this.setBounds(350, 140, 550, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerMenuView();
	}

	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSearch) {
			new CustomerSearchView();
		}
		if (event.getSource() == this.buttonAStudent) {
			new AddStudentView();
		}
		if (event.getSource() == this.buttonAProfessor) {
			new AddProfView();
		}
	 
//		else if(event.getSource() == this.buttonAStudent) {
//			try {
//				new AddStudentView();
//			} catch (MessageException e) {
//					JOptionPane.showMessageDialog (null, e.getMessage());
//				} catch (ClassNotFoundException e) {
//					JOptionPane.showMessageDialog (null, e.getMessage());
//				} catch (SQLException e) {
//					JOptionPane.showMessageDialog (null, e.getMessage());
//				}
//		}
//		else if(evet)
//			
	}
	
}

