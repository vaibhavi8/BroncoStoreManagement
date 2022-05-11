package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Customer;
import model.entities.Student;

public class StudentDataAccess 
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
	
	public static int deleteStudent (int id) throws ClassNotFoundException, SQLException
	{	
	    String deleteStudent = "DELETE FROM student WHERE bronco_id = ?";
	    String deleteCustomer = "DELETE FROM customers"
	    		+ "	WHERE bronco_id = ?";
	    int affected_rows = 0;
	
	    Connection conn = connect();
	    PreparedStatement pstmt1 = conn.prepareStatement(deleteStudent);
	    pstmt1.setInt(1, id);
	    affected_rows = pstmt1.executeUpdate();
	    PreparedStatement pstmt2 = conn.prepareStatement(deleteCustomer);
	    pstmt2.setInt(1, id);
	    affected_rows = pstmt2.executeUpdate();
	    return affected_rows;
		
	}
	
	public static Student queryStudent (int id) throws ClassNotFoundException, SQLException
	{
		Student student = null;
		Connection conn = connect();
		String query1 = "SELECT * FROM customers WHERE bronco_id=?";
		String query2 = "SELECT * From student where bronco_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(query1);
        PreparedStatement pstmt2 = conn.prepareStatement(query2);
        pstmt.setInt(1, id);
       pstmt2.setInt(1, id);
        	
       ResultSet rs = pstmt.executeQuery();
        	
        		int bronco_id = 0;
    			String name ="";
    			String phone_num="";
    			String dob = "";
    			String enter_date="stuff";
    			String grad_date="stuff";
    			String major="stuff";
				String minor="";
				String address = "";
				String city = "";
				String state = "";
				String postal_code = "";
        		
    			if (rs.next()) 
        		{
				
        			 bronco_id = rs.getInt("bronco_id");
        			 name = rs.getString("name");
        			 phone_num= rs.getString("phone_num");
        			 dob = rs.getString("dob");
					 address = rs.getString("address");
					 city = rs.getString("city");
					 state = rs.getString("state");
					 postal_code = rs.getString("postal_code");

		     
        		}	
        		ResultSet rs2 = pstmt2.executeQuery();
        		
        		if (rs2.next()) 
        		{
        		 
        			enter_date = rs2.getString("enter_date");
        			grad_date = rs2.getString ("grad_date");
        			major = rs2.getString("major");
					
        		}	

				student = new Student(bronco_id, name, dob, phone_num, 
						enter_date, grad_date, major, "", true, address, 
						city, state, postal_code);
        		return student;
    
     }

	
	
	
	/*
	public static void main(String []args) throws ClassNotFoundException, SQLException
	{
		 String str_date = "2015-03-31";
		 
		
			String name = "Rida";
		 	int broncoId = 223;
		 	String phone_num = "626234123";
		 	String DOB = "10/09/2001";
		 	String enterDate = str_date;
		 	String gradDate = "12/20/2022";
		 	String major = "CS";
		 	String minor = "math";
		 	String address = "1950 Elm St";
		 	String city = "Walnut";
		 	String state = "California"; 
		 	String postal_code = "9134";


		 	StudentDataAccess std = new StudentDataAccess();
			Student student = std.queryStudent(89);
			System.out.println("Name:" + student.getName() +" BroncoId: "
        							+ student.getID()+ " Phone: " + student.getPhoneNum()
        							+" DOB " + student.getDOB());	
        		System.out.println("Enter Date: " + student.getEnterDate()
        							+" Grad Date: "+ student.getGradDate()
        							+ " Major: " + student.getMajor());
		 			
		 	///createStudent (name, broncoId, phone_num,false, DOB, enterDate,
		 			//gradDate, major,minor, address,city,state,postal_code);
		 	;
		
	
		
	}*/
	

}
