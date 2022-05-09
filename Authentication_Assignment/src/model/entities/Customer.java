package model.entities;

public class Customer
{
	private int broncoID;
	private String phone_num;
	private String name;
	private String dob;
	private String address_line ;
	private String city;
	private String state;
	private String postal_code;
	private boolean profCustomerType;

	
	
	public Customer(int broncoID, String name, boolean profCustomerType, 
			String dob, String phoneNum, String address,
			String city, String state, String postal_code) {
		this.broncoID = broncoID;
		this.name = name;
		//this.address = address;
		this.profCustomerType = profCustomerType;
		this.dob = dob;
		this.phone_num = phoneNum;
		this.address_line = address;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		
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
	public String getPhoneNum ()
	{
		return phone_num;
	}
	public String getAddress() {return address_line;}
	public String getCity() {return city;}
	public String getState() {return state;}
	public String getPostalCode() {return postal_code;}
	
	
	
}