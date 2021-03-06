package com.workshop.WorkshopAddressBook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;
import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.entities.Address;
import com.workshop.WorkshopAddressBook.exceptions.AddressNotFoundException;
import com.workshop.WorkshopAddressBook.repo.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServices implements IAddressServices{
	
	@Autowired
	AddressRepository addressRepository;

	// This method is to return a default string 
	@Override
	public ResponseEntity<ResponseDTO> hello() {
		// TODO Auto-generated method stub
		log.info(" We are returning the default message");
		ResponseDTO responseDTO = new ResponseDTO("Welcome to the address book application", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	// This method is to return address book records. It will throw a custom exception in case it doesn't find the id passed.
	@Override
	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		log.info(" We are returning the address book records ");
		ResponseDTO responseDTO;
		if (id.isEmpty())
			responseDTO = new ResponseDTO("Fetching all address records", addressRepository.findAll());
		else {
			Optional<Address> address = addressRepository.findById(Long.parseLong(id.get()));
			responseDTO = new ResponseDTO("Fetching specific address record", address.orElseThrow(
															() -> new AddressNotFoundException("ERROR: Invalid Address")));
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method is to insert a new address record
	@Override
	public ResponseEntity<ResponseDTO> createAddress(AddressDTO address) {
		// TODO Auto-generated method stub
		log.info(" We are inserting a new address book record ");
		addressRepository.save(new Address(address));
		ResponseDTO responseDTO = new ResponseDTO("Creating an address book record ", address);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method is to update an address record. It will throw a custom exception in case it doesn't find the id passed.
	@Override
	public ResponseEntity<ResponseDTO> updateAddress(Optional<String> id, AddressDTO address) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		log.info(" We are updating an existing address book record");
		Optional<Address> add = addressRepository.findById(Long.parseLong(id.get()));
		if (add.isEmpty())
			throw new AddressNotFoundException("ERROR: Invalid Address record id");
		
		addressRepository.save(new Address(Long.parseLong(id.get()), address));
		ResponseDTO responseDTO = new ResponseDTO("Updating data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method is to delete an address record. It will throw a custom exception in case it doesn't find the id passed.
	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(Optional<String> id) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		log.info(" We are deleting an address book record ");
		
		addressRepository.findById(Long.parseLong(id.get())).orElseThrow(() -> new AddressNotFoundException("ERROR: Invalid address record id"));                                  
		
		addressRepository.deleteById(Long.parseLong(id.get()));
		ResponseDTO responseDTO = new ResponseDTO("Deleting data", id.get());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// This method calls the custom query we defined in the repo layer. It will return a list of address records that have 
	// the corresponding city value that is passed to this method.
	@Override
	public ResponseEntity<ResponseDTO> findAddressByCity(String city) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		log.info(" Searching for the address record by city");
		List<Address> addressList = addressRepository.findAddressByCity(city);
		
		if (addressList.size() == 0)
			throw new AddressNotFoundException("ERROR: Address record with city " + city + " not found!");
		ResponseDTO response = new ResponseDTO("Address with city " + city, addressList);
		
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	
}
