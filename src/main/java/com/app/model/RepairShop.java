package com.app.model;

import jakarta.persistence.*;


@Entity
public class RepairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String shopName;
    private String location;
    private String contactNumber;
    private String serviceType;
    
    
	public RepairShop(int id, String shopName, String location, String contactNumber, String serviceType) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.location = location;
		this.contactNumber = contactNumber;
		this.serviceType = serviceType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
    
}
