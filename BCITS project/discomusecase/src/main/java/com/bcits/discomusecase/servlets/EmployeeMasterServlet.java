package com.bcits.discomusecase.servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.discomusecase.beans.EmployeeMaster;
@WebServlet("/addEmployeeMaster")
public class EmployeeMasterServlet extends HttpServlet{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //Get the Form Data
		 String firstNameVal = req.getParameter("firstName");
		 String middleNameVal = req.getParameter("middleName");
		 String lastNameVal = req.getParameter("lastName");
		 String regionVal = req.getParameter("region");
		 String designationVal = req.getParameter("designation");
		 String empIdVal = req.getParameter("empId");
		 String reempIdVal = req.getParameter("reempId");
		 
		 String name=firstNameVal+" "+middleNameVal+" "+lastNameVal;
		 
		 //Set the Data
		 EmployeeMaster employeeMaster = new EmployeeMaster();
				
	
	 
	 }

}
