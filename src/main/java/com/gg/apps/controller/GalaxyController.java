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
import com.gg.apps.model.GalacticCluster;
import com.gg.apps.model.Galaxy;
import com.gg.apps.model.Supernova;
import com.gg.apps.model.Universe;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.GalacticCService;
import com.gg.apps.service.GalaxyService;
import com.gg.apps.service.SupernovaService;
import com.gg.apps.service.UniverseService;

@Controller
public class GalaxyController {
	@Autowired
	private GalacticCService galacticCService;	
	
	@Autowired
	private GalaxyService galaxyService;
	
	@Autowired
	private DiscoverService discoverService;
	
	@Autowired
	private UniverseService universeService;

	
	
	// method handler for display list of publish
		@GetMapping("/showAllGalaxy")
		public String viewListOfGalaxy(Model model) {
			model.addAttribute("listGalaxy",galaxyService.getAllGalaxy());
			return "galaxy";
		}
		
		@GetMapping("/showNewGalaxy")
		public String shownewGalaxyForm(Model model) {
			Galaxy galaxy = new Galaxy();
			List<Discover> discovers = discoverService.getAllDiscover();
			List<Universe> universes = universeService.getAllUniverse();
			List<GalacticCluster> galacticC = galacticCService.getAllGalacticC();
			model.addAttribute("galacticC",galacticC);
			model.addAttribute("discovers",discovers);
			model.addAttribute("universes",universes);
			model.addAttribute("galaxy",galaxy);
			return "new_galaxy";
		}
//	
	@PostMapping("/saveGalaxy")
		public String saveGalaxy(@ModelAttribute("universe") Universe universe,
				@ModelAttribute("discover") Discover discover,
				@ModelAttribute("galacticC") GalacticCluster galacticC,
				@ModelAttribute("galaxy") Galaxy galaxy) {
		galaxy.setGalaxyUniverse(universe);
		galaxy.setGalaxyDiscover(discover);
		galaxy.setGalaxyGalacticC(galacticC);
		galaxyService.saveGalaxy(galaxy);
		return "redirect:/showAllGalaxy";
		}
	
	
	
	@GetMapping("/updateGalaxy/{id}")
	public String showFormForGalaxy(@PathVariable (value = "id") Integer id, Model model) {
		Galaxy galaxy = galaxyService.getGalaxyById(id);
		List<Discover> discovers = discoverService.getAllDiscover();
		List<Universe> universes = universeService.getAllUniverse();
		List<GalacticCluster> galacticC = galacticCService.getAllGalacticC();
		model.addAttribute("galacticC",galacticC);
		model.addAttribute("discovers",discovers);
		model.addAttribute("universes",universes);
		model.addAttribute("galaxy",galaxy);
		return "update_galaxy";
	}
//	
	@GetMapping("deleteGalaxy/{id}")
	public String deleteGalaxy(@PathVariable (value = "id") Integer id, Model model) {
		galaxyService.deleteGalaxy(id);
		return "redirect:/";
	}
}
