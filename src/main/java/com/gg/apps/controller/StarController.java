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
import com.gg.apps.model.Planet;
import com.gg.apps.model.SolarSystem;
import com.gg.apps.model.Star;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.PlanetService;
import com.gg.apps.service.SolarSystemService;
import com.gg.apps.service.StarService;

@Controller
public class StarController {
	@Autowired
	private StarService starService;
	
	@Autowired
	private DiscoverService discoverService;
	
	@Autowired
	private SolarSystemService solarSService;
	
	@GetMapping("/showAllStar")
	public String viewListOfStar(Model model) {
		model.addAttribute("listStar",starService.getAllStar());
		return "star";
	}
	
	@GetMapping("/showNewStarForm")
	public String shownewStarForm(Model model) {
		Star star = new Star();
		List<Discover> discovers = discoverService.getAllDiscover();
		List<SolarSystem> solarSystem = solarSService.getAllSolarsystem();
		model.addAttribute("star",star);
		model.addAttribute("discovers",discovers);
		model.addAttribute("solarS",solarSystem);
		return "new_star";
	}
//
@PostMapping("/saveStar")
	public String saveStar(@ModelAttribute("star") Star star,
			@ModelAttribute("discovers") Discover discover,
			@ModelAttribute("solarS") SolarSystem solarS) {
	star.setStarDiscover(discover);
	star.setStarSolarS(solarS);
	starService.saveStar(star);
	return "redirect:/showAllStar";
	}



@GetMapping("/updateStar/{id}")
public String showFormForStar(@PathVariable (value = "id") Integer id, Model model) {
	Star star = starService.getStarById(id);
	List<Discover> discovers = discoverService.getAllDiscover();
	List<SolarSystem> solarS = solarSService.getAllSolarsystem();
	model.addAttribute("star",star);
	model.addAttribute("discovers",discovers);
	model.addAttribute("solarS",solarS);
	return "update_star";
}
//
@GetMapping("deleteStar/{id}")
public String deleteStar(@PathVariable (value = "id") Integer id, Model model) {
	starService.deleteStar(id);
	return "redirect:/";
}
}
