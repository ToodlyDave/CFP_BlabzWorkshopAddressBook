package com.workshop.WorkshopAddressBook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.WorkshopAddressBook.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
