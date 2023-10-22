package com.gg.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.apps.model.Person;
import com.gg.apps.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	// method handler for display list of persons
		@GetMapping("/showAllPersons")
		public String viewListOfPersons(Model model) {
			model.addAttribute("listPersons",personService.selectAll());
			return "index";
		}
		
	@GetMapping("/showNewPersonForm")
	public String shownewPersonForm(Model model) {
		Person person = new Person();
		model.addAttribute("person",person);
		return "new_person";
	}
	
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/showAllPersons";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
		Person person = personService.getPersonById(id);
		model.addAttribute("person",person);
		return "update_person";
	}
	
	@GetMapping("deletePerson/{id}")
	public String deletePerson(@PathVariable (value = "id") Integer id, Model model) {
		personService.deletePerson(id);
		return "redirect:/";
	}
	
}
