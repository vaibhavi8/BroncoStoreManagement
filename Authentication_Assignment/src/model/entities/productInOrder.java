package model.entities;

public class productInOrder 
{
	private int quantity;
	private Order order;
	private Product product;
	private int orderId;
	
	
	public productInOrder (Order o, Product p)
	{
		this.order = o;
		this.product = p;
		this.quantity = quantity;
	}
}
