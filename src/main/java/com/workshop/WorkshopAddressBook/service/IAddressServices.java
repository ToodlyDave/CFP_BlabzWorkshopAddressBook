package com.workshop.WorkshopAddressBook.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.workshop.WorkshopAddressBook.dto.ResponseDTO;
import com.workshop.WorkshopAddressBook.entities.Address;

public interface IAddressServices {

	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id);

	public ResponseEntity<ResponseDTO> createAddress(Address address);

	public ResponseEntity<ResponseDTO> updateAddress(Optional<String> id);

	public ResponseEntity<ResponseDTO> deleteAddress(Optional<String> id);

	ResponseEntity<ResponseDTO> hello();

}
