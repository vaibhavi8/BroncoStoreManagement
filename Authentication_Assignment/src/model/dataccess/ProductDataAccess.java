package model.dataccess;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.entities.Product;

public class ProductDataAccess {


	private final static String URL = "jdbc:postgresql://localhost:5432/BSM";
	private final static String USER = "postgres";
	private final static String PWD = "123";
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(URL, USER, PWD);
	    }
	
	public static void createProduct (int productID, String productName, Date product_date, 
	String productDesc, float productPrice) throws ClassNotFoundException, SQLException 
	{
			

		
			String SQL_INSERT = "INSERT INTO product  (product_id, product_name, product_price, prod_description,"
					+ "date_price_updated) VALUES ( ?,?,?,?,?)";
					
			Product product = new Product(productID, productName, product_date, productDesc, productPrice); //productID

			
			
			try {
				
				Connection conn = connect();
				conn.setAutoCommit(false);
				
				final PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
				stmt.setInt(1, product.getProductId());
				stmt.setString(2, product.getProductName());
				stmt.setFloat (3, product.getPrice());
				stmt.setString(4,product.getProductDesc());
				stmt.setDate(5, product.getProductDate());
				//System.out.println("CHECKING PRICE: " +product.getPrice() );
				//System.out.println("ID: " + id);
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
        			double product_price = rs.getDouble("product_price");
        		
        			System.out.println(product_id + "," + product_name + "," + product_price);
        		}	

		} 
		catch (SQLException ex)
		{
            System.out.println(ex.getMessage());
		}
	
	}
	public static ArrayList<String> getAllProducts() throws ClassNotFoundException
	{
		ArrayList<String>dropProductMenu = new ArrayList<String>();
		try {
    		Connection conn = connect();
    		String query = "SELECT *"
    				+ "	FROM product;";
    		PreparedStatement pstmt = conn.prepareStatement(query);
    	
    	
    		ResultSet rs = pstmt.executeQuery();
    		System.out.println("INSIDE GET ALL PRODUCTS");
    		
    		while (rs.next()) 
    		{
    			int product_id = rs.getInt("product_id");
    			String product_name = rs.getString("product_name").trim();
    			String joinedStr = product_id + ", " + product_name;
    			dropProductMenu.add(joinedStr);
				
    			//System.out.println(product_id + "," + product_name 
    								//+ "," + product_price + "," + prodDescr);
    		}	

	} 
	catch (SQLException ex)
	{
        System.out.println(ex.getMessage());
	}
		return dropProductMenu;
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
		//createProduct(1, "Jacket");
		//createProduct(2, "Book");
		//createProduct(3, "Coffee Mug");
	
	

		LocalDate dateNow = LocalDate.now();
	    Date date = Date.valueOf(dateNow); 
		getAllProducts ();
		//createProduct(7, "no product", date, ".............",(float)5.99);
		
		//createProduct(productID, productName, product_date, productDesc, productPrice)

		
		
	}

}
