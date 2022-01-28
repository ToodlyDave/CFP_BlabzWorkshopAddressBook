package com.workshop.WorkshopAddressBook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String address;

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
