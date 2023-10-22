package com.gg.apps.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="PERSON")
public class Person {
	@Id
	@Column(name="FISCALCODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer fiscalCode;
	
	@Column(name="FIRSTNAME")
	public String firstName;
	
	@Column(name="LASTNAME")
	public String lastName;
	
	@Column(name="EMAIL")
	public String email;
	
//	@OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
//    private Discover discover;

	
	
	
	public Integer getFiscalcode() {
		return fiscalCode;
	}
	public void setFiscalcode(Integer fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
