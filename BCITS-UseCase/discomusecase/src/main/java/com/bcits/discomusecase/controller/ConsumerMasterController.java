package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Severity;
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

import com.bcits.discomusecase.beans.BillHistoryBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.HelpConsumerBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
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
			modelMap.addAttribute("errMsg", "Registation failed...!!!");
			return "consumerRegister";
		}
	}// end of addConsumerDetails()

	@PostMapping("/consumerLogin")
	public String authenticate(String meterNumber, String password, ModelMap modelMap, HttpServletRequest req) {
		ConsumersMasterBean consumersMasterBean = service.authentication(meterNumber, password);
		if (consumersMasterBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInCons", consumersMasterBean);
			return "consumerHomePage";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Creadential");
			return "consumerlogin";
		}
	}// end of authenticate()

	@GetMapping("/consumerLogout")
	public String consumerLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "consumerlogin";
	}// end of consumerLogOut()

	@GetMapping("/consumerDetail")
	public String dispalyConsumerDetails(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			return "consumerDetail";
		}
	}// end of dispalyConsumerDetails()
	
	@GetMapping("/removeMyAccount")
	public String removeMyAccount(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			ConsumersMasterBean consumerInfoBean = (ConsumersMasterBean) session.getAttribute("loggedInCons");
			if (service.removeConsumer(consumerInfoBean.getMeterNumber())) { 
				modelMap.addAttribute("msg", "Your Account is No longer....");
				return "home";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Delete Your Account");
				return "consumerFailedPage";
			}	
		}
	}// end of removeMyAccount()

	@GetMapping("/displayCurrentBillPage")
	public String displayCurrentBillPage(HttpSession session, ModelMap modelMap) {
		ConsumersMasterBean consumerInfoBean = (ConsumersMasterBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			CurrentBillBean currentBill = service.getCurrentBill(consumerInfoBean.getMeterNumber());
			if (currentBill != null) {
				modelMap.addAttribute("currentBill", currentBill);
				return "consumerCurrentBillPage";
			} else {
				modelMap.addAttribute("errMsg", "No  Current Bill Generate For You  !!");
				return "consumerFailedPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerlogin";
		}
	}// end of displayCurrentBillPage()

	@GetMapping("/monthlyConsumption")
	public String dispalyConsumerMonthlyConsumption(HttpSession session, ModelMap modelMap) {
		ConsumersMasterBean consumersMasterBean = (ConsumersMasterBean) session.getAttribute("loggedInCons");
			if (consumersMasterBean != null) {
				String meterNumber = consumersMasterBean.getMeterNumber();
				List<MonthlyConsumptionBean> monthlyConsumptionBean = service.getMonthlyConsumption(meterNumber);
				if(monthlyConsumptionBean != null) {
					modelMap.addAttribute("monthlyConsumption", monthlyConsumptionBean);
					return "consumerMonthlyConsumption";
				}else {
					modelMap.addAttribute("errMsg", "No  Monthly Consumption Bill For You  !!");
					return "consumerFailedPage";
				}			
			}else {
				modelMap.addAttribute("errMsg", "Please Login First..");
				return "consumerlogin";
			} 
		
	}// end of dispalyConsumerMonthlyConsumption()
	
	@GetMapping("/displayBillPanding")
	public String dispalyPandingBillForConsumption(HttpSession session, ModelMap modelMap) {
		ConsumersMasterBean consumersMasterBean = (ConsumersMasterBean) session.getAttribute("loggedInCons");
			if (consumersMasterBean != null) {
				String meterNumber = consumersMasterBean.getMeterNumber();
				List<MonthlyConsumptionBean> monthlyConsumptionBean = service.getMonthlyConsumption(meterNumber);
				if(monthlyConsumptionBean != null) {
					modelMap.addAttribute("monthlyConsumption", monthlyConsumptionBean);
					return "consumerBillPanding";
				}else {
					modelMap.addAttribute("errMsg", "No  Monthly Consumption Bill For You  !!");
					return "consumerFailedPage";
				}			
			}else {
				modelMap.addAttribute("errMsg", "Please Login First..");
				return "consumerlogin";
			} 
		
	}// end of dispalyPandingBillForConsumption()
	
	
	@GetMapping("/paymentPage")
	public String dispalyPandingBillPaymentPage(HttpSession session, ModelMap modelMap,
			Double billAmount) {
		ConsumersMasterBean consumersMasterBeann = (ConsumersMasterBean) session.getAttribute("loggedInCons");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			if (consumersMasterBeann != null) {
				Double  pandingBillAmount= billAmount;
				modelMap.addAttribute("pandingBillAmount", pandingBillAmount);
				return "consumerBillpandingPayment";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Pay");
				return "consumerFailedPage";
			}
		}
	}// end of dispalyPandingBillPaymentPage()
	
	@PostMapping("/clearPandingBill")
	public String clearPandingBill(HttpSession session, ModelMap modelMap,Double billAmount) {
		
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			ConsumersMasterBean consumersMasterBeann = (ConsumersMasterBean) session.getAttribute("loggedInCons");
			if (consumersMasterBeann != null) {
				String meterNumber = consumersMasterBeann.getMeterNumber();
				if (service.clearPandingBill(meterNumber, billAmount)) {
					return "consumerPaymentsuccessfullpage";
				} else {
					modelMap.addAttribute("errMsg", "Unable to Pay");
					return "consumerPaymentPage";
				}
			} else {
				modelMap.addAttribute("errMsg", "Unable to Pay");
				return "consumerFailedPage";
			}
		}
	}// end of clearPandingBill()
	
	@GetMapping("/consumerPaymentPage")
	public String dispalyPaymentPage(HttpSession session, ModelMap modelMap) {
		ConsumersMasterBean consumersMasterBeann = (ConsumersMasterBean) session.getAttribute("loggedInCons");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			if (consumersMasterBeann != null) {
				String meterNumber = consumersMasterBeann.getMeterNumber();
				Double  currentBill= service.getBillAmount(meterNumber);
				modelMap.addAttribute("currentBill", currentBill);
				return "consumerPaymentPage";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Pay");
				return "consumerFailedPage";
			}
		}
	}// end of dispalyPaymentPage()

	@PostMapping("/paymentSuccessfullPage")
	public String dispalypaymentSuccessfullPage(HttpSession session, ModelMap modelMap) {
		
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			ConsumersMasterBean consumersMasterBeann = (ConsumersMasterBean) session.getAttribute("loggedInCons");
			if (consumersMasterBeann != null) {
				Date date = new Date();
				String meterNumber = consumersMasterBeann.getMeterNumber();
				Double amount = service.getBillAmount(meterNumber);
				if (service.successfullBillPayment(meterNumber, date, amount)) {
					return "consumerPaymentsuccessfullpage";
				} else {
					modelMap.addAttribute("errMsg", "Unable to Pay");
					return "consumerPaymentPage";
				}
			} else {
				modelMap.addAttribute("errMsg", "Unable to Pay");
				return "consumerFailedPage";
			}
		}
	}// end of dispalyPaymentPage()
	

	@GetMapping("/displayBillHistorysPage")
	public String displayBillHistoryPage(HttpSession session, ModelMap modelMap) {
		ConsumersMasterBean consumersMasterBean = (ConsumersMasterBean) session.getAttribute("loggedInCons");
		if (consumersMasterBean != null) {
			List<BillHistoryBean> billHistoryList = service.getBillHistory(consumersMasterBean.getMeterNumber());
			if (billHistoryList != null) {
				modelMap.addAttribute("billHistory", billHistoryList);
				return "consumerBillHistoryPage";
			} else {
				modelMap.addAttribute("errMsg", "No  Bill History For You  !!");
				return "consumerFailedPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}// end of displayBillHistoryPage()
	
	@GetMapping("/displayConsumerHelpPage")
	public String displayConsumerHelpPage(HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
		return "consumerHelpPage";
		}
	}// end of displayConsumerHelpPage()
	
	@PostMapping("/consumerHelp")
	public String consumerHelp(HttpSession session, ModelMap modelMap, String querie) {
		ConsumersMasterBean consumersMasterBeann = (ConsumersMasterBean) session.getAttribute("loggedInCons");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First !!!");
			return "consumerlogin";
		} else {
			if (service.setQuerie(consumersMasterBeann, querie)) {
				modelMap.addAttribute("msg", "Querie send");
				return "consumerHelpPage";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Process");
				return "consumerFailedPage";
			}
		}
	}// end of dispalyPaymentPage()
	
	@GetMapping("/employeeResponce")
	public String employeeResponce(HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerlogin";
		} else {
			ConsumersMasterBean consumersMasterBeann = (ConsumersMasterBean) session.getAttribute("loggedInCons");
			String meterNumber = consumersMasterBeann.getMeterNumber();
			List<HelpConsumerBean> employeeResponceList =  service.getAllResponse(meterNumber);
			if(employeeResponceList != null) {
				for( HelpConsumerBean helpConsumerBean
			    		 :employeeResponceList){
				}
				modelMap.addAttribute("employeeResponceList", employeeResponceList );
			}else {
				modelMap.addAttribute("errMsg", "Unable to Load");	 
			}
		return "employeeResponce";
		}
	}// end of employeeResponce()
	
	@GetMapping("/forgotPasswordPage")
	public String displayConsumerForgotPasswordPage(){
		return "consumerForgotPassword";
	}// end of displayConsumerForgotPasswordPage()
	
	@PostMapping("/forgotPasswordSet")
	public String consumerPasswordSet(ConsumersMasterBean consumersMasterBean, String confPassword,ModelMap modelMap){
		if(service.authenticationForSetPassword(consumersMasterBean)){
			if(service.reSetPassword(consumersMasterBean, confPassword)){
				modelMap.addAttribute("msg", "Password reset successfully !!");
			}else{
				modelMap.addAttribute("errMsg", "Unable To reset The Password!!");
			}
			return "officerLogin";
		}else{
			modelMap.addAttribute("errMsg", "Invalid Meter Number Or Email");
			return "consumerForgotPassword";
		}
	}// end of consumerPasswordSet()

}// end of class
