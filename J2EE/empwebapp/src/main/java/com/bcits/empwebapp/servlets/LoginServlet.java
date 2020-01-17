package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int empIdval = Integer.parseInt(req.getParameter("empId"));
		String Password = req.getParameter("password");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = entityManagerFactory.createEntityManager();

		String jpql = "from EmployeePrimaryInfo where empId=:empId and password=:pwd";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empIdval);
		query.setParameter("pwd", Password);

		EmployeePrimaryInfo employeePrimaryInfo = null;
		try {
			employeePrimaryInfo = (EmployeePrimaryInfo) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (employeePrimaryInfo != null) {
			// valid Credentials
			// Create A Session
			HttpSession session = req.getSession(true);

			session.setMaxInactiveInterval(30);
			session.setAttribute("employeePrimaryInfo", employeePrimaryInfo);

			out.println("<h1 style='color:green;'>" + employeePrimaryInfo.getName()
					+ " Welcome to Employee Home Page</h1>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./employeeHome.html");
			requestDispatcher.include(req, resp);
		} else {
			out.println("<h1>" + employeePrimaryInfo + " not found</h1>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./loginForm.html");
			requestDispatcher.include(req, resp);

		}
		out.println("</body>");
		out.println("</html>");
		manager.close();
		entityManagerFactory.close();

	}// End of doPost()

}// End Of Class
