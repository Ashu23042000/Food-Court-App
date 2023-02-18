package com_services;

import java.util.ArrayList;

import com_entity.Order;
import com_entity.Restaurant;

public interface Restaurants_Service_Declerations {
	public Restaurant login(long phone, String password);
	public boolean signup(String name,long phone,String address,String email, String password);
	
	public boolean updatePersonalDetails(String name,long phone,String address,String email, String password);	
	public boolean updateItem(int itemId,String itemName,int itemPrice);
	public boolean addItem(int itemId,String itemName,int itemPrice);
	public boolean deleteItem(int itemId);

	public boolean updateOrderStatus(int orderId);
	public ArrayList<Order> getPastOrders();
}
