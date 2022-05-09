package model.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {

	
	private int orderID;
	private int bronco_id;
	private Date order_date;	
	private Time order_time;
	private Customer customerObj;
	private String customerName;
	private ArrayList<Product> productList = new ArrayList<Product>(); // {[productID, quantity]}
	private ArrayList <Integer> quantityList = new ArrayList <Integer>();
	private static HashMap<Integer, Integer > productQuantMap = new HashMap<Integer,Integer >();
	
	private boolean isOnlineOrder;
	private float total_price;
	private float final_price;

	public  Order(int orderId ,Date order_date, Time time, 
			Customer customer, boolean isOnlineOrd, ArrayList<Product> prods,
			ArrayList<Integer> quantityList) 
	{
		this.orderID = orderId;
		this.order_date = order_date;
		this.order_time = time;
		this.customerObj = customer;
		this.customerName = customer.getName();
		this.bronco_id = customer.getID();
		this.isOnlineOrder = isOnlineOrd;
		//add prods
		for (Product prod: prods)
		{
			productList.add(prod);
			this.total_price += prod.getPrice();
		}
		for (int i = 0; i < prods.size(); i++)
		{
			productQuantMap.put(prods.get(i).getProductId()
					, quantityList.get(i));
		}
	
		this.final_price = setFinal_price();
		
	}
	
	public int getOrderID() 
	{
		return orderID;
	}
	public void setOrderID(int orderID) 
	{
		this.orderID = orderID;
	}
	public int getCustomerBronco_id() 
	{
		return  bronco_id;
	}
	public void setCustomer_broncoid(int  bronco_id) 
	{
		this. bronco_id =  bronco_id;
	}
	public Date getOrder_date() 
	{
		return order_date;
	}
	public void setOrder_date(Date order_date) 
	{
		this.order_date = order_date;
	}
	public Time getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Time order_time) {
		this.order_time = order_time;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ArrayList<Product> getProductList() 
	{
		return productList;
	}
	public boolean isOnlineOrder() 
	{
		return isOnlineOrder;
	}
	public void setOnlineOrder(boolean isOnlineOrder) {
		this.isOnlineOrder = isOnlineOrder;
	}
	
	public float getTotal_price() {return total_price ;}
	
	public void setTotal_price(float total_price) {this.total_price = total_price ;}
	
	public float getFinal_price() {return final_price;}
	
	public float setFinal_price() 
	{
		
		if (customerObj.isProf())
		{
			final_price = total_price - total_price * Discount.getProfDiscount();
			System.out.println(" final price" + final_price);
		}
		else
		{
			final_price = total_price - total_price * Discount.getStudDiscount();
			//System.out.println(" final price " + final_price);
		}
		return final_price;
		
	}
	public String toStringProductList()
	{	
		String prodStr = "";
		for (int i = 0; i < productList.size(); i++)
		{
			prodStr += productList.get(i).getProductName() + " ";
		}
		return prodStr;
				
	}
	public Integer getProductQuantity (int productId)
	{
		return productQuantMap.get(productId) ;
	}
	public String generateReciept ()
	{
		String ordReciept = "THANKS FOR SHOPPING AT BRONCO STUDENT STORE !" + 
							"\n---------------------------------------------\n" +
							"Date: " + getOrder_date() + "\tTime:  " + getOrder_time()
							+ "\nOrderId: " + getOrderID()
							+ "\tCustomer Bronco ID: " + getCustomerBronco_id() + "\tCustomerName: " 
							+ getCustomerName() +"\n";
		for (int i = 0; i < productList.size(); i++)
		{
			ordReciept += "Product Name: " +  productList.get(i).getProductName() 
						+ " \tProduct Price: "  + productList.get(i).getPrice() + "\n";
			
		}
		ordReciept += "Total Price: " + getTotal_price ()
					  + "\nPrice After Discount: " + getFinal_price();
		return ordReciept;
		
	}


}
