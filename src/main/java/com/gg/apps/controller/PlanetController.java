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
import com.gg.apps.model.Planet;
import com.gg.apps.model.SolarSystem;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.PlanetService;
import com.gg.apps.service.SolarSystemService;

@Controller
public class PlanetController {

	@Autowired
	private PlanetService planetService;
	
	@Autowired
	private DiscoverService discoverService;
	
	@Autowired
	private SolarSystemService solarSService;
	
	@GetMapping("/showAllPlanet")
	public String viewListOfPlanet(Model model) {
		model.addAttribute("listPlanet",planetService.getAllPlanet());
		return "planet";
	}
	
	@GetMapping("/showNewPlanetForm")
	public String shownewPlanetForm(Model model) {
		Planet planet = new Planet();
		List<Discover> discovers = discoverService.getAllDiscover();
		List<SolarSystem> solarSystem = solarSService.getAllSolarsystem();
		model.addAttribute("planet",planet);
		model.addAttribute("discovers",discovers);
		model.addAttribute("solarS",solarSystem);
		return "new_planet";
	}
//
@PostMapping("/savePlanet")
	public String savePlanet(@ModelAttribute("planet") Planet planet,
			@ModelAttribute("discovers") Discover discover,
			@ModelAttribute("solarS") SolarSystem solarS) {
	
	planet.setPlanetSolarS(solarS);
	planet.setPlanetDiscover(discover);
	planetService.savePlanet(planet);	
	return "redirect:/showAllPlanet";
	}



@GetMapping("/updatePlanet/{id}")
public String showFormForPlanet(@PathVariable (value = "id") Integer id, Model model) {
	Planet planet = planetService.getPlanetById(id);
	List<Discover> discovers = discoverService.getAllDiscover();
	List<SolarSystem> solarS = solarSService.getAllSolarsystem();
	model.addAttribute("planet",planet);
	model.addAttribute("discovers",discovers);
	model.addAttribute("solarS",solarS);
	return "update_planet";
}
//
@GetMapping("deletePlanet/{id}")
public String deleteplanet(@PathVariable (value = "id") Integer id, Model model) {
	planetService.deletePlanet(id);
	return "redirect:/";
}
}
