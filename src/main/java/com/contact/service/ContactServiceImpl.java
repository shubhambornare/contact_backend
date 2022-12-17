package com.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.model.Contact;
import com.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository repo;
	
	@Override
	public String saveContact(Contact contact) {
		
		contact.setActiveSwitch("ACTIVE");
		
		repo.save(contact);
		
		if (contact.getContactId() != null) {
			
			return "Contact Saved";
		}else {
			return "Contact Not Saved";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findByActiveSwitch("ACTIVE");
		
	}

	@Override
	public Contact getContactById(Integer id) {
		Optional<Contact> contacts = repo.findById(id);
		
		
		
		if(contacts.isPresent()) {
			return contacts.get();
		}
		return null;
		
	}

	@Override
	public String updateContact(Contact contact) {
		
		if ( repo.existsById(contact.getContactId())) {
			contact = repo.save(contact);
			return "Updated Successfully";
		}else {
			return "Not Updated";
		}
		
	}

	@Override
	public String deletContact(Integer id) {
		
		/*
		 * if (repo.existsById(id)) { repo.deleteById(id); return
		 * "Deleted Successfully";
		 * 
		 * }else { return "Unable to Delete"; }
		 */
		
		Optional<Contact>findById= repo.findById(id);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSwitch("INACTIVE");
			repo.save(contact);
			return " Record Deleted";
		}else {
			return "Record Not Found";
		}
	}

}
