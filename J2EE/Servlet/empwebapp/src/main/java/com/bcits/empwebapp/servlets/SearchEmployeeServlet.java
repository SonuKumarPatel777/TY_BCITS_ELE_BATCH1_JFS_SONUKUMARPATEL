package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String empIdVal = req.getParameter("empId");
	 
	 resp.setContentType("text/html");
	 
	 PrintWriter out  = resp.getWriter();
	 out.print("<html>");
	 out.print("<body>");
	 out.print("<h1>Employee ID = "+empIdVal+"</h1>");
	 out.print("Employee name = Prashul <br>");
	 out.print("Employee Salary = 25000 <br> ");
	 out.print("Employee Manager =10101");
	 out.print("</bbody>");
	 out.print("</html>");
		
	}//End of doGet()

}//End of Class
