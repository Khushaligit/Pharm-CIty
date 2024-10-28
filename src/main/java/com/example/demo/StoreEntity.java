package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StoreEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
	
	@Column
    private String storeName;
	
	@Column
    private String address;
	
	@Column
    private String medicineName;
	
	@Column
	private String storeCity;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}
	
	

	
}

