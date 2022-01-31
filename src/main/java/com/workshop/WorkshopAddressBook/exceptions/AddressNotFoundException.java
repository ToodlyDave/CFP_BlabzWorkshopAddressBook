package com.workshop.WorkshopAddressBook.exceptions;

// This is a custom exception for not being able to find the address.
public class AddressNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(String message) {
		super(message);
	}
}
