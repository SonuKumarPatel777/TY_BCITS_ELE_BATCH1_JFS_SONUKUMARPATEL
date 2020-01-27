package com.bcits.springmvc.controller;

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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.dao.EmlployeeDAO;
import com.bcits.springmvc.dao.EmployeeDAOHibernateImp;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dataEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dataEditor);
	}//End of initBinder()
	
	@Autowired
	 private EmployeeService service ;
	
	@GetMapping("/login")
	public String displayLoginForm() {
		
		return "employeeLoginForm";
	}//End of displayLoginForm()
	
	@PostMapping("/login")
	public String authenticate(int empId ,String password, HttpServletRequest req,ModelMap modelMap) { 
		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		if(employeeInfoBean != null) {
			//valid Credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedIngInfo", employeeInfoBean);
			
			return "employeeHome";
		}else {
			//Invalid Credentials
			modelMap.addAttribute("errMsg","Invalid Creadential");
			return "employeeLoginForm";
		}
	}//End of authenticate()
	
	
	
	@GetMapping("/searchEmpForm")
	public  String displaySearchEmployeeForm( HttpSession session ,ModelMap modelMap) {
		 if(session .isNew()) {
			 session.invalidate();
			 modelMap.addAttribute("errMsg"," Please Login First");
			 return "employeeLoginForm";
		 }else {
			 return "searchEmpForm";
		 }
		
	}//End of displaySearchEmployeeForm()
	
	
	@GetMapping("/search")
	public String searchEmployee(int empId,HttpSession session, ModelMap modelMapm) {
		if(session.getAttribute("loggedIngInfo") != null) {
			//Valid Session
			 
			EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
			if(employeeInfoBean != null) {
				modelMapm.addAttribute("employeeInfoBean", employeeInfoBean);
			}else {
				modelMapm.addAttribute("errMsg", "Employee ID not Found");
			}
			return "searchEmpForm";
		}else {
			//Invalid Credentials
			modelMapm.addAttribute("errMsg","Please Login First");
			return "employeeLoginForm";
			
		}
		
	}//End of searchEmployee()
	
	
@GetMapping("/deleteEmpForm")	
public String displaydeleteEmployee(@SessionAttribute(name="loggedIngInfo", required = false) EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
	if(employeeInfoBean != null) {
		//Valid Session
		return "deleteEmpForm";
	}else {
		//Invalid Credentials
		modelMap.addAttribute("errMsg","Please Login First");
		return "employeeLoginForm";
	}
		
	}//End of displaydeleteEmployee()


@GetMapping("/delete")
public String deleteEmployee(int empId,
		@SessionAttribute(name="loggedIngInfo", required = false) EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
	if(employeeInfoBean != null) {
		//Valid Session
		 
		if(service.deleteEmployee(empId)) {
			modelMap.addAttribute("msg","Employee record successfully delete");
			
		}else {
			modelMap.addAttribute("errMsg","Employee ID not found !!");
		}
		return "deleteEmpForm";
	}else {
		//Invalid Credentials
		modelMap.addAttribute("errMsg","Please Login First");
		return "employeeLoginForm";
	}
		
	}//End of deleteEmployee()



@GetMapping("/logout")
public String logout(HttpSession session, ModelMap modelMap) {
	session.invalidate();
	modelMap.addAttribute("errMsg","You are successfully logout");
	
	return "employeeLoginForm";
}//End of logout()

@GetMapping("/seeAllEmployee")
public String getAllEmployeeInfo(
		@SessionAttribute(name = "loggedIngInfo", required = false) EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
	if (employeeInfoBean != null) {
		//Valid Session
		List<EmployeeInfoBean> empInfoList = service.getAllEmployee();
		modelMap.addAttribute("allEmpDetails", empInfoList);
		return "getAllEmpForm";
	} else {
		// Invalid session
		modelMap.addAttribute("errMsg", "Please Login First..");
		return "employeeLoginForm";
	}
}//End of getAllEmployeeInfo()


@GetMapping("/updateEmpForm")
public String displayUpdateEmpForm(
		@SessionAttribute(name = "loggedIngInfo", required = false) EmployeeInfoBean empInfoBean, ModelMap modelMap) {
	if (empInfoBean != null) {
		//Valid Session
		return "updateEmpForm";
	} else {
		modelMap.addAttribute("errMsg", "Please Login First..");
		return "employeeLoginForm";
	}
}//End of displayUpdateEmpForm()

@PostMapping("/updateEmployee")
public String updateEmpForm(EmployeeInfoBean empBean,
		@SessionAttribute(name = "loggedIngInfo", required = false) EmployeeInfoBean empInfoBean, ModelMap modelMap) {
	if (empInfoBean != null) {
		//Valid Session
		if (service.updateEmployee(empBean)) {
			modelMap.addAttribute("msg", "Employee Record Updated Sucessfully..");
		} else {
			modelMap.addAttribute("errMsg", "Employee Id is Not Found..");
		}
	} else {
		// Invalid session
		modelMap.addAttribute("errMsg", "Please Login First..");
		return "employeeLoginForm";
	}
	return "updateEmpForm";
}//End of  updateEmpForm()

@GetMapping("/addEmpForm")
public String displayAddEmpForm(
		@SessionAttribute(name = "loggedIngInfo", required = false) EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
	if (employeeInfoBean != null) {
		//Valid Session
		return "addEmpForm";
	} else {
		modelMap.addAttribute("errMsg", "Please Login First..");
		return "employeeLoginForm";
	}
}//End of displayAddEmpForm()


@PostMapping("/addEmployee")
public String addEmpRecord(
		@SessionAttribute(name = "loggedIngInfo", required = false) EmployeeInfoBean employeeInfoBean,ModelMap modelMap,
		EmployeeInfoBean employeeInfoBeanRecord,String confpassword ) {
	if (employeeInfoBean != null) {
		//Valid Session
		if(service.addEmployee(employeeInfoBeanRecord,confpassword)) {
			modelMap.addAttribute("msg", "Insert the Employee Record..");
			return "addEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "Failed to Insert the Employee Record..");
			return "addEmpForm";
		}
	} else {
		// Invalid session
		modelMap.addAttribute("errMsg", "Please Login First..");
		return "employeeLoginForm";
	}
		
}//End of addEmpRecord()





}//End of Class
