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
import java.sql.ResultSet;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String usr=request.getParameter("user");
		String pas=request.getParameter("pwd");
		User obj = new User();
		obj.setUsername(usr);
		obj.setPassword(pas);
		
		String sql="select u_name, u_password from mlasuser where u_name= ? and u_password = ?";
		PreparedStatement pst=DBConnection.getCon().prepareStatement(sql);
		pst.setString(1, usr);
		pst.setString(2, pas);
		
		ResultSet rs=pst.executeQuery();
		
		User dbobj = new User();
		
		while(rs.next())
		{
			dbobj.setUsername(rs.getString(1));
			dbobj.setPassword(rs.getString(2));
			
			
		}
		if(obj.getUsername().equals(dbobj.getUsername()) && obj.getPassword().equals(dbobj.getPassword()))
		{
			response.sendRedirect("home.jsp");
		}
		else
		{
			out.println("<center><font color='red'>Invalid Credentials.</font></center>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
