package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


@WebListener
public class MyListener implements HttpSessionListener {

	public static ServletContext ctx=null;
	public static int current, total=0;
	
    public void sessionCreated(HttpSessionEvent se)  { 
        
    	total++;
    	current++;
    	
    	ctx=se.getSession().getServletContext();
    	ctx.setAttribute("tusers" , total);
    	ctx.setAttribute("cursers", current);
    	}

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
        current--;
        ctx.setAttribute("cursers", current);
        
    	
    }
	
}
