package com.gg.apps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Person;
import com.gg.apps.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService{
   
	@Autowired
	private PersonRepo personRepo;
	
	
	@Override
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}


	@Override
	public void savePerson(Person person) {
		this.personRepo.save(person);
		
	}


	@Override
	public Person getPersonById(Integer fiscalcode) {
		Optional<Person> optional = personRepo.findById(fiscalcode);
		Person person = null;
		if(optional.isPresent()) {
			person = optional.get();
		}else {
			throw new RuntimeException("Person not found using this fiscalcode : "+fiscalcode);
		}
		return person;
	}


	@Override
	public void deletePerson(Integer fiscalcode) {
		this.personRepo.deleteById(fiscalcode);
		
	}


	@Override
	public List<Person> selectAll() {
		return personRepo.findAllPersonzz();
	}


}
