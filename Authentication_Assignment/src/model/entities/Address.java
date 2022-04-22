package model.entities;

public class Address{
	private String street;
	private int number;
	private int zip_code;
	private String city;
	private String state;
	private int addressID;
	
	public Address(String street, int number, int zip_code, String city, String state, int addressID) {
		this.street = street;
		this.number = number;
		this.zip_code = zip_code;
		this.city = city;
		this.state = state;
		this.addressID = addressID;
		
	}
}