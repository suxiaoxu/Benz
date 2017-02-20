package com.benz.nospring.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import com.benz.mybatis.model.User;

public class MyBatisTest implements Serializable {
	
	private static final long serialVersionUID = -9019841675073251647L;

	@Test
	public void testQuery() throws IOException{
		String resource = "mybatisNoSpringDB.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  User user = (User) session.selectOne("com.benz.mybatis.dao.UserDao.getUser1", 1);
		  System.out.println("user id = "+ user.getUserId() +" name = "+user.getUserName());
		} finally {
		  session.close();
		}
	}
	
	//@Test
	public void testQueryNo(){
		/*DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);*/
	}
}
