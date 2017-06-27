package com.seongJIn.Robot.DAO;

public class FormatSql {
	static final String DELETE_BY_ID =
			"DELETE FROM format WHERE id= :id";
	
	
	static final String SELECT_BY_ID = 
			"SELECT id, url, rule FROM format where id = :id";
}
