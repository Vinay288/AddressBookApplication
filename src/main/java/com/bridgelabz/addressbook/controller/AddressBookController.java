package com.bridgelabz.addressbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.addressbook.service.AddressBookService;

@RestController
public class AddressBookController {
	Map<Long, String> addressBook = new HashMap<>();
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	AddressBookService addressBookService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getContactData() {
		List<ContactData> contactList = addressBookService.getContact();
		ResponseDTO response = new ResponseDTO("Get Call Success", contactList);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getContactDataById(@PathVariable int contactId) {
		ContactData contactData = addressBookService.getContactById(contactId);
		ResponseDTO response = new ResponseDTO("Get Call By id Success", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createContactData(@Valid @RequestBody ContactDTO contactDTO) {
		ContactData contactData = addressBookService.createContact(contactDTO);
		ResponseDTO response = new ResponseDTO("Contact Added ", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactData(@PathVariable int contactId,
			@Valid @RequestBody ContactDTO contactDTO) {
		ContactData contactData = addressBookService.updateContact(contactId, contactDTO);
		ResponseDTO response = new ResponseDTO("Contact Added ", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<String> deleteContactData(@PathVariable int contactId) {
		addressBookService.deleteContact(contactId);
		return new ResponseEntity<String>("deleted employee = " + contactId, HttpStatus.OK);
	}

}
