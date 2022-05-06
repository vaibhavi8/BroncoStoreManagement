package model.entities;

public class Professor extends Customer
{
	private String department;
	private String research;
	private int discount;
	
	public Professor(String department, String research, int discount,int broncoID, String name, Address address, boolean profCustomerType) {
		super(broncoID, name, address, profCustomerType);
		this.department = department;
		this.research = research;
		this.discount = discount;
	}
}