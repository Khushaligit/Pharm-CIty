package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<StoreEntity, Long>{
	
	 @Query("SELECT s FROM StoreEntity s WHERE " +
	           "(:storeCity IS NULL OR s.storeCity = :storeCity) AND " +
	           "(:storeName IS NULL OR s.storeName = :storeName) AND " +
	           "(:address IS NULL OR s.address = :address) AND " +
	           "(:medicineName IS NULL OR s.medicineName = :medicineName)")
	    List<StoreEntity> findByCriteria(String storeCity, String storeName, String address, String medicineName);
	
}

