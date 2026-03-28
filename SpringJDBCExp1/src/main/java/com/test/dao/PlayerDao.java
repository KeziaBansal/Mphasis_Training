package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.test.model.Players;

public class PlayerDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int createPlayers(Players p)
	{
		String sql = "insert into players values("+p.getId()+", '"+p.getName()+"', '"+p.getTeam()+"', "+p.getPrice()+")";
		
		return jdbcTemplate.update(sql);
	}
	
	public int updatePlayer(Players p)
	{
		String sql = "update players set p_name = '"+p.getName()+"', p_team = '"+p.getTeam()+"', p_price = "+p.getPrice()+" where id = "+p.getId();
		
		return jdbcTemplate.update(sql);
	}
	
	public int deletePlayer(Players p)
	{
		String sql = "delete from players where id = "+p.getId();
		
		return jdbcTemplate.update(sql);
	}
	
	public List<Players> getAllPlayers()
	{
		return jdbcTemplate.query("select * from players", new ResultSetExtractor<List<Players>>()
				{
					public List<Players> extractData(ResultSet rs)throws SQLException, DataAccessException
					{
						List<Players> list = new ArrayList<>();
						
						while(rs.next())
						{
							Players pobj = new Players();
							
							pobj.setId(rs.getInt(1));
							pobj.setName(rs.getString(2));
							pobj.setTeam(rs.getString(3));
							pobj.setPrice(rs.getInt(4));
							
							list.add(pobj);
						}
						
						return list;
					}
				}
				);
	}
	
	
}
