package com.bcits.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	
	@GetMapping("/")
	public String getMessage() {
		return "Hello world";
	}

}//End of class
