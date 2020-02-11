package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.beans.BillHistoryBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.HelpConsumerBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.service.ConsumerMasterService;
import com.bcits.discomusecase.service.EmployeeMasterService;

@Controller
@RequestMapping("/employee")
public class EmployeeMasterController {

	@Autowired
	private EmployeeMasterService employeeService;

	@Autowired
	private ConsumerMasterService consumerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}// end of initBinder()

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
	public String authenticate(int employeeId, String password, ModelMap modelMap, HttpServletRequest req) {
		EmployeeMasterBean employeeMasterBean = employeeService.authentication(employeeId, password);
		if (employeeMasterBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmp", employeeMasterBean);
			return "employeeHomePage";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Creadential");
			return "officerLogin";
		}
	}// end of authenticate()

	@GetMapping("/removeAccount")
	public String removeMyAccount(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			EmployeeMasterBean employeeInfoBean = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
			if (employeeService.removeEmployee(employeeInfoBean.getEmployeeId())) {
				modelMap.addAttribute("msg", "Your Account is No longer....");
				return "home";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Delete Your Account");
				return "employeeFailedPage";
			}
		}
	}// end of removeMyAccount()

	@GetMapping("/employeeLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "officerLogin";
	}// end of employeeLogOut()

	@GetMapping("/detail")
	public String dispalyConsumerDetails(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			return "employeeConsumerDetails";
		}
	}// end of dispalyConsumerDetails()

	@GetMapping("/getAllConsumer")
	public String getAllConsumer(HttpSession session, ModelMap modelMap) {
		EmployeeMasterBean employeeMasterBean = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			if (employeeMasterBean != null) {
				String region = employeeMasterBean.getRegion();
				List<ConsumersMasterBean> consumersMasterList = employeeService.getAllConsumer(region);
				modelMap.addAttribute("consumersMasterList", consumersMasterList);
				return "employeeConsumerDetails";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Load");
				return "consumerFailedPage";
			}
		}
	}// end of getAllConsumer()

	@GetMapping("/billHistory")
	public String billHistory(HttpSession session, ModelMap modelMap) {
		EmployeeMasterBean employeeMasterBean = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			if (employeeMasterBean != null) {
				String region = employeeMasterBean.getRegion();
				List<ConsumersMasterBean> consumersMasterList = employeeService.getAllConsumer(region);
				modelMap.addAttribute("consumersMasterList", consumersMasterList);
				return "billHistory";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Load");
				return "consumerFailedPage";
			}
		}
	}// end of billHistory()

	@GetMapping("/viewBillHistory")
	public String viewBillHistory(HttpSession session, ModelMap modelMap, String meterNumber) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			List<BillHistoryBean> billHistoryList = consumerService.getBillHistory(meterNumber);
			if (billHistoryList != null) {
				modelMap.addAttribute("billHistory", billHistoryList);
				return "viewBillHistoryPage";
			} else {
				modelMap.addAttribute("errMsg", "No  Bill History For You  !!");
				return "employeeFailedPage";
			}
		}
	}// end of viewBillHistory()

	@GetMapping("/removeConsumer")
	public String removeConsumer(HttpSession session, ModelMap modelMap, String meterNumber) {
		EmployeeMasterBean employeeMasterBean = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			if (consumerService.removeConsumer(meterNumber)) {

				modelMap.addAttribute("msg", "Consumer Remove Successfully");
				return "employeeHomePage";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Load");
				return "employeeFailedPage";
			}
		}
	}// end of removeConsumer()

	@GetMapping("/billGeneration")
	public String dispalyConsumerForBillGeneration(HttpSession session, ModelMap modelMap) {
		EmployeeMasterBean employeeMasterBean = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			if (employeeMasterBean != null) {
				String region = employeeMasterBean.getRegion();
				List<ConsumersMasterBean> consumersMasterList = employeeService.getAllConsumer(region);
				modelMap.addAttribute("consumersMasterList", consumersMasterList);
				return "employeeBillGeneration";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Load");
				return "employeeFailedPage";
			}
		}
	}// end of dispalyBillGeneration()

	@GetMapping("/currentBillPageGen")
	public String displayCurrentBillPageGen(HttpSession session, ModelMap modelMap, String meterNumber) {
		EmployeeMasterBean empMasterInfo = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if (empMasterInfo != null) {
			ConsumersMasterBean consumersMasterBean = consumerService.getConsumer(meterNumber);
			int previousReading = consumerService.getPreviousReading(meterNumber);
			if (consumersMasterBean != null) {
				modelMap.addAttribute("consumerBean", consumersMasterBean);
				modelMap.addAttribute("previousReading", previousReading);
			}
		} else {
			modelMap.addAttribute("errMsg", "Unable to Load ");
			return "employeeFailedPage";
		}
		return "currentBillPageGenration";
	}// end of displayCurrentBillPage()

	@PostMapping("/generateBillForConsumer")
	public String currentBillGeneration(HttpSession session, ModelMap modelMap, CurrentBillBean currentBillBean) {
		EmployeeMasterBean empMasterInfo = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
		if (empMasterInfo != null) {
			if (employeeService.currentBillGeneration(currentBillBean)) {
				modelMap.addAttribute("msg", "Bill generated for  Meter Number  " + currentBillBean.getMeterNumber()
				+ " SuccessFully... ");
				if (employeeService.sendMail(currentBillBean.getMeterNumber())) {
					modelMap.addAttribute("msg", "Bill generated for  Meter Number  " + currentBillBean.getMeterNumber()
							+ " SuccessFully... mail send");
				} else {
					modelMap.addAttribute("errMsg", "Bill generated for  Meter Number  "
							+ currentBillBean.getMeterNumber() + " SuccessFully... but failed to send mail !!");
				}
				return "employeeHomePage";
			} else {
				modelMap.addAttribute("errMsg", "Failed to Generate the Bill !!!!!!!!!!!!");
				return "employeeHomePage";
			}

		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		}

	}// end of currentBillGeneration()

	@GetMapping("/dispalyQueryResolvePage")
	public String dispalyQueryResolve(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			EmployeeMasterBean empMasterInfo = (EmployeeMasterBean) session.getAttribute("loggedInEmp");
			String region = empMasterInfo.getRegion();
			List<HelpConsumerBean> helpConsumerBeanList = employeeService.getAllComplaints(region);
			if (helpConsumerBeanList != null) {
				modelMap.addAttribute("helpConsumerComplaintsBeanList", helpConsumerBeanList);
			} else {
				modelMap.addAttribute("errMsg", "No Complaints");
			}
			return "queryResolvePage";
		}
	}// end of dispalyQueryResolve()

	@GetMapping("/employeeResponcePage")
	public String dispalyResponPage(HttpSession session, ModelMap modelMap, String meterNumber, Date queryDate) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			String getSingleComplaint = employeeService.getSingleComplaint(meterNumber, queryDate);
			if (getSingleComplaint != null) {
				modelMap.addAttribute("getSingleComplaint", getSingleComplaint);
				modelMap.addAttribute("meterNumber", meterNumber);
				modelMap.addAttribute("queryDate", queryDate);
			} else {
				modelMap.addAttribute("errMsg", "No Complaints");
			}
			return "employeeResponcePage";
		}
	}// end of dispalyResponPage()

	@PostMapping("/giveResponse")
	public String giveResponceToConsumer(HttpSession session, String meterNumber, Date queryDate, ModelMap modelMap,
			String responce) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "officerLogin";
		} else {
			if (employeeService.sendRespond(meterNumber, responce, queryDate)) {
				modelMap.addAttribute("msg", "Responce Send");
			} else {
				modelMap.addAttribute("errMsg", "Responce on hold...");
			}
			return "employeeResponcePage";
		}
	}// end of giveResponceToConsumer()

}// end of class
