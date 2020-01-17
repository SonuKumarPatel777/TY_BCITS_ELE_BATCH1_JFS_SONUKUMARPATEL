package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if(session != null) {
			session.invalidate();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 Style='color:red;'>Successfully logged out</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./loginForm.html");
		requestDispatcher.include(req, resp);
		
	}//End of doGet()

}//End of Class
