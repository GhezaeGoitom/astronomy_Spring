package com.gg.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Person;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.PersonService;

@Controller
public class DiscoverController {

	
	@Autowired
	private DiscoverService discoverService;
	@Autowired
	private PersonService personService;
	
//	 method handler for display list of persons
			@GetMapping("/showAllDiscover")
			public String viewListOfDiscover(Model model) {
				model.addAttribute("listDiscover",discoverService.getAllDiscover());
//				System.out.print("hello"+discoverService.selectAll().get(0).person.getFirstName());
				return "discover";
			}
			
		@GetMapping("/showNewDiscoverForm")
		public String shownewDiscoverForm(Model model) {
			Discover discover = new Discover();
			List<Person> persons = personService.selectAll();
			model.addAttribute("discover",discover);
			model.addAttribute("persons",persons);
			return "new_discovery";
		}
//		
		@PostMapping("/saveDiscovery")
		public String saveDiscover(@ModelAttribute("discover") Discover discover, @ModelAttribute("persons") Person person) {
			discover.setDiscoverPerson(person);
			discoverService.saveDiscover(discover);
			return "redirect:/showAllDiscover";
		}
		
		
			
		@GetMapping("/showFormForDiscoverUpdate/{id}")
		public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
			Discover discover = discoverService.getDiscoverById(id);
			List<Person> persons = personService.selectAll();
			String date = discover.getDateDiscovered().toString();
			model.addAttribute("discover",discover);
			model.addAttribute("persons",persons);
			model.addAttribute("datez",date);
			return "update_discovery";
		}
//		
		@GetMapping("deleteDiscover/{id}")
		public String deleteDiscover(@PathVariable (value = "id") Integer id, Model model) {
			Discover discover = discoverService.selectById(id);
			discover.setDiscoverPerson(null);
			discoverService.delete(discover);
			return "redirect:/showAllDiscoveries";
		}
		
		
}
