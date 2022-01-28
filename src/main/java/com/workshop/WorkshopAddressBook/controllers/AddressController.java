package com.workshop.WorkshopAddressBook.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
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

// This class is the controller class. The rest controller annotation tells spring boot that this class
// is the controller. We have specified a mapping as well.
@RestController
@RequestMapping("/address")
public class AddressController {

	// This method will return the default welcome message.
	@GetMapping(value = { "", "/", "/home" })
	public String home() {
		return "Welcome to the address book program ";
	}

	@GetMapping(value = {"/get/{id}", "/get"})
	public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {

		ResponseDTO responseDTO = new ResponseDTO("Fetching data", id.orElse("no id"));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddress() {

		ResponseDTO responseDTO = new ResponseDTO("Creating an address book record ", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Optional<String> id) {

		ResponseDTO responseDTO = new ResponseDTO("Updating data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable Optional<String> id) {

		ResponseDTO responseDTO = new ResponseDTO("Deleting data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
