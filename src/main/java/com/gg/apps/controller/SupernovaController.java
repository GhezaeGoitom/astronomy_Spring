package com.gg.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Publish;
import com.gg.apps.model.Supernova;
import com.gg.apps.model.Universe;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.PublishService;
import com.gg.apps.service.SupernovaService;
import com.gg.apps.service.UniverseService;
import com.gg.apps.utils.DiscoverSelected;

@Controller
public class SupernovaController {
	@Autowired
	private SupernovaService supernovaService;
	
	@Autowired
	private DiscoverService discoverService;
	
	@Autowired
	private UniverseService universeService;

	
	
	// method handler for display list of publish
		@GetMapping("/showAllSupernova")
		public String viewListOfSupernova(Model model) {
			model.addAttribute("listSupernova",supernovaService.getAllSupernova());
			return "supernova";
		}
		
		@GetMapping("/showNewSupernovaForm")
		public String shownewSupernovaForm(Model model) {
			Supernova supernova = new Supernova();
			List<Discover> discovers = discoverService.getAllDiscover();
			System.out.print("idd"+discovers.size());
			List<Universe> universes = universeService.getAllUniverse();
			model.addAttribute("supernova",supernova);
			model.addAttribute("discovers",discovers);
			model.addAttribute("universes",universes);
			return "new_supernova";
		}
//	
	@PostMapping("/saveSupernova")
		public String saveSupernova(@ModelAttribute("universes") Universe universe,
				@ModelAttribute("discovers") Discover discover,
				@ModelAttribute("supernova") Supernova supernova) {
		supernova.setSupernovaDiscover(discover);
		supernova.setSupernovaUniverse(universe);
		supernovaService.saveSupernova(supernova);	
		return "redirect:/showAllSupernova";
		}
	
	
	
	@GetMapping("/showFormForSupernovaUpdate/{id}")
	public String showFormForSupernova(@PathVariable (value = "id") Integer id, Model model) {
		Supernova supernova = supernovaService.getSupernovaById(id);
		List<Discover> discovers = discoverService.getAllDiscover();
		List<Universe> universes = universeService.getAllUniverse();
		model.addAttribute("supernova",supernova);
		model.addAttribute("discovers",discovers);
		model.addAttribute("universes",universes);
		return "update_supernova";
	}
//	
	@GetMapping("deleteSupernova/{id}")
	public String deleteSupernova(@PathVariable (value = "id") Integer id, Model model) {
		supernovaService.deleteSupernova(id);
		return "redirect:/";
	}
}
