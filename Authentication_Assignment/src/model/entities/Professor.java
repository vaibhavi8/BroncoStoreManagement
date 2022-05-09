package model.entities;

public class Professor extends Customer{
	private String department;
	private String research;
	private String office;
	private float discount = (float) 0.25;

	
	public Professor(String name,String department, String research, String office, 
			int broncoID, String DOB,
			String phoneNum,boolean profCustomerType, String address, 
			String city, String state, String postal_code) 
	{
		super (broncoID, name, profCustomerType, DOB, phoneNum,address,
				city,state,postal_code);
		
		this.department = department;
		this.research = research;
		this.office = office;
		
	}
	
	public String getDept () {return department;}
	public String getResearch () {return research;}
	public float getDiscount () {return discount;}
	public String getOffice () {return office;}
}