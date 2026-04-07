package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.PlayerDao2;
import com.test.model.Players;

public class TestDemo1 {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
		
		PlayerDao2 dao = ctx.getBean(PlayerDao2.class);
		
		Players obj = new Players();
		
		obj.setId(555);
		obj.setName("Rahul");
		obj.setTeam("Pune");
		obj.setPrice(533);
		
		dao.createPlayers(obj);
		
		System.out.println("Done.");
		
		List<Players> list = dao.listAllPlayers();
		
		list.forEach(System.out::println);
	}
}
