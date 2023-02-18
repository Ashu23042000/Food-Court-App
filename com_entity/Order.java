package com_entity;

public class Order {
	
	private int orderId;
	private int orderQuantity;
	private String orderDate;
	private String orderTime;
	private int totalOrderValue;
	private int itemId;
	private int restaurantId;
	private int customerId;
	private String orderPaymentType;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getTotalOrderValue() {
		return totalOrderValue;
	}
	public void setTotalOrderValue(int totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate
				+ ", orderTime=" + orderTime + ", totalOrderValue=" + totalOrderValue + ", itemId=" + itemId
				+ ", restaurantId=" + restaurantId + ", customerId=" + customerId + ", orderPaymentType="
				+ orderPaymentType + "]";
	}

	public Order(int orderId, int orderQuantity, String orderDate, String orderTime, int totalOrderValue, int itemId,
			int restaurantId, int customerId, String orderPaymentType) {
		super();
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.totalOrderValue = totalOrderValue;
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.orderPaymentType = orderPaymentType;
	}

	public String getOrderPaymentType() {
		return orderPaymentType;
	}
	public void setOrderPaymentType(String orderPaymentType) {
		this.orderPaymentType = orderPaymentType;
	}
}
