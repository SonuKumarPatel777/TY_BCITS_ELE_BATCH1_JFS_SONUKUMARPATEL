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

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/findEmployee")
public class SearchEmployeeServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get the Form data
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = entityManagerFactory.createEntityManager();

		EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);

		// Generate Dynamic Response
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		if (employeePrimaryInfo != null) {
			// Display Employee record
			out.println("<html>");
			out.println("<body>");
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
		manager.close();
		entityManagerFactory.close();

	}// End of doGet()

}// Eed Of Class
