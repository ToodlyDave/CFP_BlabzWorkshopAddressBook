package com.workshop.WorkshopAddressBook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class is the controller class. The rest controller annotation tells spring boot that this class
// is the controller. We have specified a mapping as well.
@RestController
@RequestMapping("/address")
public class AddressController {

	// This method will return the default welcome message.
	@GetMapping(value = {"", "/", "/home"})
	public String home() {
		return "Welcome to the address book program ";
	}
}
