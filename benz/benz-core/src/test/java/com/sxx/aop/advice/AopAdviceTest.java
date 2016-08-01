package com.sxx.aop.advice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxx.aop.advice.bean.MindReader;
import com.sxx.aop.advice.bean.Thinker;


/**
 * @author xiaoxu.sxx
 * 带有参数情况
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:AopApplicationAdviceContext.xml")
public class AopAdviceTest {

	@Autowired
	MindReader magician;

	@Autowired
	Thinker volunteer;

	// <start id="testMindReader"/>
	@Test
	public void magicianShouldReadVolunteersMind() {
		volunteer.thinkOfSomething("Queen of Hearts");
		//assertEquals("Queen of Hearts", magician.getThoughts());
	}

}
