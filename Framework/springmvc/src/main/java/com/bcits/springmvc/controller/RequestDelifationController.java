package com.bcits.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDelifationController {
	
	@GetMapping("/redirect")
	public String redirectRequest() {
		
		return "redirect:https:www.youtube.com";
		
	}//End of redirectRequest()
	
	@GetMapping("/forward")
	public String forwardRequest() {
		
		return "forward:loginForm";
		
	}//End of forwardRequest()
	

}//End of class
