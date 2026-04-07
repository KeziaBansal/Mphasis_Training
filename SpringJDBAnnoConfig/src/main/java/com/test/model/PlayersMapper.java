package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayersMapper implements RowMapper<Players>
{

	@Override
	public Players mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Players p = new Players();
		
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("p_name"));
		p.setTeam(rs.getString("p_team"));
		p.setPrice(rs.getInt("p_price"));
		
		
		return p;
	}

}
