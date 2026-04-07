package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/ListUsers")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sql="select * from mlauser";
		
		PreparedStatement pst=DBConnection.getCon().prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		List<User> listUsers= new ArrayList<>();
		while(rs.next())
		{
			User obj= new User();
			obj.setId(rs.getInt(1));
			obj.setFullname(rs.getString(2));
			obj.setUsername(rs.getString(3));
			obj.setPassword(rs.getString(4));
			
			listUsers.add(obj);
		}
		
		ServletContext ctx=getServletContext();
		ctx.setAttribute("info", listUsers);
		
		if(listUsers.size()>0)
		{
			// response.sendRedirect("listusers.jsp");
			System.out.println(listUsers.size());
		}
		else
		{
			out.println("<center><font color='red'>No Data. Please add users</font><center>");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}

	

}
