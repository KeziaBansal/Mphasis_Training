package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("fname");
		String usr=request.getParameter("user");
		String pas=request.getParameter("pwd");
		User obj=new User();
		obj.setFullname(name);
		obj.setUsername(usr);
		obj.setPassword(pas);
		
		String sql="insert into mlauser(full_name, u_name, u_password) values(?,?,?)";
		PreparedStatement pst=DBConnection.getCon().prepareStatement(sql);
		pst.setString(1,  obj.getFullname());
		pst.setString(2, obj.getUsername());
		pst.setString(3,  obj.getPassword());
		pst.execute();
		
		
//		if(name!=null && usr!=null && pas!=null)
//		{
//			response.sendRedirect("login.jsp");
//		}
		
//		if(name.isEmpty() && usr.isEmpty() && pas.isEmpty())
//		{
//			response.sendRedirect("login.jsp");
//			
//		}
		
//		if(name.startsWith("[a-zA-Z") && usr.startsWith("[a-zA-Z]") && pas.startsWith("[a-zA-Z]"))
//		{
//			response.sendRedirect("login.jsp");
//		}
		
//		if(name.contentEquals("[a-zA-Z") && usr.contentEquals("[a-zA-Z]") && pas.contentEquals("[a-zA-Z]"))
//		{
//			response.sendRedirect("login.jsp");
//		}
		
		Pattern p=Pattern.compile("[a-zA-Z]+");
		
		if(p.matches(name,  obj.getFullname()) && p.matches(usr,  obj.getUsername()) && p.matches(pas, obj.getPassword()))
		{
			response.sendRedirect("login.jsp");
		}
		
		else
		{
			out.println("<center><font color='red'>Registration failed.</font></center>");
			RequestDispatcher rd= request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
