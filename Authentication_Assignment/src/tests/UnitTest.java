package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import model.dataccess.CreateProduct;
import model.dataccess.OrderDataAccess;

public class UnitTest 
{
	@Test
	public void testProductCreateTrue1() 
	{
		
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		
		assertTrue (CreateProduct.ProductCreate(1, "test1_true", date, "---", (float)10.0));
		
	}
	@Test
	public void testProductCreateFalse1() 
	{
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		
		assertFalse (CreateProduct.ProductCreate(1, "test1_false", date, "---", (float)10.0));
		
	}
	@Test
	public void testProductCreateTrue2() 
	{
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		assertTrue (CreateProduct.ProductCreate(12, "test2_true", date, "---", (float)10.0));
		
	}
	@Test
	public void testProductCreateFalse2() 
	{
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		assertFalse (CreateProduct.ProductCreate(2, "test2_false", date, 
												"---", (float)10.0));
	}
	@Test
	public void testOrderDeleteTrue1() throws ClassNotFoundException 
	{
		//product with orderID = 1 is in db
		assertTrue( OrderDataAccess.deleteOrder(1));
	}
	public void testOrderDeleteTrue2() throws ClassNotFoundException 
	{
		//product with orderID = 2 is in db
		assertTrue( OrderDataAccess.deleteOrder(2));
	}
	public void testOrderDeleteFalse1() throws ClassNotFoundException 
	{
		//product with orderID = 2 is in db
		assertFalse( OrderDataAccess.deleteOrder(100));
	}
	public void testOrderDeleteFalse2() throws ClassNotFoundException 
	{
		//product with orderID = 2 is in db
		assertFalse( OrderDataAccess.deleteOrder(101));
	}

}
