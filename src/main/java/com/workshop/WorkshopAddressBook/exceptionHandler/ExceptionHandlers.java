package com.workshop.WorkshopAddressBook.exceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workshop.WorkshopAddressBook.dto.ResponseDTO;

@ControllerAdvice
public class ExceptionHandlers{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleInvalidPattern(MethodArgumentNotValidException error) {
		
		List<String> errors = error.getAllErrors().stream()
									.map(errorObject -> errorObject.getDefaultMessage())
									.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("ERROR: Invalid pattern", errors);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
