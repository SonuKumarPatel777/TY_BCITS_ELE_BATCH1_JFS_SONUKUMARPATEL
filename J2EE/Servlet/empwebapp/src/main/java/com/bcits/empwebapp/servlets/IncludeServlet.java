package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String url ="./date.html";//(static)
		String url = "./currentDate";// (dynamic)

		// String url="";//500 (We can not include to External Recourse)
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>Hello User</h3>");
		out.print("</body>");
		out.print("</html>");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
		requestDispatcher.include(req, resp);

	}// End of doGet()

}// End of class
