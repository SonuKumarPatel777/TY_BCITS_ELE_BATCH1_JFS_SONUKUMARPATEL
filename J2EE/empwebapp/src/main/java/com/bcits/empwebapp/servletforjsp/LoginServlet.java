package com.bcits.empwebapp.servletforjsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/login2")
public class LoginServlet extends HttpServlet{
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
		if(employeePrimaryInfo != null) {
			//Valid Creadentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeePrimaryInfo);
			
			req.getRequestDispatcher("./homePage.jsp").forward(req, resp);
		}else {
			//Invalid Creadentials
			req.setAttribute("msg","Invalid Emplyee ID/ Password");
			req.getRequestDispatcher("./loginForm.jsp").forward(req, resp);
		}
	}//End of doPost()

}//End of Class
