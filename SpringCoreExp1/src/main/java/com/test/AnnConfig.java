package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AnnConfig {
	@Bean
	@Scope(scopeName = "singleton")
	public Employee getSetterObj()
	{
		return new Employee();
	}
	
	@Bean
	public Employee getConstructorObj()
	{
		return new Employee(222, "Virat", "IPL");
	}
	
	
}
