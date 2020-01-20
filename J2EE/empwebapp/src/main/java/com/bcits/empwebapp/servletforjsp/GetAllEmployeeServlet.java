package com.bcits.empwebapp.servletforjsp;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/seeAllEmployee")
public class GetAllEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		manager = entityManagerFactory.createEntityManager();

		String jpql = "from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> empList=query.getResultList();
		
		//send data to JSp
        req.setAttribute("emplist", empList);
        
		manager.close();
        entityManagerFactory.close();
        
        
        req.getRequestDispatcher("./seeAllEmployee.jsp").forward(req, resp);
        

	}// End of doGet()

}// End of Class
