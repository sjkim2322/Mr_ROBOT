package com.seongJIn.Robot.DAO;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.seongJIn.Robot.RobotApplication;
import com.seongJIn.Robot.Vo.FormatVo;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RobotApplication.class)
@Transactional
public class FormatDaoTest {
	
	@Autowired
	private FormatDao dao;


 
	@Test
	public void shouldInsertAndSelect() {
		// given
		FormatVo formatVo = new FormatVo();
		formatVo.setRule("TEST RULE");
		formatVo.setUrl("TEST URL");

		// when
		int id = dao.insert(formatVo);

		// then
		FormatVo selected = dao.selectById(id);
		System.out.println(selected.toString());
		assertThat(selected.getUrl(), is("TEST URL"));
	}
	
//	@Test
//	public void shouldDelete() {
//		//given
//		Todo todo = new Todo("textTodo1");
//		int testId = dao.insert(todo);
//		
//		//when
//		int affected = dao.deleteById(testId);
//		
//		//then
//		assertThat(affected,is(1));
//	}
//	
//	@Test
//	public void shouldSelectOrderBY() {
//		
//		//given
//		Todo todo = new Todo("textTodo1");
//		int id1 = dao.insert(todo);
//		
//		Todo todo1 = new Todo("textTodo2");
//		int id2 = dao.insert(todo1);
//		
//		todo = dao.selectById(id1);
//		todo1 = dao.selectById(id2);
//		
//		//when
//		List<Todo> todoList = dao.selectAll();
//		
//		//then
//		assertThat(todoList,is(notNullValue()));
//		assertThat(todoList.get(0).getDate(),is(todo.getDate()));
//		assertThat(todoList.get(1).getDate(),is(todo1.getDate()));
//	}
	
	


}

