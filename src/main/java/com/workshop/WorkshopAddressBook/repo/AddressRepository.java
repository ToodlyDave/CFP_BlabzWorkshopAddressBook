package com.workshop.WorkshopAddressBook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workshop.WorkshopAddressBook.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	@Query(value = "SELECT * FROM address WHERE CITY = :cityName", nativeQuery = true)
	public List<Address> findAddressByCity(@Param(value = "cityName") String cityName);
}
