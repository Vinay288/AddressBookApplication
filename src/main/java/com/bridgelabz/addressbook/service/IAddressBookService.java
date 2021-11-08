package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.ContactData;

public interface IAddressBookService {
	 List<ContactData> getContact();
	    ContactData getContactById(int contactId);
	    ContactData createContact(ContactDTO contactDTO);
	    ContactData updateContact(int contactId,ContactDTO contactDTO);
	    void deleteContact(int contactId);
	    List<ContactData> getContactByState(String state);
	    List<ContactData> getContactByCity(String city);
	    List<ContactData> getContactByZipCode(String zipCode);
}
