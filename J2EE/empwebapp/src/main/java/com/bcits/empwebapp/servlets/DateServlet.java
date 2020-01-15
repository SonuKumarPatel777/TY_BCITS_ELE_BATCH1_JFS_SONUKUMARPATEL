package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Java cord to generate current System date & time (dynamic)
		Date date = new Date();
		
        //code to generate dynamic response
		resp.setContentType("text/html");
        resp.setHeader("refresh", "1");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Current System date & time" + date + "</h1>");
		out.println("</body>");
		out.println("</html>");

	}// End Of doGet()

}// End of Class