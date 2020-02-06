package com.bcits.springsecuritymvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.service.EmpServic;

@Controller
public class EmpSecurityController {
	
	@Autowired
	private EmpServic service;

	@GetMapping("/index")
	public  String getIndexPage() {
		return"index";
	}
	
	@GetMapping("/register")
	public  String displayRegister() {
		return"register";
	}
	
	@PostMapping("/register")
	public  String register(EmpInfoBean infoBean, ModelMap modelMap) {
		boolean isRegister = service.register(infoBean);
		if(isRegister) {
			modelMap.addAttribute("msg"," Register Successfully");
			 return "register";
		 }else {
			 modelMap.addAttribute("errMsg"," Not Register here");
			 return "register";
		 }
	}
	
	@GetMapping("/admineSecureHome")
	public  String getAdmineHomePage() {
		return"admineHome";
	}
	
	@GetMapping("/userSecureHome")
	public  String getUserHomePAge() {
		return"userHomePage";
	}
	
	@GetMapping("/getEmployeeForm")
	public  String getEmployeeForm() {
		return"search";
	}
	
	@GetMapping("/getEmployee")
	public  String getEmployee(int empId, ModelMap modelMap) {
		EmpInfoBean empInfo = service.getEmployee(empId);
		modelMap.addAttribute("empInfoBean",empInfo);
		return"search";
	}
	
	@GetMapping("/getALLEmployee")
	public  String getAllEmployee( ModelMap modelMap) {
		List<EmpInfoBean> empInfoList = service.getAllEmployee();
		modelMap.addAttribute("empInfoBeanList",empInfoList);
		return"getAllEmployee";
	}
}//end of class
