package com.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




@Data
@Entity 
@Table(name = "CONTACTS")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer contactId;
	
	@Column(name = "NAME")
	private String contactName;
	
	@Column(name = "EMAIL")
	private String contactEmail;
	
	@Column(name = "PHONE")
	private Long contactNumber;
	
	private String activeSwitch;

}
