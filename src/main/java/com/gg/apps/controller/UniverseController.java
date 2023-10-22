package com.gg.apps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Person;
import com.gg.apps.model.Publish;
import com.gg.apps.model.Universe;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.PersonService;
import com.gg.apps.service.PublishService;
import com.gg.apps.service.UniverseService;
import com.gg.apps.utils.DiscoverSelected;

@Controller
public class UniverseController {
	
	@Autowired
	private UniverseService universeService;
	
	// method handler for display list of universe
		@GetMapping("/showAllUniverse")
		public String viewListOfUniverse(Model model) {
			model.addAttribute("listUniverse",universeService.getAllUniverse());
			return "universe";
		}
		
		@GetMapping("/showNewUniverseForm")
		public String shownewUniverseForm(Model model) {
			Universe universe = new Universe();
			model.addAttribute("universe",universe);
			return "new_universe";
		}
//	
	@PostMapping("/saveUniverse")
		public String saveUniverse(@ModelAttribute("universe") Universe universe) {
			universeService.saveUniverse(universe);
			return "redirect:/showAllUniverse";
		}
	
	
	@GetMapping("/showFormForUniverseUpdate/{id}")
	public String updateUniverse(@PathVariable (value = "id") Integer id, Model model) {
		Universe universe = universeService.getUniverseById(id);
		model.addAttribute("universe",universe);
		return "update_universe";
	}
//	
	@GetMapping("deleteUniverse/{id}")
	public String deleteUniverse(@PathVariable (value = "id") Integer id, Model model) {
		universeService.deleteUniverse(id);
		return "redirect:/";
	}

}
