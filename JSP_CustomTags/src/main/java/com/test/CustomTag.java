package com.test;

import java.util.Date;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class CustomTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	public int doStartTag()
	{
		JspWriter out=null;
		try
		{
			out = pageContext.getOut();
			out.println("Current Date : "+new Date());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
}
