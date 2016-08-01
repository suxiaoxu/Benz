package com.sxx.ioc.xml;

import static java.lang.System.setProperty;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxx.ioc.xml.bean.Person;
import com.sxx.ioc.xml.bean.PersonDestory;
import com.sxx.ioc.xml.bean.PersonInit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:IocAnnoctionContext.xml" })
public class IocStudyAn {

	@BeforeClass
	public static void setup() {
		setProperty("STANS_SONG", "Total Eclipse of the Heart");
	}

	@Autowired
	ApplicationContext context;
	
	@Autowired
	@Qualifier("person")
	private Person person;
	
	@Resource(name = "personDestory")
	private PersonDestory personDestory;
	
	@Value("this is my book")
	private String sn;
	@Test
	public void test2() throws Exception{
		System.out.println(person.sub(5, 8));
		System.out.println(sn);
		personDestory.destroy();
	}
}
