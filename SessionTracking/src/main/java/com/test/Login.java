package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("Fr")
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String usr=request.getParameter("user");
		// Cookie ck=new Cookie("info", usr);
		// response.addCookie(ck);
		
		HttpSession session=request.getSession();
		ServletContext ctx=getServletContext();
		session.setAttribute("info",  usr);
		int total=(int) ctx.getAttribute("tusers");
		int current=(int)ctx.getAttribute("cusers");
		
		out.println("<h3>");
		out.println("Total users: " +total);
		out.println("<br>Current users: "+current);
		out.println("/<h3>");
		
		out.println("from login page: "+usr);
		out.println("<br><a href= 'Logout'> logout here </a>");
		
	}

}
