package com.exptrkrproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exptrkrproj.model.User;
import com.exptrkrproj.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	//maps to root url "/" to index page
	@GetMapping("/")
	public String index() {
		return "index";
		
	}
	@GetMapping("/register")
	public String ShowRegistrationForm(Model model) {
		model.addAttribute("user",new User());
		return "register";
		
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user")User user) {
		//check if the user already exists
		if(userService.findByUsername(user.getUsername())!=null) {
			return "redirect:/register?error";
		}
		userService.save(user);
		return "redirect:/login";
		
	}
	@GetMapping("/login")
	public String ShowloginForm() {
		
		return "login";
		
	}
}
