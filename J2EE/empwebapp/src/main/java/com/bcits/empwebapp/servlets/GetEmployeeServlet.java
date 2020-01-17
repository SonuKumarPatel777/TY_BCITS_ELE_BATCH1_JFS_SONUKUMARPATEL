package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/getEmployee")
public class GetEmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Valid The Scssion
		HttpSession session = req.getSession(false);
		EntityManagerFactory entityManagerFactory =null;
		EntityManager manager =null;

		// Generate Dynamic Response
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (session != null) {
			// valid session
			// Get the Form data
			String empIdVal = req.getParameter("empId");
			int empId = Integer.parseInt(empIdVal);

			entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			manager = entityManagerFactory.createEntityManager();

			EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);

			if (employeePrimaryInfo != null) {
				// Display Employee record
				
				EmployeePrimaryInfo loggedInInfo = (EmployeePrimaryInfo)session.getAttribute("employeePrimaryInfo");
				out.println("<html>");
				out.println("<body>");
				out.println("<h1> Hello "+employeePrimaryInfo.getName()+"</h1><br>");
				out.println("<h1><a href=\"./employeeHome.html\">Home</a></h1><br>");
				
				out.println("<h1 style='color:green'>Employye ID " + empId + " Found!!!</h1><br>");
				out.println("<br>Name=" + employeePrimaryInfo.getName());
				out.println("<br>mobileNum=" + employeePrimaryInfo.getMobileNum());
				out.println("<br>Offical_MailId=" + employeePrimaryInfo.getOfficalMailId());
				out.println("<br>D.O.B.= " + employeePrimaryInfo.getDateOfBirth());
				out.println("<br>D.O.J.= " + employeePrimaryInfo.getDateOfjoining());
				out.println("<br>Designation=" + employeePrimaryInfo.getDesignation());
				out.println("<br>Blood Group=" + employeePrimaryInfo.getBloodGroup());
				out.println("<br>Salary= " + employeePrimaryInfo.getEmployeeSalary());
				out.println("<br>Department  ID=" + employeePrimaryInfo.getDepartmentId());
				out.println("<br>Manager ID=" + employeePrimaryInfo.getManagerId());
				out.println("</body>");
				out.println("</html>");

			} else {
				// Display employee not found
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color:red'>Employye ID " + empId + " Not Found!!!<h1>");
				out.println("</body>");
				out.println("</html>");

			}

		}else {
			//Invalid Session
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'> Please Login First !!<h1>");
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("loginForm.html").include(req, resp);

		}

		manager.close();
		entityManagerFactory.close();

	}// End of doGet()

}// Eed Of Class
