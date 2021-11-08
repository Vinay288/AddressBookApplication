package com.bridgelabz.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.ContactData;
import com.bridgelabz.addressbook.repository.ContactRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<ContactData> getContact() {
		return contactRepository.findAll();
	}

	@Override
	public ContactData getContactById(int contactId) {
		return contactRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Contact not found"));
	}

	@Override
	public ContactData createContact(ContactDTO contactDTO) {
		ContactData contactData = new ContactData(contactDTO);
		return contactRepository.save(contactData);
	}

	@Override
	public ContactData updateContact(int contactId, ContactDTO contactDTO) {
		ContactData contactData = contactRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("Contact not found"));
		contactData.updateContactData(contactDTO);
		return contactRepository.save(contactData);
	}

	@Override
	public void deleteContact(int contactId) {
		contactRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Contact not found"));
		contactRepository.deleteById(contactId);
	}

	@Override
	public List<ContactData> getContactByState(String state) {
		return contactRepository.findContactByState(state);
	}

	@Override
	public List<ContactData> getContactByCity(String city) {
		return contactRepository.findContactByCity(city);
	}

	@Override
	public List<ContactData> getContactByZipCode(String zipCode) {
		return contactRepository.findContactByZipCode(zipCode);
	}

}
