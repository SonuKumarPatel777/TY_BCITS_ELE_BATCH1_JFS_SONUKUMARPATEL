package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.service.ConsumerMasterService;
import com.bcits.discomusecase.service.EmployeeMasterService;

@Controller
@RequestMapping("/employee")
public class EmployeeMasterController {
	
	@Autowired
	private EmployeeMasterService service;
	
	@Autowired
	private ConsumerMasterService consumerService;

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}//end of initBinder()
	
	@GetMapping("/employeeLogin")
	public String displayEmployeeLoginPage() {
		return "officerLogin";
	}// end of displayLoginPage()
	
	@GetMapping("/employeeDetail")
	public String dispalyEmployeeDetails(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			return "EmployeeDetail";
		}
	}// end of dispalyConsumerDetails()
	
	@PostMapping("/employeeLoginHome")
	public String authenticate(int employeeId, String password, ModelMap modelMap,HttpServletRequest req) {
		EmployeeMasterBean employeeMasterBean=service.authentication(employeeId,password); 
        if( employeeMasterBean!= null) { 
	        HttpSession session = req.getSession(true);
       	    session.setAttribute("loggedInEmp", employeeMasterBean);
       	    return "employeeHomePage";
        }else {
	     modelMap.addAttribute("errMsg","Invalid Creadential");
	    return "officerLogin";
        }     
	}// end of authenticate()
	
	@GetMapping("/employeeLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "officerLogin";
	}//end of employeeLogOut()
	
	
	@GetMapping("/detail")
	public String dispalyConsumerDetails(HttpSession session ,ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "officerLogin";
		}else {
			return "employeeConsumerDetails";
		}
	}//end of dispalyConsumerDetails()
	
	
	@GetMapping("/getAllConsumer")
	public String getAllConsumer(HttpSession session ,ModelMap modelMap) {
		EmployeeMasterBean employeeMasterBean = (EmployeeMasterBean)session.getAttribute("loggedInEmp");
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "officerLogin";
		}else {
			if(employeeMasterBean != null) {
			  String region = employeeMasterBean.getRegion();
			  List<ConsumersMasterBean> consumersMasterList=service.getAllConsumer(region);
			  modelMap.addAttribute("consumersMasterList",consumersMasterList);
			  return "employeeConsumerDetails";
			}else {
				modelMap.addAttribute("errMsg","Unable to Load");
				return "consumerFailedPage";
			}
		}
	}//end of getAllConsumer()
	
	
	@GetMapping("/billGeneration")
	public String dispalyBillGeneration(HttpSession session ,ModelMap modelMap) {
		EmployeeMasterBean employeeMasterBean = (EmployeeMasterBean)session.getAttribute("loggedInEmp");
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "officerLogin";
		}else {
			if(employeeMasterBean != null) {
			  String region = employeeMasterBean.getRegion();
			  List<ConsumersMasterBean> consumersMasterList=service.getAllConsumer(region);
			  modelMap.addAttribute("consumersMasterList",consumersMasterList);
			  return "employeeBillGeneration";
			}else {
				modelMap.addAttribute("errMsg","Unable to Load");
				return "consumerFailedPage";
			}
		}
	}//end of dispalyBillGeneration()
	
	@GetMapping("/currentBillPageGen")
	public String displayCurrentBillPageGen(HttpSession session ,ModelMap modelMap,String meterNumber ) {
		EmployeeMasterBean empMasterInfo = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			ConsumersMasterBean consumersMasterBean = consumerService.getConsumer(meterNumber);
			int previousReading = consumerService.getPreviousReading(meterNumber);
			if(consumersMasterBean != null) {
				modelMap.addAttribute("consumerBean",consumersMasterBean);
				modelMap.addAttribute("previousReading",previousReading);
			}    
		}else { 
			   modelMap.addAttribute("errMsg","Unable to Load ");
			   return "consumerFailedPage";
			}
			return "currentBillPageGenration";
	}// end of displayCurrentBillPage()
	
	@PostMapping("/generateBillForConsumer")
	public String currentBillGeneration(HttpSession session,ModelMap modelMap,CurrentBillBean currentBillBean) {
		EmployeeMasterBean empMasterInfo = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<ConsumersMasterBean> consumersMasterBeansList = service.getAllConsumer(empMasterInfo.getRegion());
			modelMap.addAttribute("consumerList", consumersMasterBeansList);
			if(service.addCurrentBillToMonthlyConsumption(currentBillBean)){
				modelMap.addAttribute("msg", "Bill generated for  Meter Number  " + currentBillBean.getMeterNumber() +  " SuccessFully...");
			}else {
				modelMap.addAttribute("errMsg", "Failed to Generate the Bill");
			}
			return "employeeBillGeneration";
		}else {
				modelMap.addAttribute("errMsg","Please Login First");
				return "officerLogin";
			}
		
	}//end of currentBillGeneration()
	
	

}//end of class
