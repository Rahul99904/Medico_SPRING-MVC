package registration.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import registration.entities.hosp_regis;

public class Rowmapper implements RowMapper<hosp_regis>{

	public hosp_regis mapRow(ResultSet rs, int rowNum) throws SQLException {
		hosp_regis hsp=new hosp_regis();
		
		hsp.setEmail(rs.getString(1));
		hsp.setName(rs.getString(2));
		hsp.setAge(rs.getString(3));
		hsp.setDistyp(rs.getString(4));
		
		return hsp ;
	}

}
