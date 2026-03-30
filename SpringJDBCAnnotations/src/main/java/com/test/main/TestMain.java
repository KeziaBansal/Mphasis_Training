package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.BookDao;
import com.test.model.Book;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
		BookDao dao = ctx.getBean(BookDao.class);
		Book book = new Book();
//		book.setB_id(101);
//		book.setB_name("Rich Kid");
//		book.setB_author("PU");
//		book.setB_price(123);
		
//		book.setB_id(201);
//		book.setB_name("Wings of Fire");
//		book.setB_author("APJ");
//		book.setB_price(345);
		
		book.setB_id(301);
		book.setB_name("Success of the student ");
		book.setB_author("Mr Vivekananda");
		book.setB_price(563);
		
		dao.saveBooks(book);
		
		// dao.updateBooks(book);
		// dao.deleteBook(book);
		
		System.out.println("Done.");
	}
}
