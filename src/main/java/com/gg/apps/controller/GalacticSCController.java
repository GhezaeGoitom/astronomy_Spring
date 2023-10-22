package com.gg.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.apps.model.GalacticSC;
import com.gg.apps.service.GalacticSCService;

@Controller
public class GalacticSCController {
	@Autowired
	private GalacticSCService galacticSCService;
	
	
	// method handler for display list of galactic super cluster
		@GetMapping("/showAllGalacticSC")
		public String viewListOfGalacticSC(Model model) {
			model.addAttribute("listGalacticSC",galacticSCService.getAllGalacticSC());
			return "galacticSC";
		}
		
	@GetMapping("/showNewGalacticSCForm")
	public String shownewGalacticSCForm(Model model) {
		GalacticSC galacticSC = new GalacticSC();
		model.addAttribute("galacticSC",galacticSC);
		return "new_galacticSC";
	}
	
	@PostMapping("/saveGalacticSC")
	public String saveGalacticSC(@ModelAttribute("galacticSC") GalacticSC galacticSC) {
		galacticSCService.saveGalacticSC(galacticSC);
		return "redirect:/";
	}
	
	@GetMapping("/galacticSCUpdate/{id}")
	public String GalacticSCUpdate(@PathVariable (value = "id") Integer id, Model model) {
		GalacticSC galacticSC = galacticSCService.getGalacticSCById(id);
		model.addAttribute("galacticSC",galacticSC);
		return "update_galacticSC";
	}
	
	@GetMapping("deleteGalacticSC/{id}")
	public String deleteGalacticSC(@PathVariable (value = "id") Integer id, Model model) {
		galacticSCService.deleteGalacticSC(id);
		return "redirect:/";
	}
}
