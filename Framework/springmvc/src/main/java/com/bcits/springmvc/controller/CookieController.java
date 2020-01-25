package com.bcits.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	
	@GetMapping("/cookiePage")
	public String getCookiePage() {
		return "cookiePage";
		
	}//End of getCookiePage()
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp, ModelMap modelMap) {
		Cookie myCookie = new Cookie("empName", "Sonu");
		resp.addCookie(myCookie);
		
		modelMap.addAttribute("msg","Cookies create Successfully..");
		return "cookiePage";
		
	}//End of createCookie()
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue(name="empName",required=false ) 
	String employeeName,ModelMap modelMap) {
		 if(employeeName != null) {
			 modelMap.addAttribute("msg","Cookie value is  "+employeeName); 
		 }else {
			 modelMap.addAttribute("errmsg","Cookie is not present ??");
		 }
		
		
		return "cookiePage";
		
	}//End of readCookie()
	
	

}//End of Class
