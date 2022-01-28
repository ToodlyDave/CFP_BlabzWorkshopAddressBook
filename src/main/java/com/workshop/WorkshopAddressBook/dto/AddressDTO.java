package com.workshop.WorkshopAddressBook.dto;

import javax.persistence.Entity;

public class AddressDTO {

	String name;
	String address;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
