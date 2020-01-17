package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie [] = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		if(cookie!=null) {
			for (Cookie cookie2 : cookie) {
				out.print("<h1> Cookie Name = "+ cookie2.getName());
				out.print("<br> Cookie valu = "+ cookie2.getValue()+"</h1>");
			}
		}else {
			out.print("<h1> Cookies not found </h1>");
		}
		
		out.print("</body>");
		out.print("</html>");
	
	}//End of doGet()

}//End of Class
