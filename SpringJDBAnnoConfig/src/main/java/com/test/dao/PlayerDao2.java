package com.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Players;
import com.test.model.PlayersMapper;

@Component
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class PlayerDao2 {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PlayerDao2(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String insert_sql = "insert into players (id, p_name, p_team, p_price)values(?,?,?,?)";
	
	private final String update_sql = "update players set p_name = ?, p_team = ?, p_price = ? where id = ? ";
	
	private final String delete_sql = "delete from players where id = ?";
	
	private final String select_sql = "select * from players";
	
	public boolean createPlayers(Players obj)
	{
		return jdbcTemplate.update(insert_sql, obj.getId(), obj.getName(), obj.getTeam(), obj.getPrice())>0;
	}
	
	public boolean updatePlayer(Players obj)
	{
		return jdbcTemplate.update(update_sql, obj.getName(), obj.getTeam(), obj.getPrice(), obj.getId())>0;
	}
	
	public boolean deletePlayer(Players obj)
	{
		return jdbcTemplate.update(delete_sql, obj.getId())>0;
	}
	
	public List<Players> listAllPlayers()
	{
		return jdbcTemplate.query(select_sql, new PlayersMapper());
	}
}
