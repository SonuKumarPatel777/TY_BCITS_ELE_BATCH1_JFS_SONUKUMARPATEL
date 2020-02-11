package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpringSecurityControlletr {
	
	@GetMapping("/Index")
	public  String getIndexPage() {
		return"Index";
	}
	
	
	@GetMapping("/login")
	public  String getLoginForm() {
		return"loginForm";
	}
	@GetMapping("/admineHome")
	public  String getAdmineHomePage() {
		return"admineHome";
	}
	
	@GetMapping("/userHomePage")
	public  String getUserHomePAge() {
		return"userHomePage";
	}

}//end of class
