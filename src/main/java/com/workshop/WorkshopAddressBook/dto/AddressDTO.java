package com.workshop.WorkshopAddressBook.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressDTO {

	// All the following fields cannot be null in an address record. This is done by the @NotNull annotation. 
	// Some of the fields even have specific patterns that they must stick to. This is done with the help of the 
	// @Pattern annotation which uses regex patterns to confirm that the values are valid.
	
	@NotNull(message = "ERROR: Name cannot be null!")
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid name!")
	String name;
	
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}(, | )?)+$", message = "ERROR: Please enter a valid address!")
	@NotNull(message = "ERROR: Name cannot be null!")
	String address;

	@NotNull(message = "ERROR: City cannot be null!")
	String city;
	
	@NotNull(message = "ERROR: State cannot be null!")
	String state;
	
	@Pattern(regexp = "^[0-9]{6}$", message = "ERROR: Please enter a valid zip code!")
	@NotNull(message = "ERROR: Zip cannot be null!")
	String zip;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "ERROR: Please enter a valid phone number!")
	@NotNull(message = "ERROR: Phone number cannot be null!")
	String phoneNumber;
	
	@Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "ERROR: Please enter a valid email id!")
	@NotNull(message = "ERROR: Email cannot be null!")
	String email;
}
