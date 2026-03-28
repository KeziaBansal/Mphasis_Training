package com.test.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.test.model.Players;

public class PlayerDao1 {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void createPlayers(Players p)
	{
		String sql = "insert into players(id, p_name, p_team, p_price)values(:p_id, :p_name, :p_team, :p_price)";
		
		MapSqlParameterSource mapsql = new MapSqlParameterSource();
		
		mapsql.addValue("p_id", p.getId());
		mapsql.addValue("p_name", p.getName());
		mapsql.addValue("p_team", p.getTeam());
		mapsql.addValue("p_price", p.getPrice());
		
		namedParameterJdbcTemplate.update(sql, mapsql);
	}
}
