package com.example.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.model.MyUser;
import com.example.repo.MyUserRepo;

@Controller
public class AppController {
	@Autowired
	private MyUserRepo repo;
	
	//method for displaying home page
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	} 
	
	@GetMapping("/registration")
	public String showRegistrationPage(Model model){
		model.addAttribute("user", new MyUser());
		return "registrationForm";
	}
	
	
	@PostMapping("/process_register")
	public String processRegistration(MyUser user, Model model) {
		
		if(repo.findByEmail(user.getEmail())!=null) {
			model.addAttribute("user", new MyUser());
			return "registration_fail";
		}
		else {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setRegistered(timestamp);
		repo.save(user);
		List<MyUser> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "registration_success";
		}
	}
	
}
