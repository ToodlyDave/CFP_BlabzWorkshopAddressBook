package com.workshop.WorkshopAddressBook.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.entities.Address;

@Service
public class AddressServices implements IAddressServices{

	@Override
	public ResponseEntity<ResponseDTO> hello() {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO("Welcome to the address book application", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO("Fetching data", id.orElse("no id"));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> createAddress(Address address) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO("Creating an address book record ", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateAddress(Optional<String> id) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO("Updating data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(Optional<String> id) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO("Deleting data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	
}
