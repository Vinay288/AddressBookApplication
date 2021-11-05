package com.bridgelabz.addressbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactData;

@RestController
public class AddressBookController {
	Map<Long, String> addressBook = new HashMap<>();
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		ContactData contactData = new ContactData(1,
				new ContactDTO("Vinay", "Hiremath", "9110473394", "badami", "karnataka", "587201", "vinay@gmail.com"));
		ResponseDTO response = new ResponseDTO("Get Call Success", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{addressBookId}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable long addressBookId) {
		ContactData contactData = new ContactData(1,
				new ContactDTO("Vinay", "Hiremath", "9110473394", "badami", "karnataka", "587201", "vinay@gmail.com"));
		ResponseDTO response = new ResponseDTO("Get Call Success", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddressBookData(@RequestBody ContactDTO contactDTO) {
		ContactData contactData = new ContactData(1, contactDTO);
		ResponseDTO response = new ResponseDTO("Contact Added ", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{addressBookId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int contactId,
			@RequestBody ContactDTO contactDTO) {
		ContactData contactData = new ContactData(contactId, contactDTO);
		ResponseDTO response = new ResponseDTO("Contact Added ", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{addressBookId}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable long addressBookId) {
		return new ResponseEntity<String>("deleted employee = " + addressBookId, HttpStatus.OK);
	}

}
