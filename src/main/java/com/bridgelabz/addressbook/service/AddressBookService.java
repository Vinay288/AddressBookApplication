package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.ContactData;

@Service
public class AddressBookService implements IAddressBookService {
 List<ContactData> contactList=new ArrayList<>();
 private final AtomicInteger counter = new AtomicInteger();
	@Override
	public List<ContactData> getContact() {
        return contactList;
	}

	@Override
	public ContactData getContactById(int contactId) {
	        return contactList.get(contactId-1);
	}

	@Override
	public ContactData createContact(ContactDTO contactDTO) {
		ContactData contactData=new ContactData(counter.incrementAndGet(),contactDTO);
		contactList.add(contactData);
		return contactData;
	}

	@Override
	public ContactData updateContact(int contactId, ContactDTO contactDTO) {
		contactList.remove(contactId-1);
		ContactData contactData=new ContactData(contactId,contactDTO);
		contactList.add(contactData);
		return contactData;
	}

	@Override
	public void deleteContact(int contactId) {
		contactList.remove(contactId-1);
		
	}

}
