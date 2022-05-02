package model.entities;
import java.util.Date;
import java.util.HashMap;
public class Product {

	private int productID;
	private String productName;
	private int productPrice;	
	private Date dateUpdated;
	private HashMap priceDate_map;

	public void Product(int productID, String productName) 
	{
		this.productID = productID;
		this.productName = productName;
	}

	public int getProductId() 
	{
		return productID;
	}
	
	public void setPrice(float price) 
	{
		this.productPrice = productPrice;
	}

	public void getPriceDateMapVal() 
	{
		
	}

	public void setValMap() 
	{

	}

	public void updateProduct(int productID) 
	{
		
	}

}

