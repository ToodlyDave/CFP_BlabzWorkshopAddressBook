package com.workshop.WorkshopAddressBook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// This is the dto used for most responses. It's returning a message and an object as well.

@Getter
@AllArgsConstructor
public class ResponseDTO {

	String message;
	Object data;

}
