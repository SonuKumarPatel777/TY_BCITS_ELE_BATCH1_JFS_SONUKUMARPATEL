package com.bcits.empwebapp.servletforjsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/getEmp")
public class GetEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		// Get the Form data
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);

		entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		manager = entityManagerFactory.createEntityManager();

		EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);
		
		//send data to JSp
        req.setAttribute("empInfo", employeePrimaryInfo);
        
		manager.close();
        entityManagerFactory.close();
        
        
        req.getRequestDispatcher("./searchEmployee.jsp").forward(req, resp);
        
	}// End of doGetz()

}// End of Class
