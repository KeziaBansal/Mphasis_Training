package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Book obj = new Book();
		obj.setB_id(rs.getInt("b_id"));
		obj.setB_name(rs.getString("b_name"));
		obj.setB_author(rs.getString("b_author"));
		obj.setB_price(rs.getInt("b_price"));
		
		return obj;
	}
}
