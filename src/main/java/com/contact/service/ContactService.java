package com.contact.service;

import java.util.List;

import com.contact.model.Contact;

public interface ContactService {
	
	public String saveContact (Contact contact);
	
	public List<Contact>getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public String updateContact(Contact contact);
	
	public String deletContact(Integer contactId);

}
