package com.workshop.WorkshopAddressBook.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.workshop.WorkshopAddressBook.dto.AddressDTO;
import com.workshop.WorkshopAddressBook.dto.ResponseDTO;

public interface IAddressServices {

	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id);

	public ResponseEntity<ResponseDTO> createAddress(AddressDTO address);

	public ResponseEntity<ResponseDTO> updateAddress(Optional<String> id, AddressDTO address);

	public ResponseEntity<ResponseDTO> deleteAddress(Optional<String> id);

	ResponseEntity<ResponseDTO> hello();

}
