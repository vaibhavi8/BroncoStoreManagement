package model.entities;

public class Student extends Customer{

	private String enterDate;
	private String gradDate; 
	private String major;
	private String minor;

	// hardcoded for testing purposes
	private float discount = (float) 0.25;
	

	
	public Student(int broncoID, String name, String DOB,String phone_num, String enterDate, String gradDate, String major, 
			String minor, boolean profCustomerType, String address,
			String city, String state, String postal_code) 
	{
		
		super(broncoID, name, false,DOB, phone_num ,address,
				city, state, postal_code);
		this.enterDate = enterDate;
		this.gradDate = gradDate;
		this.major = major;
		this.minor = minor;
		this.discount = discount;
	}
	
	public String getEnterDate() {return enterDate;}
	public String getGradDate () {return gradDate;}
	public String getMajor () {return major;}
	public String getMinor () {return minor;}
	public float getDiscount () {return discount;}
}