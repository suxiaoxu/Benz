package com.sxx.ioc.xml;

import static java.lang.System.setProperty;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxx.ioc.xml.bean.Person;
import com.sxx.ioc.xml.bean.PersonDestory;
import com.sxx.ioc.xml.bean.PersonInit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:IocApplicationContext.xml" })
public class IocStudyXml {

	@BeforeClass
	public static void setup() {
		setProperty("STANS_SONG", "Total Eclipse of the Heart");
	}

	@Autowired
	ApplicationContext context;

	
	/*@Test
	public void test(){
		Person person = (Person) context.getBean("person");
		System.out.println(person.sub(2, 5));
	}*/
	
	/*@Test
	public void test1(){
		PersonInit person = (PersonInit) context.getBean("personInit");
	}*/
	@Test
	public void test2(){
		PersonDestory person = (PersonDestory) context.getBean("personDestory");
	}
}
