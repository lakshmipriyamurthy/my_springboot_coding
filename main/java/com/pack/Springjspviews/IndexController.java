package com.pack.Springjspviews;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
//default: get method
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message","Welcome to spring Boot");
		return "index";
	}
	
	@RequestMapping("/next")
	public String next(ModelMap model) {
		model.addAttribute("message","Spring Boot - JSP Views");
		return "next";
	}
	
}
