package com_entity;

public class Menu {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int restaurantId;
	
	public Menu(int itemId, String itemName, int itemPrice, int restaurantId) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.restaurantId = restaurantId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Menu [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", restaurantId="
				+ restaurantId + "]";
	}
	
}
