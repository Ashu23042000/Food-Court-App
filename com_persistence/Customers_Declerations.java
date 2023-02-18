package com_persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com_entity.Customer;
import com_entity.Menu;
import com_entity.Order;
import com_entity.Restaurant;

public interface Customers_Declerations {
	
	public Customer login(long PhoneNo, String password) throws ClassNotFoundException, SQLException;
	public boolean signup(Customer customer) throws SQLException, ClassNotFoundException, Exception;
	public int updateDetails(Customer customer) throws ClassNotFoundException, SQLException, Exception;	
	public ArrayList<Restaurant> getRestaurants() throws SQLException, ClassNotFoundException;
	public ArrayList<Menu> getItems(int restaurantId) throws SQLException, ClassNotFoundException;
	public boolean placeOrder(int restaurantId,int customerId) throws ClassNotFoundException, SQLException;	
	public Order getOrderStatus();
	public String paymentMode();
	
	public int generateBill(int orderId) throws ClassNotFoundException, SQLException;
	
	
	public boolean validatePhoneNumber(long phone) throws Exception;
	public boolean validateEmail(String email) throws Exception;
	public boolean validatePassword(String password) throws Exception;
	
	
	public Customer createCustomer();
		
}
