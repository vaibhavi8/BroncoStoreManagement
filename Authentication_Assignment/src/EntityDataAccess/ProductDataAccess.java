package EntityDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Product;

public class ProductDataAccess
{	
	static int id = 1 ;
	private final static String URL = "jdbc:postgresql://localhost:5432/BSM";
	private final static String USER = "postgres";
	private final static String PWD = "123";
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(URL, USER, PWD);
	    }
	
	public static void createProduct (String productName, int productID ) throws ClassNotFoundException, SQLException 
	{
			
		
		
			String SQL_INSERT = "INSERT INTO product (product_id, product_name) VALUES (?, ?)";
			Product product = new Product(productID, productName);
			System.out.println(id);
			
			try {
				
				Connection conn = connect();
				conn.setAutoCommit(false);
				
				final PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
				stmt.setInt(1, product.getProductId());
				stmt.setString(2, product.getProductName());	
				System.out.println("ID: " + id);
				int rs = stmt.executeUpdate();
				conn.commit();
			}
			catch (SQLException ex)
		    {
				System.out.println(ex.getMessage());
		    }
			
		
		
	}
	public static int deleteProduct (String name, int id) throws ClassNotFoundException
	{	
	    String SQL = "DELETE FROM product WHERE product_id = ?";
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
	public static void queryProduct (int id) throws ClassNotFoundException
	{
	
		try {
        		Connection conn = connect();
        		String query = "SELECT * FROM product WHERE product_id=?";
        		PreparedStatement pstmt = conn.prepareStatement(query);
        		pstmt.setInt(1, id);
        	
        		ResultSet rs = pstmt.executeQuery();
        		
        		if (rs.next()) 
        		{
				
        		int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				float product_price = rs.getFloat("product_price");
		        System.out.println(product_id + "," + product_name );
        		}	

		} 
		catch (SQLException ex)
		{
            System.out.println(ex.getMessage());
		}
	
	}
	public static void updateProductPrice (int id, float newPrice) throws ClassNotFoundException
	{
		try {
			Connection conn = connect();
			final PreparedStatement stmt = conn.prepareStatement("UPDATE product set product_price = ?"
				+ " WHERE product_id = ?");
			stmt.setFloat(1, newPrice);
			stmt.setInt(2, id);	
			stmt.executeUpdate();
			
			conn.commit();
			
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String []args) throws ClassNotFoundException, SQLException
	{
		//createProduct("Jacket", 1);
		//createProduct("Book", 2);
		//createProduct("Coffee Mug",3);
		//createProduct("Monster Energy Drink", 4);
		updateProductPrice(4, (float)5.25);
		updateProductPrice(1,(float) 35.50);
		updateProductPrice (2, (float)300.50);
		updateProductPrice(3,(float)10.50);
		
		
	}
	

}
