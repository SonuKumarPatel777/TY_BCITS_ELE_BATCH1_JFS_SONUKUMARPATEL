package com.bcits.discomusecase.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.beans.AdminMasterBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.TarrifMasterBean;
import com.bcits.discomusecase.service.AdminMasterService;
import com.bcits.discomusecase.service.EmployeeMasterService;

@Controller
@RequestMapping("/admin")
public class AdminMasterController {

	@Autowired
	private AdminMasterService service;

	@Autowired
	private EmployeeMasterService employeeService;

	@GetMapping("/adminLoginPage")
	public String displayAdminLoginPage() {
		return "adminLogin";
	}// end of displayAdminLoginPage()

	@PostMapping("/adminLogin")
	public String authenticate(String userId, String password, ModelMap modelMap, HttpServletRequest req) {
		AdminMasterBean adminMasterBean = service.authentication(userId, password);
		if (adminMasterBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInAdmin", adminMasterBean);
			return "adminHomePage";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Creadential");
			return "adminLogin";
		}
	}// end of authenticate()

	@GetMapping("/adminLogout")
	public String consumerLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("msg", "successfully logged out...Thank U");
		return "adminLogin";
	}// end of consumerLogOut()

	@GetMapping("/adminDetail")
	public String dispalyAdminDetails(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		} else {
			return "adminDetail";
		}
	}// end of dispalyAdminDetails()

	@GetMapping("/resisterEmployee")
	public String dispalyResisterEmployeePage(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		} else {
			return "employeeRegister";
		}
	}// end of dispalyResisterEmployeePage()

	@PostMapping("/addEmployee")
	public String addEmployeeDetails(HttpSession session, EmployeeMasterBean employeeMasterBean, ModelMap modelMap,
			String cnfPassword) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		} else {
			if (service.registerEmployee(employeeMasterBean, cnfPassword)) {
				modelMap.addAttribute("msg", "SuccessfulIy register");
				return "adminHomePage";
			} else {
				modelMap.addAttribute("errMsg", "Register failed...!!! EmployeeId is Already used");
				return "adminHomePage";
			}
		}
	}// end of addEmployeeDetails()

	@GetMapping("/employeeDetail")
	public String dispalyEmployeeDetail(HttpSession session, ModelMap modelMap) {
		AdminMasterBean adminMasterBean = (AdminMasterBean) session.getAttribute("loggedInAdmin");
		if (adminMasterBean != null) {
			List<EmployeeMasterBean> employeeMasterBeanList = service.getAllEmployee();
			if (employeeMasterBeanList != null) {
				modelMap.addAttribute("employeeMasterList", employeeMasterBeanList);
				return "allEmployeeDetail";
			} else {
				modelMap.addAttribute("errMsg", "No  Tarrif   !!");
				return "adminHomePage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "adminLogin";
		}
	}// end of dispalyAllTarrif()

	@GetMapping("/removeEmployee")
	public String removeMyAccount(HttpSession session, ModelMap modelMap, int employeeId) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		} else {
			if (employeeService.removeEmployee(employeeId)) {
				modelMap.addAttribute("msg", "Employee is remove....");
				return "adminHomePage";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Delete Your Account");
				return "adminHomePage";
			}
		}
	}// end of removeMyAccount()

	@GetMapping("/tarrif")
	public String dispalyAllTarrif(HttpSession session, ModelMap modelMap) {
		AdminMasterBean adminMasterBean = (AdminMasterBean) session.getAttribute("loggedInAdmin");
		if (adminMasterBean != null) {
			List<TarrifMasterBean> tarrifMasterList = service.getTarrife();
			if (tarrifMasterList != null) {
				modelMap.addAttribute("tarrifMasterList", tarrifMasterList);
				return "tarrifDetails";
			} else {
				modelMap.addAttribute("errMsg", "No  Tarrif   !!");
				return "adminHomePage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "adminLogin";
		}

	}// end of dispalyAllTarrif()

	@GetMapping("/tarrifChange")
	public String dispalyAllTarrifChangePage(HttpSession session, ModelMap modelMap, String typeOfConsumer,
			int unitsRange) {
		AdminMasterBean adminMasterBean = (AdminMasterBean) session.getAttribute("loggedInAdmin");
		if (adminMasterBean != null) {
			int mulitplayerAmount = service.getMulitplayerAmount(typeOfConsumer, unitsRange);
			modelMap.addAttribute("typeOfConsumer", typeOfConsumer);
			modelMap.addAttribute("unitsRange", unitsRange);
			modelMap.addAttribute("mulitplayerAmount", mulitplayerAmount);
			return "TarrifChangePage";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "adminLogin";
		}
	}// end of dispalyAllTarrifChangePage()

	@PostMapping("/setTheTarrif")
	public String tarrifChange(HttpSession session, ModelMap modelMap,
			String typeOfConsumer,int unitsRange,int mulitplayerAmount) {
		AdminMasterBean adminMasterBean = (AdminMasterBean) session.getAttribute("loggedInAdmin");
		if (adminMasterBean != null) {
			if (service.tarrifChanged( typeOfConsumer, unitsRange, mulitplayerAmount)) {
				modelMap.addAttribute("msg", "SuccessfulIy Tarrif Changed");
				return "adminHomePage";
			} else {
				modelMap.addAttribute("errMsg", "failed...!!! Changed");
				return "adminHomePage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "adminLogin";
		}
	}// end of tarrifChange()

}// end of class
