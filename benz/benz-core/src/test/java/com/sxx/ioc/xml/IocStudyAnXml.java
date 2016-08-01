package com.sxx.ioc.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxx.ioc.ann.bean.Performer;
import com.sxx.ioc.ann.bean.Person;
import com.sxx.ioc.ann.bean.PersonT;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:IocAnnAplicationContext.xml" })
public class IocStudyAnXml {
	
	@Autowired
	ApplicationContext context;
	/*@Test
	public void test(){
		Performer eddie = (Performer) context.getBean("eddie");
	    eddie.perform();
	}*/
	
	/*@Autowired
	@Qualifier("persontest")
	private Person person;
	@Test
	public void test1(){
		//Performer eddie = (Performer) context.getBean("person");
		person.sub(3, 5);
	}*/
	
	@Autowired
	@Qualifier("persontest1")
	private PersonT person1;
	@Test
	public void test2(){
		//Performer eddie = (Performer) context.getBean("person");
		person1.sub(3, 5);
	}

}
