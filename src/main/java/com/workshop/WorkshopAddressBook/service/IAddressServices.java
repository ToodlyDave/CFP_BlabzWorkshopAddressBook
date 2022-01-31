package com.workshop.WorkshopAddressBook.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;
import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.exceptions.AddressNotFoundException;

// This is the interface for the service class.
public interface IAddressServices {

	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) throws AddressNotFoundException;

	public ResponseEntity<ResponseDTO> createAddress(AddressDTO address);

	public ResponseEntity<ResponseDTO> updateAddress(Optional<String> id, AddressDTO address) throws AddressNotFoundException;

	public ResponseEntity<ResponseDTO> deleteAddress(Optional<String> id) throws AddressNotFoundException;

	public ResponseEntity<ResponseDTO> findAddressByCity(String city) throws AddressNotFoundException;
	
	ResponseEntity<ResponseDTO> hello();

}
