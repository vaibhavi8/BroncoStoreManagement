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
		this.profCustomerType = profCustomerType;
	}
	
	public void addOrder(int orderID) {
		
	}
	
	public boolean isProf() {
		if (profCustomerType == true) {
			return true;
		}
		return false;
	}
	
	public void deleteCustomer(int broncoID) {
		this.broncoID = -1;
		this.name = null;
		this.address = null;
		this.profCustomerType = true;
	}
	
	public void searchCustomer(int broncoID) {
		
	}
	
	
}