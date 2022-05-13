package model.entities;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productID;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private float productPrice;
	
	@Column(name="prod_description")
	private String productDesc;
	
	@Column(name="date_price_updated")
	private Date product_date;	
	
	
	

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

