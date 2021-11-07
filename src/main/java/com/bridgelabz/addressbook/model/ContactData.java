package com.bridgelabz.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.ContactDTO;

import lombok.Data;

@Entity
@Table(name = "contact")
public @Data class ContactData {
	@Id
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String city;

	private String state;

	@Column(name = "zip_code")
	private String zipCode;

	private String email;

	public ContactData() {
	}

	public ContactData(int contactId, ContactDTO contactDTO) {
		this.contactId = contactId;
		this.firstName = contactDTO.firstName;
		this.lastName = contactDTO.lastName;
		this.phoneNumber = contactDTO.phoneNumber;
		this.city = contactDTO.city;
		this.state = contactDTO.state;
		this.zipCode = contactDTO.zipCode;
		this.email = contactDTO.email;
	}
}
