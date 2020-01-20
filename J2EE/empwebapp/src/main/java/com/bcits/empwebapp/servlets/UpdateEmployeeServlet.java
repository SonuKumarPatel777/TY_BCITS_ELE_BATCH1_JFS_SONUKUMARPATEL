package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Valid The Scssion
		HttpSession session = req.getSession(false);
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		
		// Generate Dynamic Response
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html");
				out.println("<html>");
				out.println("<body>");
		if (session != null) {
			// valid session
			// Get the Form Data
			String empIdVal = req.getParameter("empId");
			String nameVal = req.getParameter("name");
			String mobileNumVal = req.getParameter("mobileNum");

			// Store the Data into DB
		    entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		    manager = entityManagerFactory.createEntityManager();
			EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, Integer.parseInt(empIdVal));
			EntityTransaction transaction = manager.getTransaction();
			Boolean isAdd = false;
			try {
				transaction.begin();
				employeePrimaryInfo.setName(nameVal);
				employeePrimaryInfo.setMobileNum(Long.parseLong(mobileNumVal));
				transaction.commit();
				isAdd = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();
			entityManagerFactory.close();

			
			if (isAdd) {
				out.println("<h1 style= 'color:green'>Employee record for Id " + empIdVal + " Updated </h1>");
			} else {
				out.println("<h1 style= 'color:red'>Employee record for Id " + empIdVal + " NOT found</h1>");
			}
			out.println("</html>");
			out.println("</body>");

			
		}else {
			//Invalid Session
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'> Please Login First !!<h1>");
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("loginForm.html").include(req, resp);

		}
		
		
	}// End of doPost()

}// End of Class
