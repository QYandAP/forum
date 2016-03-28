package com.apefactory.forum.test;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apefactory.forum.entity.Board;
import com.apefactory.forum.service.ForumService;
import com.apefactory.forum.service.UserService;

public class MostTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void UserDaoTest() {
		UserService userService = (UserService) ac.getBean("userService");
		userService.deleteByUserId(1);
	}
	
	@Test
	public void BoardDaoTest(){
		ForumService forumService = (ForumService) ac.getBean("forumService");
		
		Iterator<Board> iter = forumService.getAllBoard().iterator();

	}
}
