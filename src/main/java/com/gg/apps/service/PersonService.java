package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Person;

public interface PersonService {
List<Person> getAllPersons();
void savePerson(Person person);
Person getPersonById(Integer fiscalcode);
void deletePerson(Integer fiscalcode);
List<Person> selectAll();
}
