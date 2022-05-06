package model.entities;

public class Customer
{
	private int broncoID;
	private String phone_num;
	private String name;
	private String dob;
	//private Address address;
	private boolean profCustomerType;
	private String phoneNumber;
	
	
	public Customer(int broncoID, String name, boolean profCustomerType,String dob, String phoneNum) {
		this.broncoID = broncoID;
		this.name = name;
		//this.address = address;
		this.profCustomerType = profCustomerType;
		this.dob = dob;
		this.phoneNumber = phoneNum;
		
	}
	
	public void addOrder(int orderID) 
	{
		
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
		//this.address = null;
		this.profCustomerType = true;
	}
	
	public void searchCustomer(int broncoID) 
	{
		
	}
	public String getName()
	{
		return name;
	}
	public int getID()
	{
		return broncoID;
		
	}
	public String getDOB()
	{
		return dob;
	}
	public String getphoneNum ()
	{
		return phoneNumber;
	}
	
	
}