package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		// Cookie[] ck=request.getCookies();
		// out.println("from logout servlet :" +ck[0].getValue());
		HttpSession session=request.getSession();
		String usr=(String) session.getAttribute("info");
		out.println("Successfully logout :" +usr);
		session.invalidate();
		
		// out.println("from logout servlet: " + ck[0].getValue());
	}
}
