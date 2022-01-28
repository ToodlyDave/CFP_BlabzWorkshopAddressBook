package com.workshop.WorkshopAddressBook.dto;

public class ResponseDTO {

	String message;
	Object data;

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

}
