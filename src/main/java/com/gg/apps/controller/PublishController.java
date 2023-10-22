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
import com.gg.apps.service.DiscoverService;
import com.gg.apps.service.PersonService;
import com.gg.apps.service.PublishService;
import com.gg.apps.utils.DiscoverSelected;

@Controller
public class PublishController {
	
	@Autowired
	private PublishService publishService;
	
	@Autowired
	private DiscoverService discoverService;
	
	
	// method handler for display list of publish
		@GetMapping("/showAllPublish")
		public String viewListOfPublish(Model model) {
			model.addAttribute("listPublish",publishService.getAllPublish());
			return "publish";
		}
		
		@GetMapping("/showNewPublishForm")
		public String shownewPublishForm(Model model) {
			Publish publish = new Publish();
			List<Discover> discover = discoverService.getAllDiscover();
			model.addAttribute("publish",publish);
			model.addAttribute("discovers",discover);
			return "new_publish";
		}
//	
	@PostMapping("/savePublish")
		public String savePublish(@ModelAttribute("publish") Publish publish,
				@ModelAttribute("discovers") Discover discover,
				@ModelAttribute("selectedDiscover") Discover discovers) {
		String redirect = "";	
		//updating discover missing forign key
		try {
			discover.getDiscoverPublish().getId();
			System.out.print("you already published");
			redirect = "redirect:/showNewPublishForm";
		}catch(Exception e) {
			Publish published = publishService.savePublish(publish);	
			discover.setDiscoverPublish(published);
			discoverService.saveDiscover(discover);
			redirect = "redirect:/showAllPublish";
		}
			return redirect;
		}
	
	
	// to be implemented for multi check
	@GetMapping("/showFormForPublishUpdate/{id}")
	public String showFormForPublish(@PathVariable (value = "id") Integer id, Model model) {
		Publish publish = publishService.getPublishById(id);
		System.out.print("sss"+publish.getDiscover()+"  ");
		List<Discover> discover = discoverService.getAllDiscover();
		String date = publish.getDatePublished().toString();
		model.addAttribute("publish",publish);
		model.addAttribute("discovers",discover);
		model.addAttribute("selectedDiscover", new DiscoverSelected());
		model.addAttribute("datez",date);
		return "update_publish";
	}
//	
	@GetMapping("deletePublish/{id}")
	public String deletePublish(@PathVariable (value = "id") Integer id, Model model) {
		publishService.deletePublish(id);
		return "redirect:/";
	}

}
