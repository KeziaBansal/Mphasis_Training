package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.PlayerDao;
import com.test.dao.PlayerDao1;
import com.test.model.Players;

public class TestDemo {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		PlayerDao dao = ctx.getBean("pdao2", PlayerDao.class);
		
		PlayerDao1 dao1 = ctx.getBean("pdao1", PlayerDao1.class);
		
		Players obj = new Players();
		
		obj.setId(333);
		obj.setName("SKY");
		obj.setTeam("Mumbai");
		obj.setPrice(6789);
		
		dao1.createPlayers(obj);
		
		//dao.createPlayers(obj);
		
		//dao.updatePlayer(obj);
		
		//dao.deletePlayer(obj);
		
		
		List<Players> list = dao.getAllPlayers();
		
		list.forEach(System.out::println);
		
		System.out.println("Done.");
	}
}
