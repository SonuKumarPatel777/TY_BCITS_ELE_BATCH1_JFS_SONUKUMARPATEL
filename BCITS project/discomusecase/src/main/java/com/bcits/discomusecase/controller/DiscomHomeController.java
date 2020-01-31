package com.bcits.discomusecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bcits.discomusecase.service.ConsumerMasterService;
 

@Controller
public class DiscomHomeController {
	
	@Autowired
	private ConsumerMasterService service;
	
	@GetMapping("/discomHomePage")
	public String displayHomepage() {
		return "home";
	}// end of displayHomepage()

}//end of class
