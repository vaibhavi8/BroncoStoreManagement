

package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CustomerMenuView extends JFrame implements ActionListener {
	
	private JButton buttonSearchStudent, buttonSearchProfessor, buttonAStudent, 
	buttonAProfessor, buttonDeleteStudent, buttonDeleteProfessor, buttonHome;
	
//	private JFrame frame;

	private JPanel panel;
	
	public CustomerMenuView() {

		this.initializeComponents();
		this.buildUI();
	}

	private void initializeComponents() {
		
		//frame = new JFrame();
		this.setSize(1000, 600);
		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

	
		this.buttonAStudent = new JButton("Add Student");
		this.buttonAStudent.addActionListener(this);

		this.buttonAProfessor = new JButton("Add Professor");
		this.buttonAProfessor.addActionListener(this);

		this.buttonSearchStudent = new JButton("Search Student");
		this.buttonSearchStudent.addActionListener(this);

		this.buttonSearchProfessor = new JButton("Search Professor");
		this.buttonSearchProfessor.addActionListener(this);

		this.buttonDeleteStudent = new JButton("Delete Student");
		this.buttonDeleteStudent.addActionListener(this);

		this.buttonDeleteProfessor = new JButton("Delete Professor");
		this.buttonDeleteProfessor.addActionListener(this);

		this.buttonHome = new JButton("HOME");
		this.buttonHome.addActionListener(this);


//		this.panel1 = new JPanel();
//		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

//		this.panel2 = new JPanel();
//		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

//		this.panel3 = new JPanel();
//		this.panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

//		this.panel4 = new JPanel();
//		this.panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));

	}

	private void buildUI() {


		GridBagConstraints c = new GridBagConstraints();
		c.insets =  new Insets(15, 15, 15, 15);
		c.gridx = 0;
		c.gridy = 0;
		this.panel.add(buttonAStudent, c);
    	c.gridx = 1;
		c.gridy = 0;
		this.panel.add(buttonSearchStudent, c);
		c.gridx = 2;
		c.gridy = 0;
		this.panel.add(buttonDeleteStudent, c);
		c.gridx = 0;
		c.gridy = 1;
		this.panel.add(buttonAProfessor, c);
		c.gridx = 1;
		c.gridy = 1;
		this.panel.add(buttonSearchProfessor, c);
		c.gridx = 2;
		c.gridy = 1;
		this.panel.add(buttonDeleteProfessor, c);
		c.gridx = 2;
		c.gridy = 2;
		this.panel.add(buttonHome, c);

	

//		this.panel1.add(this.buttonSearchStudent);
//		this.panel1.add(this.buttonSearchProfessor);
//		this.panel2.add(this.buttonAStudent);
//		this.panel2.add(this.buttonAProfessor);
		
//		this.panel2.add(this.buttonDeleteStudent);
//		this.panel2.add(this.buttonDeleteProfessor);
//		this.panel4.add(this.buttonHome);


//		this.getContentPane().add(panel1, BorderLayout.NORTH);
//		this.getContentPane().add(panel2, BorderLayout.CENTER);
//		this.getContentPane().add(panel3, BorderLayout.CENTER);
//		this.getContentPane().add(panel4, BorderLayout.SOUTH);

//		this.setTitle("CustomerMenu");
//		this.setBounds(350, 140, 500, 500);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
//		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(panel);

	}

	public static void main(String[] args) {
		new CustomerMenuView();
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonSearchStudent) {
			new StudentSearchView();
		}
		if (event.getSource() == this.buttonSearchProfessor) {
			new ProfSearchView();
		}
		if (event.getSource() == this.buttonAStudent) {
			new StudentAddView();
		}
		if (event.getSource() == this.buttonAProfessor){
			new ProfAddView();
		}
		if (event.getSource() == this.buttonDeleteProfessor){
			new ProfessorDeleteView();
		}
		if (event.getSource() == this.buttonDeleteStudent){
			new StudentDeleteView();
		}
	 
	}
	
}

