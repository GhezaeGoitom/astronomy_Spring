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
import com.gg.apps.model.GalacticSC;
import com.gg.apps.model.Supernova;
import com.gg.apps.model.Universe;
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.GalacticCService;
import com.gg.apps.service.GalacticSCService;
import com.gg.apps.service.SupernovaService;
import com.gg.apps.service.UniverseService;

@Controller
public class GalacticCController {
	
	@Autowired
	private GalacticSCService galacticSCService;
	
	@Autowired
	private GalacticCService galacticCService;
	

	
	
	// method handler for display list of Galactic Cluster
		@GetMapping("/showAllGalacticC")
		public String viewListOfGalacticC(Model model) {
			model.addAttribute("listGalacticC",galacticCService.getAllGalacticC());
			return "galacticC";
		}
		
		@GetMapping("/showNewGalacticC")
		public String shownewGalacticCForm(Model model) {
			GalacticCluster galacticC = new GalacticCluster();
			List<GalacticSC> galacticSC = galacticSCService.getAllGalacticSC();
			model.addAttribute("galacticC",galacticC);
			model.addAttribute("galacticSC",galacticSC);
			return "new_galacticC";
		}
//	
	@PostMapping("/saveGalacticC")
		public String saveGalacticC(@ModelAttribute("galacticSC") GalacticSC galacticSC,
				@ModelAttribute("galacticC") GalacticCluster galacticC) {
		galacticC.setGalacticSC(galacticSC);
		galacticCService.saveGalacticC(galacticC);
				return "redirect:/showAllGalacticC";
		}
	
	
	
	@GetMapping("/updateGalacticC/{id}")
	public String showFormForGalacticC(@PathVariable (value = "id") Integer id, Model model) {
		GalacticCluster galacticC = galacticCService.getGalacticCById(id);
		List<GalacticSC> galacticSC = galacticSCService.getAllGalacticSC();
		model.addAttribute("galacticC",galacticC);
		model.addAttribute("galacticSC",galacticSC);
		return "update_galacticC";
	}
//	
	@GetMapping("deleteGalacticC/{id}")
	public String deleteGalacticC(@PathVariable (value = "id") Integer id, Model model) {
		galacticCService.deleteGalacticC(id);
		return "redirect:/";
	}

}
