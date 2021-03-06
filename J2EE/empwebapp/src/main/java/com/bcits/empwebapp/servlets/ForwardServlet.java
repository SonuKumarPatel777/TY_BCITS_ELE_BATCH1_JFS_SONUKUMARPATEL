package com.bcits.empwebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String url ="./date.html";//(static)
		String url ="./currentDate";//(dynamic)
		
		//String url="";//404 (We can not forward to External Recourse)
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
		requestDispatcher.forward(req, resp);
	}//End of doGet()

}//End of Class
