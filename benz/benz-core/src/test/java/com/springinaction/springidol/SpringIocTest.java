package com.springinaction.springidol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springinaction.ioc.PersonTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:com/springinaction/springidol/spring-ioc.xml" })
public class SpringIocTest {
	
	//private static Logger logger = LoggerFactory.getLogger(SpringIocTest.class);
	
	@Autowired
	ApplicationContext context;
	
	@Test
	 public void testPergormer() throws PerformanceException{
		PersonTest personTest = (PersonTest)context.getBean("personTest");
		System.out.println(personTest.sub(2, 4));
	 }

}
