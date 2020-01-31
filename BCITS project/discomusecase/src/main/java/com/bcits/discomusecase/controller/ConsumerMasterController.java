package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.service.ConsumerMasterService;

@Controller
@RequestMapping("/consumer")
public class ConsumerMasterController {

	@Autowired
	private ConsumerMasterService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}// end of initBinder()

	@GetMapping("/consumerLoginPage")
	public String displayConsumerLoginPage() {
		return "consumerlogin";
	}// end of displayLoginPage()

	@GetMapping("/consumerRegister")
	public String displaySignUpPage() {
		return "consumerRegister";
	}// end of displaySignUpPage()

	@PostMapping("/addConsumer")
	public String addConsumerDetails(ConsumersMasterBean consumersMasterBean, ModelMap modelMap, String cnfPassword) {
		if (service.registerConsumer(consumersMasterBean, cnfPassword)) {
			modelMap.addAttribute("msg", "SuccessfulIy register");
			return "consumerlogin";
		} else {
			modelMap.addAttribute("errMsg", "Register failed");
			return "consumerRegister";
		}
	}// end of addConsumerDetails()
    
	
	@PostMapping("/consumerLogin")
	public String authenticate(String meterNumber, String password, ModelMap modelMap,HttpServletRequest req) {
		ConsumersMasterBean consumersMasterBean=service.authentication(meterNumber,password); 
        if( consumersMasterBean!= null) {
	       //valid Credentials
//	       HttpSession session = req.getSession(true);
//	       session.setAttribute("loggedIngInfo",consumersMasterBean);
	       return "consumerHomePage";
        }else {
	       //Invalid Credentials
	     modelMap.addAttribute("errMsg","Invalid Creadential");
	    return "consumerlogin";
}     
	}// end of authenticate()

}// end of class
