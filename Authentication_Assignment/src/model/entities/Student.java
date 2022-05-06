package model.entities;
import java.util.*;

public class Student extends Customer{
	private Date enterDate;
	private Date gradDate; 
	private String major;
	private String minor;
	private float discount;
	
	public Student (Date enterDate, Date gradDate, String major, String minor, float discount, int broncoID, String name, Address address, boolean profCustomerType) {
		super(broncoID, name, address, profCustomerType);
		this.enterDate = enterDate;
		this.gradDate = gradDate;
		this.major = major;
		this.minor = minor;
		this.discount = discount;
	}
}