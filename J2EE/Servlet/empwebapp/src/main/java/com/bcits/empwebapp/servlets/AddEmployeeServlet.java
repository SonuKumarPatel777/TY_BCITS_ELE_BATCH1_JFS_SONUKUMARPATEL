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

import org.hibernate.sql.Template;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the Form Data
		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("name");
		String mobileNumVal = req.getParameter("mobileNum");
		String dateOfjoiningVal = req.getParameter("dateOfjoining");
		String designationVal = req.getParameter("designation");
		String employeeSalarymVal = req.getParameter("employeeSalary");
		String passwordVal = req.getParameter("password");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate = null;
		try {
			joiningDate = dateFormat.parse(dateOfjoiningVal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Set the Data
		EmployeePrimaryInfo employeePrimaryInfo = new EmployeePrimaryInfo();

		employeePrimaryInfo.setEmpId(Integer.parseInt(empIdVal));
		employeePrimaryInfo.setName(nameVal);
		employeePrimaryInfo.setMobileNum(Long.parseLong(mobileNumVal));
		employeePrimaryInfo.setDateOfjoining(joiningDate);
		employeePrimaryInfo.setDesignation(designationVal);
		employeePrimaryInfo.setEmployeeSalary(Double.parseDouble(employeeSalarymVal));
		employeePrimaryInfo.setPassword(passwordVal);

		// Store the Data in To DB
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Boolean isAdd = false;
		try {
			transaction.begin();
			manager.persist(employeePrimaryInfo);
			transaction.commit();
			isAdd = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		entityManagerFactory.close();

		// Generate Dynamic Response
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (isAdd) {
			out.println("<h1 style= 'color:green'>Employee record for Id " + empIdVal + " inserted </h1>");
		} else {
			out.println("<h1 style= 'color:red'>Employee record for Id " + empIdVal + " alread exist</h1>");
		}
		out.println("</html>");
		out.println("</body>");

	}// End of doPost()

}// End of Class
