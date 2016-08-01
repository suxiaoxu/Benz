package com.benz.mybatis.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.benz.mybatis.dao.UserDao;
import com.benz.mybatis.model.User;

public class UserDaoTest {
	
	private static UserDao userDao = null;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
        	    "classpath:mybatisDB.xml");
		if(null == ctx){
			System.out.println("ctx is null");
		}
		userDao = (UserDao) ctx.getBean("userDao");
	
	}
	
	@Test
	public void searchUser(){
		User sear = new User();
		sear.setUserId(1);
		User user = userDao.getUser(sear);
	}
	

}
