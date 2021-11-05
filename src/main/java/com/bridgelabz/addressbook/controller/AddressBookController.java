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

@RestController
public class AddressBookController {
	Map<Long, String> addressBook = new HashMap<>();
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>(addressBook.values().toString(), HttpStatus.OK);
	}

	@GetMapping("/get/{addressBookId}")
	public ResponseEntity<String> getAddressBookDataById(@PathVariable long addressBookId) {
		return new ResponseEntity<String>(addressBook.get(addressBookId), HttpStatus.OK);
	}

}
