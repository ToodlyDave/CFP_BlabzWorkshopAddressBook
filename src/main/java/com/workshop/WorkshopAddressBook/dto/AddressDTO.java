package com.workshop.WorkshopAddressBook.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressDTO {

	@NotNull(message = "ERROR: Name cannot be null!")
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid name!")
	String name;
	
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}(, | )?)+$", message = "ERROR: Please enter a valid address!")
	@NotNull(message = "ERROR: Name cannot be null!")
	String address;

	String city;
	String state;
	int zip;
	long phoneNumber;
	String email;
}
