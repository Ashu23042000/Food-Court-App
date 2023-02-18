package com_services;
import java.sql.SQLException;
import java.util.ArrayList;

import com_entity.Customer;
import com_entity.Menu;
import com_entity.Order;
import com_entity.Restaurant;
import com_persistence.Customers_Implementations;

public class Customers_Service_Implementations implements Customers_Service_Declerations{

	

	

	@Override
	public boolean updateItem(int itemId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItem(int itemId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrderStatus(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Order> getPastOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeOrder(int restaurantId, int customerId) throws ClassNotFoundException, SQLException {
		return new Customers_Implementations().placeOrder(restaurantId, customerId);
	}

	@Override
	public ArrayList<Restaurant> getRestaurants() throws SQLException, ClassNotFoundException {
		return new Customers_Implementations().getRestaurants();
	}

	@Override
	public ArrayList<Menu> getItems(int restaurantId) throws SQLException, ClassNotFoundException {
		return new Customers_Implementations().getItems(restaurantId);
	}

	@Override
	public Customer login(long PhoneNo, String password) throws ClassNotFoundException, SQLException {
		return new Customers_Implementations().login(PhoneNo, password);
	}

	@Override
	public boolean signup(Customer customer) throws SQLException, ClassNotFoundException, Exception {
		return new Customers_Implementations().signup(customer);
	}

	@Override
	public boolean validatePhoneNumber(long phone) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatePassword(String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateDetails(Customer customer) throws ClassNotFoundException, SQLException, Exception {
		return new Customers_Implementations().updateDetails(customer);
	}

	@Override
	public Customer createCustomer() {
		return new Customers_Implementations().createCustomer();
	}
}
