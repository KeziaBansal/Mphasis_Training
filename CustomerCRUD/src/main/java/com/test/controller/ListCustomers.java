package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.test.dao.CustomerDaoImpl;
import com.test.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ListCustomers")
public class ListCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 
		 PrintWriter out = response.getWriter();
		 
		 CustomerDaoImpl daoObj = new CustomerDaoImpl();
		 
		 List<Customer> list = daoObj.listAllCustomers();
		 
		 ServletContext ctx = request.getServletContext();
		 
		 ctx.setAttribute("data", list);
		 
		 if(list.size() > 0)
		 {
			 response.sendRedirect("listcustomers.jsp");
		 }
		 else
		 {
			 	out.println("<font color = 'red' > No Customer Data please</font>");
				
				RequestDispatcher rd = request.getRequestDispatcher("customerform.jsp");
				
				rd.include(request, response);
		 }

	}
}
