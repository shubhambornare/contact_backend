package com.contact.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Contact;
import com.contact.service.ContactService;

@RestController
@CrossOrigin
public class ContactRestController {
	
	@Autowired
	public ContactService contactservice;
	
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
		
		String status = contactservice.saveContact(contact);
		
		return status;
		
	}
	
	@GetMapping("/contact")
	public List<Contact> getAllContacts(){
		
		return contactservice.getAllContacts();
		
	}
	
	@GetMapping("/contact/{id}")
	public Contact getContactById(@PathVariable Integer id) {
		
		Contact status = contactservice.getContactById(id);
		
		return status;
	}
	
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		
		String status = contactservice.updateContact(contact);
		
		return status;
		
	}
	
	@DeleteMapping("/contact/{id}")
	public String deleteContact(@PathVariable Integer id) {
		
		String status = contactservice.deletContact(id);
		
		return status;
		
	}
	

}
