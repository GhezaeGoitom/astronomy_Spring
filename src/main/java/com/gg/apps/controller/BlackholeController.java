package com.gg.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.apps.model.Blackhole;
import com.gg.apps.model.Discover;
import com.gg.apps.model.Galaxy;
import com.gg.apps.service.BlackholeService;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.GalaxyService;

@Controller
public class BlackholeController {

	@Autowired
	private BlackholeService blackholeService;
	
	@Autowired
	private DiscoverService discoverService;
	
	@Autowired
	private GalaxyService galaxyService;

	
	
	// method handler for display list of blackhole
		@GetMapping("/showAllBlackhole")
		public String viewListOfBlackhole(Model model) {
			model.addAttribute("listBlackhole",blackholeService.getAllBlackhole());
			return "blackhole";
		}
		
		@GetMapping("/showNewBlackholeForm")
		public String shownewBlackholeForm(Model model) {
			Blackhole blackhole = new Blackhole();
			List<Discover> discovers = discoverService.getAllDiscover();
			List<Galaxy> galaxy = galaxyService.getAllGalaxy();
			model.addAttribute("blackhole",blackhole);
			model.addAttribute("discovers",discovers);
			model.addAttribute("galaxy",galaxy);
			return "new_blackhole";
		}
//	
	@PostMapping("/saveBlackhole")
		public String saveBlackhole(@ModelAttribute("blackhole") Blackhole blackhole,
				@ModelAttribute("discovers") Discover discover,
				@ModelAttribute("galaxy") Galaxy galaxy) {
		blackhole.setBlackholeDiscover(discover);
		blackhole.setBlackholeGalaxy(galaxy);
		blackholeService.saveBlackhole(blackhole);	
		return "redirect:/showAllBlackhole";
		}
	
	
	
	@GetMapping("/updateBlackhole/{id}")
	public String showUpdateFormForBlackhole(@PathVariable (value = "id") Integer id, Model model) {
		Blackhole blackhole = blackholeService.getBlackholeById(id);
		List<Discover> discovers = discoverService.getAllDiscover();
		List<Galaxy> galaxy = galaxyService.getAllGalaxy();
		model.addAttribute("blackhole",blackhole);
		model.addAttribute("discovers",discovers);
		model.addAttribute("galaxy",galaxy);
		return "update_blackhole";
	}
//	
	@GetMapping("deleteBlackhole/{id}")
	public String deleteBlackhole(@PathVariable (value = "id") Integer id, Model model) {
		blackholeService.deleteBlackhole(id);
		return "redirect:/";
	}
	
	
}
