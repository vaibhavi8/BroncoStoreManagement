package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Customer;
import model.entities.Student;

public class StudentDataAccess2
{
	static int id = 3;
	private final static String URL = "jdbc:postgresql://localhost:5432/BSM";
	private final static String USER = "postgres";
	private final static String PWD = "123";
    
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(URL, USER, PWD);
	    }
	
	public static void createStudent (String name, int broncoID,
			String phone_num, 
			Boolean isProf, String DOB, String enterDate, String gradDate,
			String major, String minor, String address,
			String city, String state, String postal_code) throws ClassNotFoundException, SQLException 
	{
			

		
			String customer_insert = "INSERT INTO customers("
					+ "bronco_id, phone_num, name, dob, address, city, state, postal_code)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			String student_insert ="INSERT INTO student("
					+"bronco_id, enter_date, grad_date, major, name)"
					+"VALUES (?, ?, ?, ?, ?)";
			
			Customer customer = new Customer(broncoID, name , isProf , DOB , phone_num,
										     address,city, state, postal_code);
			Student student = new Student (broncoID,name, DOB, phone_num, enterDate, gradDate, major, 
					minor, false,address, city, state, postal_code);
			System.out.println(id);
			id+=1;
			try {
				
				Connection conn = connect();
				conn.setAutoCommit(false);
				final PreparedStatement stmt1 = conn.prepareStatement(customer_insert);
		
				stmt1.setInt(1, customer.getID());
				stmt1.setString(2, customer.getPhoneNum());	
				stmt1.setString(3, customer.getName());
				stmt1.setString (4, customer.getDOB());
				stmt1.setString (5, customer.getAddress());
				stmt1.setString (6, customer.getCity());
				stmt1.setString (7, customer.getState());
				stmt1.setString (8, customer.getPostalCode());
				
				
				int rs = stmt1.executeUpdate();
				conn.commit();
				
				
			
				
				final PreparedStatement stmt2 = conn.prepareStatement(student_insert);
				
				stmt2.setInt(1, customer.getID());
				stmt2.setString(2, student.getEnterDate());	
				stmt2.setString(3, student.getGradDate());
				stmt2.setString (4, student.getMajor());
				stmt2.setString (5, student.getName());
				
				int rs2 = stmt2.executeUpdate();
				conn.commit();
			}
			catch (SQLException ex)
		    {
				System.out.println(ex.getMessage());
		    }
			
		
		
	}
	
	public static int deleteStudent (String name, int id) throws ClassNotFoundException
	{	
	    String deleteStudent = "DELETE FROM student WHERE bronco_id = ?";
	    String deleteCustomer = "DELETE FROM customers"+ "	WHERE bronco_id = ?";
	    int affected_rows = 0;
	    try {
	        	Connection conn = connect();
	        	PreparedStatement pstmt1 = conn.prepareStatement(deleteStudent);
	        	pstmt1.setInt(1, id);
	        	affected_rows = pstmt1.executeUpdate();
	        	
	        	PreparedStatement pstmt2 = conn.prepareStatement(deleteCustomer);
	        	pstmt2.setInt(1, id);
	        	affected_rows = pstmt2.executeUpdate();

	     } 
	     catch (SQLException ex)
	     {
	            System.out.println(ex.getMessage());
	            System.out.println("Error from delete customer!");
	     }
	     return affected_rows;
		
	}
	
	public Student queryStudent (int id) throws ClassNotFoundException
	{
		Student student = null;
		try {
        		Connection conn = connect();
        		String query = "SELECT * From student";
        		PreparedStatement pstmt = conn.prepareStatement(query);
        	
        		ResultSet rs = pstmt.executeQuery();
				
                while(rs.next())
                {
					if(rs.getInt("bronco_id") == id)
					{
						student = new Student(rs.getInt("bronco_id"), 
								rs.getString("name"), "", rs.getString("enter_date"), 
								rs.getString("grad_date"), rs.getString("major"), "",
								query, true, "1981 YOUR MOM STREET", "Pomona", "CA", "91939");
					}
                }
		} 
		catch (SQLException ex)
		{
            System.out.println(ex.getMessage());
		}

		return student;
     }

	
	
	
	
	public static void main(String []args) throws ClassNotFoundException, SQLException
	{
		Student stud = null;
		StudentDataAccess2 student = new StudentDataAccess2();
		stud = student.queryStudent(89);
	    System.out.println(stud.getName());
	}
	

}

