package com.gg.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
// main app
@GetMapping("/")
public String viewHomePage(Model model) {return "index";}
	
}
