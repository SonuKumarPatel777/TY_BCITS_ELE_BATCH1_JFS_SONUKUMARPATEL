package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/myGenericServlet")
public class MyGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String eNameValu = req.getParameter("eName");
		
		res.setContentType("text/html");
		
		PrintWriter out =res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 Style='color:navy';>Welcome to Generic Servlet </h1>");
		out.println("<h2> Employee name ="+eNameValu+"</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}//End of service()

}//End of Class
