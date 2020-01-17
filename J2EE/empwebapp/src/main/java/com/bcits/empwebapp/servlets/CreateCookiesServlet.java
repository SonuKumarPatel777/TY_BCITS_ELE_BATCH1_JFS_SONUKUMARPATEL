package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookies")
public class CreateCookiesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie myCookie = new Cookie("empName", "SonuPate");
		myCookie.setMaxAge(7 * 24 * 60 * 60); // making cookie persistent for 7 days
		resp.addCookie(myCookie);

		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1 style='color:green'>Cookies created Successfully");
		out.print("</body>");
		out.print("</html>");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cookiePage.html");
		requestDispatcher.include(req, resp);

	}// End of doGet()

}// End of Class
