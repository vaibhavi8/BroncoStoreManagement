package model.dataccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import model.entities.Customer;
import model.entities.Order;
import model.entities.Product;

public class OrderDataAccess 
{
	private final static String URL = "jdbc:postgresql://localhost:5432/BSM";
	private final static String USER = "postgres";
	private final static String PWD = "123";
	
	public static Connection connect() throws SQLException, ClassNotFoundException 
	{
			Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(URL, USER, PWD);
	}
	
	
	public static void createOrder (int orderID, Date date, Time time, 
			Customer customer, boolean isOnlineOrd, ArrayList<Product> prods,
			ArrayList<Integer> quant) throws ClassNotFoundException
	{
		Order myOrder = new Order (orderID, date, time, customer, isOnlineOrd, prods,quant);
		String insert_order = "INSERT INTO orders("
			 					+"order_id, date, time, final_price, bronco_id, product_list)"
			 					+"VALUES (?, ?, ?, ?, ?, ?)";
		String insert_ord_dets = "INSERT INTO order_details("
								+ "	product_id, order_id, quantity)\n"
								+ "	VALUES (?, ?, ?)";
		try {
			
			Connection conn = connect();
			conn.setAutoCommit(false);
			final PreparedStatement stmt1 = conn.prepareStatement(insert_order);
			final PreparedStatement stmt2 = conn.prepareStatement(insert_ord_dets);
			
			stmt1.setInt(1, myOrder.getOrderID());
			stmt1.setDate(2, myOrder.getOrder_date());	
			stmt1.setTime(3, myOrder.getOrder_time());
			stmt1.setFloat (4, myOrder.getFinal_price());
			stmt1.setInt (5, customer.getID());
			
			stmt1.setString (6, myOrder.toStringProductList());
			int rs1 = stmt1.executeUpdate();
			conn.commit();
			
			for (int i = 0; i < prods.size(); i++)
			{
				stmt2.setInt(1,prods.get(i).getProductId());
				stmt2.setInt(2, orderID);
				stmt2.setInt(3,quant.get(i) );
				int rs2 = stmt2.executeUpdate();
				conn.commit();
			}
			System.out.println(myOrder.generateReciept());
		
		
	
		}
		catch (SQLException ex)
	    {
			System.out.println(ex.getMessage());
	    }
	}
	public static int deleteOrder (int orderId) throws ClassNotFoundException
	{
		   String deleteOrder = "DELETE FROM orders WHERE order_id = ?";
		  
		    int affected_rows = 0;
		    try {
		        	Connection conn = connect();
		        	PreparedStatement pstmt1 = conn.prepareStatement(deleteOrder);
		        	pstmt1.setInt(1, orderId);
		        	affected_rows = pstmt1.executeUpdate();
		        	
		     

		     } 
		     catch (SQLException ex)
		     {
		            System.out.println(ex.getMessage());
		            System.out.println("Error from delete Order!");
		     }
		     return affected_rows;
			
	}
	
	public static void main(String []args) throws ClassNotFoundException
	{
		int broncoID = 1;
		String name = "Robert Toribio";
		boolean profCustomerType = false; 
		String dob ="--/--/--";
		String phoneNum = "62622145"; 
		String address = "123 College St.";
		String city = "Pomona";
		String state = "CA";
		String postal_code = "917123";
		Customer cust = new Customer (broncoID, name, profCustomerType, dob, phoneNum,
									   address, city, state,postal_code);
		ArrayList<Product>cart = new ArrayList<Product>();
		LocalDate dateNow = LocalDate.now();
		Date date = Date.valueOf(dateNow); 
	    long timeNow = System.currentTimeMillis();
		Time time = new Time (timeNow);
		
		//createProduct(productID, productName, product_date, productDesc, productPrice)
		Product p1 = new Product (1, "Bronco Energy Drink", date,"----", (float)4.50 );
		Product p2 = new Product (2, "Algorithms Book",date,"----", (float)250.50 );
		Product p3 = new Product (3, "Scantron" ,date,"----", 20 );
		
		cart.add(p1);
		cart.add(p2);
		cart.add(p3);
		
	
		ArrayList<Integer>quantityList = new ArrayList<Integer>();
		quantityList.add(3);
		quantityList.add(1);
		quantityList.add(5);
		
		createOrder (1 ,date,time,cust,false,cart, quantityList);
				
	}

}
