package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;



@WebServlet("/Lifecycle")
public class Lifecycle extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	
		System.out.println("init()");
	}

	public void destroy() {
		
		System.out.println("destroy()");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		System.out.println("service() to process request & response");
	}

}
