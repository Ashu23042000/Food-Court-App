package com_services;

import java.sql.SQLException;
import java.util.ArrayList;

import com_entity.Customer;
import com_entity.Menu;
import com_entity.Order;
import com_entity.Restaurant;


public interface Customers_Service_Declerations {

	public Customer login(long PhoneNo, String password) throws ClassNotFoundException, SQLException;
	public boolean signup(Customer customer) throws SQLException, ClassNotFoundException, Exception;
	public int updateDetails(Customer customer) throws ClassNotFoundException, SQLException, Exception;	
	public boolean updateItem(int itemId,String itemName,int itemPrice);
	public boolean addItem(int itemId,String itemName,int itemPrice);
	public boolean deleteItem(int itemId);
	public boolean updateOrderStatus(int orderId);
	public boolean placeOrder(int restaurantId,int customerId) throws ClassNotFoundException, SQLException;	
	public ArrayList<Order> getPastOrders();
	
	public ArrayList<Restaurant> getRestaurants() throws SQLException, ClassNotFoundException;
	public ArrayList<Menu> getItems(int restaurantId) throws SQLException, ClassNotFoundException;
	
	
	public boolean validatePhoneNumber(long phone) throws Exception;
	public boolean validateEmail(String email) throws Exception;
	public boolean validatePassword(String password) throws Exception;
	
	public Customer createCustomer();
}
