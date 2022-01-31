package com.workshop.WorkshopAddressBook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// This is the entity class. The table in the sql will be based on this class. The entity annotation is used to mark this 
// class as an entity class. We're using lombok to generate a couple of getters and constructors as well.

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	// This field is the primary key. This is done by using the @Id annotation. We are using the @GeneratedValue to 
	// automatically generate the id values.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String address;
	String city;
	String state;
	int zip;
	
	// We use the column annotation to make sure the name of this particular field is correct.
	@Column(name = "phone_number")
	long phoneNumber;
	String email;

	// This is a custom constructor to be used in the service layer.
	public Address(long id, AddressDTO address) {
		super();
		this.id = id;
		this.name = address.getName();
		this.address = address.getAddress();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = Integer.parseInt(address.getZip() );
		this.phoneNumber = Long.parseLong(address.getPhoneNumber() );
		this.email = address.getEmail();
	}

	public Address(AddressDTO address) {
		super();
		this.name = address.getName();
		this.address = address.getAddress();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = Integer.parseInt(address.getZip() );
		this.phoneNumber = Long.parseLong(address.getPhoneNumber() );
		this.email = address.getEmail();
	}

}
