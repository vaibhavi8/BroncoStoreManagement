package model.dataccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Customer;
import model.entities.Professor;

public class ProfessorDataAccess 
{

	static int id = 3;  
	private final static String URL = "jdbc:postgresql://localhost:5432/BSM";
	private final static String USER = "postgres";
	private final static String PWD = "123";
	
	public static Connection connect() throws SQLException, ClassNotFoundException 
	{
			Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(URL, USER, PWD);
	}
	
	public static void createProfessor (String name, int broncoID,
			String office,String phone_num, String department, String research,
			Boolean isProf, String DOB,  String address,
			String city, String state, String postal_code) throws ClassNotFoundException, SQLException 
	{
			

		
			String customer_insert = "INSERT INTO customers("
					+ "bronco_id, phone_num, name, dob, address, city, state, postal_code)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			String professor_insert ="INSERT INTO professor("
					+"bronco_id, department, office, research, name)"
					+ "VALUES (?, ?, ?, ?, ?)";
			
			Customer customer = new Customer(broncoID, name , isProf , DOB , phone_num,
										     address,city, state, postal_code);
			Professor professor = new Professor (name, department, research, office, 
												broncoID, DOB,
												phone_num, true, address, 
												city, state, postal_code);
			
	
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
				
			
				final PreparedStatement stmt2 = conn.prepareStatement(professor_insert);
				
				stmt2.setFloat(1, customer.getID());
				stmt2.setString(2, professor.getDept());	
				stmt2.setString(3, professor.getOffice());
				stmt2.setString (4, professor.getResearch());
				stmt2.setString (5, professor.getName());
				
				int rs2 = stmt2.executeUpdate();
				conn.commit();
	}
	
	public static int deleteProfessor (int id) throws ClassNotFoundException, SQLException
	{	
	    String deleteProfessor = "DELETE FROM professor WHERE bronco_id = ?";
	    String deleteCustomer = "DELETE FROM customers"
	    		+ "	WHERE bronco_id = ?";
	    int affected_rows = 0;
	
	        	Connection conn = connect();
	        	PreparedStatement pstmt1 = conn.prepareStatement(deleteProfessor);
	        	pstmt1.setInt(1, id);
	        	affected_rows = pstmt1.executeUpdate();
	        	
	        	PreparedStatement pstmt2 = conn.prepareStatement(deleteCustomer);
	        	pstmt2.setInt(1, id);
	        	affected_rows = pstmt2.executeUpdate();

	
	     return affected_rows;
		
	}
	
	public static Professor queryProfessor (int id) throws ClassNotFoundException, SQLException
	{
				Professor professor = null;
				Connection conn = connect();
        		String query1 = "SELECT * FROM customers WHERE bronco_id=?";
        		String query2 = "SELECT * From professor where bronco_id = ?";
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
    			String department = "";
				String research = "";
				String office = "";
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
        		 
        			department = rs2.getString("department");
        			research = rs2.getString ("research");
        			office = rs2.getString("office");
					
      
		     
        		}	

				professor = new Professor(name, department, research, office, bronco_id, dob, phone_num, true, address, city, state, postal_code);
        		return professor;
        		
		
    }



	
	
	
	/*
	public static void main(String []args) throws ClassNotFoundException, SQLException
	{
		 String str_date = "2015-03-31";
		 
		
			String name = "Joe";
		 	int broncoId = 521;
		 	String phone_num = "626234123";
		 	String DOB = "10/09/2001";
		 	String office = "A-1";
		 	String dept = "Computer science";
		 	String research = "AI";
		 	String address = "1950 Elm St";
		 	String city = "Walnut";
		 	String state = "California"; 
		 	String postal_code = "9134";
		 	
			
		 			
		 	//createProfessor(name, broncoId, office, phone_num, dept, research ,true, DOB, address,city,state,postal_code);
		 	queryProfessor(222);
		
		 	
		
	}*/
	

}
