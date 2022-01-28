package com.workshop.WorkshopAddressBook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String address;

	public Address() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Address(long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Address(long id, AddressDTO address) {
		super();
		this.id = id;
		this.name = address.getName();
		this.address = address.getAddress();
	}

	public Address(AddressDTO address) {
		super();
		this.name = address.getName();
		this.address = address.getAddress();
	}

}
