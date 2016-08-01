package com.sxx.ioc.xml;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxx.ioc.xml.bean.MyClassAnnotation;
import com.sxx.ioc.xml.bean.Person;
import com.sxx.ioc.xml.bean.SpringContextUtil;

public class IocStudyXmlPath {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpStart(){
		context = new ClassPathXmlApplicationContext("IocApplicationContext.xml");
	}
	
	@Test
	public void test(){
		Person person = (Person) context.getBean("person");
		System.out.println(person.sub(2, 5));
		String sn[] = context.getBeanDefinitionNames();
		/*Map<String, Person> map=context.getBeansOfType(Person.class);
		for (String key : map.keySet()) {
			System.out.println("key= "+ key + " and value= " + map.get(key));
		}*/
		String sn1[] = context.getBeanNamesForAnnotation(MyClassAnnotation.class);
		Map<String,Object> maps = context.getBeansWithAnnotation(MyClassAnnotation.class);
		String sn2 [] = context.getBeanDefinitionNames();
		SpringContextUtil springContextUtil = (SpringContextUtil) context.getBean("springContext");
		System.out.println(springContextUtil.getBean("person"));
		System.out.println("");
	}
	

}
