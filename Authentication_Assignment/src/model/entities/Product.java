package model.entities;
import java.sql.Date;
import java.util.HashMap;
public class Product {

	private int productID;
	private String productName;
	private float productPrice;
	private String productDesc;
	private Date product_date;	
	private Date dateUpdated;
	private HashMap priceDate_map;

	public Product(int productID, String productName, Date product_date, String productDesc, float productPrice) //productID
	{
		this.productID = productID;
		this.productName = productName;
		this.product_date = product_date;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}
	public void setProductDesc(String productDesc){
		this.productDesc = productDesc;
	}
	public void setProductPrice(float productPrice){
		this.productPrice = productPrice;
	}

	public void setProductDate(Date product_date) 
	{
		this.product_date = product_date;
	}

	public int getProductId() {return productID;}
	public String getProductName() {return productName;}
	public String getProductDesc() {return productDesc;}
	public float getPrice() {return productPrice;}
	public Date getProductDate() {return product_date;}
	
}

