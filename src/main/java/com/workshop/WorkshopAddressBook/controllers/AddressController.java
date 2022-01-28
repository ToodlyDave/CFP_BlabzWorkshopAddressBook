package com.workshop.WorkshopAddressBook.controllers;

import java.util.Optional;

import javax.validation.Valid;

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

import com.workshop.WorkshopAddressBook.dto.AddressDTO;
import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.service.IAddressServices;

import lombok.extern.slf4j.Slf4j;

// This class is the controller class. The rest controller annotation tells spring boot that this class
// is the controller. We have specified a mapping as well.
@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {
	
	@Autowired
	IAddressServices addressService;

	// This method will return the default welcome message.
	@GetMapping(value = { "", "/", "/home" })
	public ResponseEntity<ResponseDTO> home() {
		log.info(" We are calling the service layer to return the default message ");
		return addressService.hello();
	}

	// This method will call the service layer to return the address records
	@GetMapping(value = {"/get/{id}", "/get"})
	public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {
		log.info(" We are calling the service layer to return address book records ");
		return addressService.getAddress(id);
	}

	// This method will call the service layer to insert a new record into the db
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddress(@Valid @RequestBody AddressDTO address) {
		log.info(" We are calling the service layer to insert a new record ");
		return addressService.createAddress(address);
	}

	// This method will call the service layer to update certain records in the db
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Optional<String> id, @Valid @RequestBody AddressDTO address) {
		log.info(" We are calling the service layer to update the record ");
		return addressService.updateAddress(id, address);
	}

	// This method will call the service layer to delete records 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable Optional<String> id) {
		log.info(" We are calling the service layer to delete an address book record ");
		return addressService.deleteAddress(id);
	}

}
