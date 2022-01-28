package com.workshop.WorkshopAddressBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WorkshopAddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopAddressBookApplication.class, args);
		log.info(" The application has started ");
	}

}
