package com.workshop.WorkshopAddressBook.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.entities.Address;
import com.workshop.WorkshopAddressBook.service.IAddressServices;

// This class is the controller class. The rest controller annotation tells spring boot that this class
// is the controller. We have specified a mapping as well.
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	IAddressServices addressService;

	// This method will return the default welcome message.
	@GetMapping(value = { "", "/", "/home" })
	public ResponseEntity<ResponseDTO> home() {
		return addressService.hello();
	}

	@GetMapping(value = {"/get/{id}", "/get"})
	public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {

		return addressService.getAddress(id);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddress(@RequestBody Address address) {

		return addressService.createAddress(address);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Optional<String> id) {

		return addressService.updateAddress(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable Optional<String> id) {

		return addressService.deleteAddress(id);
	}

}
