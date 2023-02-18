package com_entity;

public class Restaurant {
	private int restautrantId;
	private String restautrantName;
	private long restautrantPhone;
	private String restautrantAddress;
	private String restautrantEmail;
	private String restautrantPassword;
	private String restautrantCity;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(int restautrantId, String restautrantName, long restautrantPhone, String restautrantAddress,
			String restautrantEmail, String restautrantPassword, String restautrantCity) {
		super();
		this.restautrantId = restautrantId;
		this.restautrantName = restautrantName;
		this.restautrantPhone = restautrantPhone;
		this.restautrantAddress = restautrantAddress;
		this.restautrantEmail = restautrantEmail;
		this.restautrantPassword = restautrantPassword;
		this.restautrantCity = restautrantCity;
	}
	
//	@Override
//	public String toString() {
//		return "Restaurant [restautrantId=" + restautrantId + ", restautrantName=" + restautrantName
//				+ ", restautrantPhone=" + restautrantPhone + ", restautrantAddress=" + restautrantAddress
//				+ ", restautrantEmail=" + restautrantEmail + ", restautrantPassword=" + restautrantPassword
//				+ ", restautrantCity=" + restautrantCity + "]";
//	}
	
	@Override
	public String toString() {
		return "Restaurant [restautrantId=" + restautrantId + ", restautrantName=" + restautrantName+ "]";
	}
	
	
	public int getRestautrantId() {
		return restautrantId;
	}
	public void setRestautrantId(int restautrantId) {
		this.restautrantId = restautrantId;
	}
	public String getRestautrantName() {
		return restautrantName;
	}
	public void setRestautrantName(String restautrantName) {
		this.restautrantName = restautrantName;
	}
	public long getRestautrantPhone() {
		return restautrantPhone;
	}
	public void setRestautrantPhone(long restautrantPhone) {
		this.restautrantPhone = restautrantPhone;
	}
	public String getRestautrantAddress() {
		return restautrantAddress;
	}
	public void setRestautrantAddress(String restautrantAddress) {
		this.restautrantAddress = restautrantAddress;
	}
	public String getRestautrantEmail() {
		return restautrantEmail;
	}
	public void setRestautrantEmail(String restautrantEmail) {
		this.restautrantEmail = restautrantEmail;
	}
	public String getRestautrantPassword() {
		return restautrantPassword;
	}
	public void setRestautrantPassword(String restautrantPassword) {
		this.restautrantPassword = restautrantPassword;
	}
	public String getRestautrantCity() {
		return restautrantCity;
	}
	public void setRestautrantCity(String restautrantCity) {
		this.restautrantCity = restautrantCity;
	}
	
	
	
}
