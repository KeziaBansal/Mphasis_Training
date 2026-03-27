package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestDemo {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Student obj =  ctx.getBean("std", Student.class);
		
		System.out.println(obj);
		
		
		ExpressionParser exp = new SpelExpressionParser();
		
		Expression ex = exp.parseExpression("'Simple Spring EL(SpEL) example'");
		
		String data = ex.getValue(String.class);
		
		System.out.println(data+" Literals");
		
		Expression ex1 = exp.parseExpression("'Simple Spring EL(SpEL) example'".toUpperCase());
		
		String dt = ex1.getValue(String.class);
		
		System.out.println(dt);
		
		Expression ex2 = exp.parseExpression("500 * 2");
		
		Integer v = ex2.getValue(Integer.class);
		
		System.out.println(v);
		
		System.out.println("1000 * 2");
		
		String v1 = "200";
		
		String v2 = "300";
		
		v2.concat(v1);
		
		System.out.println(v2);
	}
}
