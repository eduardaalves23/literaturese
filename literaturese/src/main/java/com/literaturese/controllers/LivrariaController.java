package com.literaturese.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LivrariaController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
}
