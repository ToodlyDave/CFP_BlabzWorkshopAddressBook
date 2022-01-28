package com.workshop.WorkshopAddressBook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;
import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.entities.Address;
import com.workshop.WorkshopAddressBook.repo.AddressRepository;

@Service
public class AddressServices implements IAddressServices{
	
	@Autowired
	AddressRepository addressRepository;

	// This method is to return a default string 
	@Override
	public ResponseEntity<ResponseDTO> hello() {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO("Welcome to the address book application", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	// This method is to return address book records
	@Override
	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO;
		if (id.isEmpty())
			responseDTO = new ResponseDTO("Fetching all address records", addressRepository.findAll());
		else
			responseDTO = new ResponseDTO("Fetching specific address record", addressRepository.findById(Long.parseLong(id.get())));
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method is to insert a new address record
	@Override
	public ResponseEntity<ResponseDTO> createAddress(AddressDTO address) {
		// TODO Auto-generated method stub
		addressRepository.save(new Address(address));
		ResponseDTO responseDTO = new ResponseDTO("Creating an address book record ", address);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method is to update an address record
	@Override
	public ResponseEntity<ResponseDTO> updateAddress(Optional<String> id, AddressDTO address) {
		// TODO Auto-generated method stub
		addressRepository.save(new Address(Long.parseLong(id.get()), address));
		ResponseDTO responseDTO = new ResponseDTO("Updating data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method is to delete an address record
	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(Optional<String> id) {
		// TODO Auto-generated method stub
		addressRepository.deleteById(Long.parseLong(id.get()));
		ResponseDTO responseDTO = new ResponseDTO("Deleting data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	
}
