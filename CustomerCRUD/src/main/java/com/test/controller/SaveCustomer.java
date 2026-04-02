package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.test.dao.CustomerDaoImpl;
import com.test.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveCustomer")
public class SaveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		
		Customer obj= new Customer();
		obj.setName(name);
		obj.setEmail(email);
		obj.setCity(city);
		
		CustomerDaoImpl daoObj= new CustomerDaoImpl();
		int x=daoObj.saveCustomer(obj);
		
		if(x>0)
		{
			response.sendRedirect("index.jsp");
			
		}
		else
		{
			out.println("<font color= 'red' > Customer Data Not Saved. </font>");
			RequestDispatcher rd=request.getRequestDispatcher("customerForm.jsp");
			rd.include(request, response);
		}
		
	}

}
