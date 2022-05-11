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

import model.dataccess.StudentDataAccess;
import model.entities.Student;
@SuppressWarnings("serial")
public class StudentAddView extends JFrame implements ActionListener{
	
	private JLabel lblName, lblDob, lblPhone, lblAddress, lblAddressLine1, lblCity, lblState, lblPostalCode, lblBroncoID,lblEnterDate, lblGradDate, lblMajor, lblMinor, test;
	private Student std;
	private JPanel info, address, buttons;
	private JFormattedTextField txtName, txtDob, txtPhone, txtAddress, txtAddressLine, txtCity, txtState, txtPostalCode, txtBroncoID,txtEnterDate, txtGradDate, txtMajor, txtMinor;

	
	
	private JButton buttonSubmit, buttonBack;
	
	public StudentAddView() {
		
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
		this.setSize(1000, 600);
//		JFrame frame = new JFrame("Add Student");
		
		this.test = new JLabel("Add Student View Success!");
		this.lblName = new JLabel("Full Name");
		this.lblDob = new JLabel("Birth Date");
		this.lblPhone = new JLabel("Phone Number");
		
		this.lblAddress = new JLabel("Address");
		//this.space = new JLabel("");

		this.lblAddressLine1 = new JLabel("Address Line 1");
		this.lblCity = new JLabel("City");
		this.lblState = new JLabel("State");
		this.lblPostalCode= new JLabel("Postal Code");
		
		
		this.lblBroncoID = new JLabel("Bronco ID");
		this.lblEnterDate = new JLabel("Enter Date");
		this.lblGradDate= new JLabel("Graduation Date");
		this.lblMajor = new JLabel("Major");
		this.lblMinor = new JLabel("Minor");
		
		this.txtName = new JFormattedTextField();
		this.txtDob = new JFormattedTextField();
		this.txtPhone = new JFormattedTextField();	
		//this.txtAddress = new JFormattedTextField();	
		this.txtAddressLine = new JFormattedTextField();	
		this.txtCity = new JFormattedTextField();	
		this.txtState = new JFormattedTextField();	
		this.txtPostalCode = new JFormattedTextField();	
		this.txtBroncoID = new JFormattedTextField();	
		this.txtGradDate= new JFormattedTextField();
		this.txtEnterDate = new JFormattedTextField();
		this.txtMajor =  new JFormattedTextField();	
		this.txtMinor = new JFormattedTextField();	
		
		
		this.buttonSubmit = new JButton("SUBMIT");
		this.buttonSubmit.addActionListener(this);

		this.buttonBack = new JButton("BACK");
		this.buttonBack.addActionListener(this);
		
		
		this.info = new JPanel();
		this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

		//this.address = new JPanel();
		//this.address.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.buttons = new JPanel();
		this.buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));  //CENTER
		
	}	
	private void buildUI() {

		this.info.setLayout(new GridLayout(12,2));
		
		this.info.add(this.lblName);
		this.info.add(this.txtName);
		
		this.info.add(this.lblDob);
		this.info.add(this.txtDob);
		
		this.info.add(this.lblPhone);
		this.info.add(this.txtPhone);
		
		
		//this.info.add(this.lblAddress);
		//this.info.add(this.txtPhone);
		
		
		this.info.add(this.lblAddressLine1);
		this.info.add(this.txtAddressLine);
		
		this.info.add(this.lblCity);
		this.info.add(this.txtCity);
		
		
		this.info.add(this.lblState);
		this.info.add(this.txtState);
		
		
		this.info.add(this.lblPostalCode);
		this.info.add(this.txtPostalCode);
		
		
		this.info.add(this.lblBroncoID);
		this.info.add(this.txtBroncoID);
		
		this.info.add(this.lblEnterDate);
		this.info.add(this.txtEnterDate);
		
		
				
		this.info.add(this.lblGradDate);
		this.info.add(this.txtGradDate);
		
		
		this.info.add(this.lblMajor);
		this.info.add(this.txtMajor);
		
		
		this.info.add(this.lblMinor);
		this.info.add(this.txtMinor);
		
		
		this.buttons.setLayout(new FlowLayout());
		this.buttons.add(this.buttonBack);
		this.buttons.add(this.buttonSubmit);
		
		
		this.setLayout(new BorderLayout());
		add("South", buttons);
		add("Center", info);

		this.setTitle("Add Student");
		//this.setBounds(350, 140, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new StudentAddView();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == this.buttonSubmit) {
			try {
				StudentDataAccess.createStudent (txtName.getText(), Integer.parseInt(txtBroncoID.getText()),
						txtPhone.getText(), false, txtDob.getText(), txtEnterDate.getText(),
						txtGradDate.getText(), txtMajor.getText(), txtMinor.getText(),
						txtAddressLine.getText(), txtCity.getText(), txtState.getText(), 
						txtPostalCode.getText());
						JOptionPane.showMessageDialog(null, "Student Successfully Added", "Student Added", JOptionPane.PLAIN_MESSAGE);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Bronco ID already Exists!", "Duplicate Bronco ID", JOptionPane.ERROR_MESSAGE);
				//else e.printStackTrace();
			}
		}	
		if (event.getSource() == this.buttonBack){
			dispose();
			new CustomerMenuView();
		}
	} 
}
