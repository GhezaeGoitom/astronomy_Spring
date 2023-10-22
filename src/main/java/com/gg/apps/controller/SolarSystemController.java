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
import com.gg.apps.model.SolarSystem;
import com.gg.apps.service.BlackholeService;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.GalaxyService;
import com.gg.apps.service.SolarSystemService;

@Controller
public class SolarSystemController {

	@Autowired
	private SolarSystemService solarSService;
	
	@Autowired
	private DiscoverService discoverService;
	
	@Autowired
	private GalaxyService galaxyService;
	
	
	@GetMapping("/showAllSolarsystem")
	public String viewListOfSolarS(Model model) {
		model.addAttribute("listSolarS",solarSService.getAllSolarsystem());
		return "solarsystem";
	}
	
	@GetMapping("/showNewSolarS")
	public String shownewSolarSForm(Model model) {
		SolarSystem solarS = new SolarSystem();
		List<Discover> discovers = discoverService.getAllDiscover();
		List<Galaxy> galaxy = galaxyService.getAllGalaxy();
		model.addAttribute("solarS",solarS);
		model.addAttribute("discovers",discovers);
		model.addAttribute("galaxy",galaxy);
		return "new_solarsystem";
	}
//
@PostMapping("/saveSolarS")
	public String saveSolarS(@ModelAttribute("solarS") SolarSystem solarS,
			@ModelAttribute("discovers") Discover discover,
			@ModelAttribute("galaxy") Galaxy galaxy) {
	solarS.setSolarSGalaxy(galaxy);
	solarS.setSolarSDiscover(discover);
	solarSService.saveSolarsystem(solarS);
	return "redirect:/showAllSolarsystem";
	}



@GetMapping("/updateSolarS/{id}")
public String showFormForSolarS(@PathVariable (value = "id") Integer id, Model model) {
	SolarSystem solarS = solarSService.getSolarSystemById(id);
	List<Discover> discovers = discoverService.getAllDiscover();
	List<Galaxy> galaxy = galaxyService.getAllGalaxy();
	model.addAttribute("solarS",solarS);
	model.addAttribute("discovers",discovers);
	model.addAttribute("galaxy",galaxy);
	return "update_solarsystem";
}
//
@GetMapping("deleteSolarS/{id}")
public String deleteSolarS(@PathVariable (value = "id") Integer id, Model model) {
	solarSService.deleteSolarsystem(id);
	return "redirect:/";
}

	
}
