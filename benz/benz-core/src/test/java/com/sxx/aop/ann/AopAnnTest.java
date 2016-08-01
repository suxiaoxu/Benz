package com.sxx.aop.ann;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxx.aop.ann.bean.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:AopApplicationAnnContext.xml" })
public class AopAnnTest {
	
	
	@Autowired
	ApplicationContext context;

	@Test
	public void test1(){
		Person person = (Person)context.getBean("person");
		person.sub(4, 6);
	}
}
