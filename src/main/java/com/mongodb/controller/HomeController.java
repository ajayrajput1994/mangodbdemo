package com.mongodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		System.out.println("this is home page");
		model.addAttribute("title","it's controll by home controller");
		return "index";
	}
}
