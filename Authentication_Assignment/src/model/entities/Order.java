package model.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class Order {

	private int orderID;

	private Date date;

	private Time time;

	private Customer customerName;

	private String listOfProducts;

	private boolean isOnlineOrder;

	private float total_price;

	private float fina_price;

	public void Order(Date date, Time time, Customer customerName, String orderType) {

	}

	public void addProduct(int productID) {

	}

	public void generateReciept() {

	}

	public void deleteOrder(int orderID) {

	}

	public void searchOrder(int orderID) {

	}

	public void updateOrder(int orderID) {

	}

}
