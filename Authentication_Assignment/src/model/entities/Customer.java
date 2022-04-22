package model.entities;

public class Customer{
	private int broncoID;
	private String phone_num;
	private String name;
	private Address address;
	private boolean profCustomerType;
	
	public Customer(int broncoID, String name, Address address, boolean profCustomerType) {
		this.broncoID = broncoID;
		this.name = name;
		this.address = address;
		this.profCustomerType = profCustomerType;;
	}
	
	
}