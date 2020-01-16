package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get the Form data
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = entityManagerFactory.createEntityManager();

		EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);
		EntityTransaction transaction = manager.getTransaction();
		Boolean isDelete = false;
		try {
			transaction.begin();
			manager.remove(employeePrimaryInfo);
			transaction.commit();
			isDelete = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Generate Dynamic Response
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		if (isDelete) {
			// Delete Employee record
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Employye ID " + empId + " Delete <h1>");
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

}
