package com.seongJIn.Robot.DAO;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.seongJIn.Robot.Vo.FormatVo;

import static com.seongJIn.Robot.DAO.FormatSql.*;

@Repository
public class FormatDao {

	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	RowMapper<FormatVo> rowMapper =  BeanPropertyRowMapper.newInstance(FormatVo.class);
	
	public FormatDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("format")
				.usingGeneratedKeyColumns("id");
	}
	

	
	//	SELECT_BY_ID
	public FormatVo selectById(int id) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);	
	}
	
	
	//	INSERT
	public int insert(FormatVo formatVo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(formatVo);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
 	
 	//	DELETE
	public int deleteById(int id) {
			Map<String, ?> params = Collections.singletonMap("id", id);
			return jdbc.update(DELETE_BY_ID, params);
	}


}
