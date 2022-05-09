package EntityDataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Customer;

public class CustomerDataAccess
{	
	static int id = 3 ;
	private final static String URL = "jdbc:postgresql://localhost:5432/BSM";
	private final static String USER = "postgres";
	private final static String PWD = "123";
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(URL, USER, PWD);
	    }
	
	public static void createCustomer (String name, String date, String phone, Boolean isProf) throws ClassNotFoundException, SQLException 
	{
		
			String customer_insert = "INSERT INTO customers(bronco_id, phone_num, name, dob) VALUES "
					+ "	(?, ?, ?, ?)";
			
			Customer customer = new Customer(id, name , isProf , date , phone );
			System.out.println(id);
			id+=1;
			try {
				
				Connection conn = connect();
				conn.setAutoCommit(false);
				final PreparedStatement stmt = conn.prepareStatement(customer_insert);
				if (customer.isProf())
				{
					
				}
				else 
				{
					
				}
				stmt.setInt(1, customer.getID());
				stmt.setString(2, customer.getphoneNum());	
				stmt.setString(3, customer.getName());
				stmt.setString (4, customer.getDOB());
				System.out.println("ID: " + id);
				int rs = stmt.executeUpdate();
				conn.commit();
			}
			catch (SQLException ex)
		    {
				System.out.println(ex.getMessage());
		    }
			
		
		
	}
	public static void createProfessor(	String department, String research, String office,float discount) throws ClassNotFoundException, SQLException
	{
		String professor_insert = "INSERT INTO professor(bronco_id, department, office, research)"
				+ "VALUES (?, ?, ?, ?)";
		Connection conn = connect();
		conn.setAutoCommit(false);
		final PreparedStatement stmt = conn.prepareStatement(professor_insert);
	}
	public static int deleteCustomer (String name, int id) throws ClassNotFoundException
	{	
	    String SQL = "DELETE FROM customers WHERE bronco_id = ?";
	    int affected_rows = 0;
	    try {
	        	Connection conn = connect();
	        	PreparedStatement pstmt = conn.prepareStatement(SQL);
	        	pstmt.setInt(1, id);
	        	affected_rows = pstmt.executeUpdate();

	     } 
	     catch (SQLException ex)
	     {
	            System.out.println(ex.getMessage());
	            System.out.println("Error from delete customr!");
	     }
	     return affected_rows;
		
	}
	public static void queryCustomer (int id) throws ClassNotFoundException
	{
	
		try {
        		Connection conn = connect();
        		String query = "SELECT * FROM customers WHERE bronco_id=?";
        		PreparedStatement pstmt = conn.prepareStatement(query);
        		pstmt.setInt(1, id);
        	
        		ResultSet rs = pstmt.executeQuery();
        		
        	if (rs.next()) {
				
        		int bronco_id = rs.getInt("bronco_id");
				String name = rs.getString("name");
		        String phone_num= rs.getString("phone_num");
		        String dob = rs.getString("dob");
		        System.out.println(bronco_id + "," + name + ", " + phone_num + ", " + dob);
		    }	

     } 
     catch (SQLException ex)
     {
            System.out.println(ex.getMessage());
     }
	
	
	
	
	}
	public static void main(String []args) throws ClassNotFoundException, SQLException
	{
		 String str_date = "2015-03-31";
		//createCustomer("Joel Joshy", str_date , "6263848619", false );
		//createCustomer("Professor Marin", str_date , "626981123", true );
		
	
		 queryCustomer(2);
	}
	

}