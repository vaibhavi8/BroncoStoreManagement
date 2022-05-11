package model.entities;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestFile 
{
	public static void main(String [] args)
	{
		int broncoID = 138;
		String name = "Person1";
		boolean profCustomerType = false; 
		String dob ="3/13/2022";
		String phoneNum = "62622145"; 
		String address = "Big Sur";
		String city = "City";
		String state = "myState";
		String postal_code = "91723";
		Customer cust = new Customer (broncoID, name, profCustomerType, dob, phoneNum,
									   address, city, state,postal_code);
		ArrayList<Product>cart = new ArrayList<Product>();
		ArrayList<Integer>quantityList = new ArrayList<Integer>();
		quantityList.add(1);
		quantityList.add(2);
		quantityList.add(3);
		
		LocalDate dateNow = LocalDate.now();
		Date date = Date.valueOf(dateNow); 
	    long timeNow = System.currentTimeMillis();
		Time time = new Time (timeNow);
		
		//createProduct(productID, productName, product_date, productDesc, productPrice)
		Product p3 = new Product (13, "Computer mouse",date,"----", (float)22.50 );
		
		cart.add(p3);
		
		int orderID = 6;

	 
	}

}
