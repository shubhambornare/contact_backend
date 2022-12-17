package com.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.contact.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer>{

	public List<Contact> findByActiveSwitch(String stat);
	
}
